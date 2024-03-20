package restaurant;

import restaurant.building_blocks.Client;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientsGroup implements Runnable {
    Random RANDOM = new Random();
    private final int groupNumber;
    private final String incomingHour;
    private String outComingHour;
    private Client[] clients;
    private Table table;
    private final Order order = new Order();

    public ClientsGroup(int groupNumber, Restaurant restaurant) {
        this.incomingHour = WorkDay.getTime().toString();
        this.groupNumber = groupNumber;
        createMembers(restaurant.getSingleTableCapacity());
        //set table randomly here
        setRandomFurniture(restaurant);
        order.setOrderStatus(OrderStatus.ACTIVE);
        order.setAcceptTime( WorkDay.getTime().toString());
    }

    public void run() {

        for (Client client : clients) {
            //order.addMeal(client.pickMeal(table.getMenu()), 1);
            //order.addDrink(client.pickDring(table.getMenu()), 1);
        }

        table.setOrder(order);

        synchronized (order) {
            while (!order.getOrderStatus().equals(OrderStatus.IN_PROGRESS)) {
                try {
                    order.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (order) {
            while (!order.getOrderStatus().equals(OrderStatus.COMPLETED)) {
                try {
                    order.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        table.setOccupied(false);
        outComingHour =  WorkDay.getTime().toString();
    }

    public void setRandomFurniture(Restaurant restaurant) {
        List<Table> freeTables = pickAllFreeTables(restaurant.getTables());
        if (!freeTables.isEmpty()) {
            int number = 0;
            if (freeTables.size() > 1) {
                number = RANDOM.nextInt(1, freeTables.size());
            }
            Table t = freeTables.get(number);
            t.setOccupied(true);
            this.table = t;
        }
    }

    private List<Table> pickAllFreeTables(Table[] tables) {
        List<Table> freeTables = new ArrayList<>();
        for (Table t : tables) {
            if (!t.isOccupied()) {
                freeTables.add(t);
            }
        }
        return freeTables;
    }

    public void createMembers(int clientsNumber) {
        int num = RANDOM.nextInt(0, clientsNumber + 1);
        if (num == 0) {
            num = 1;
        }
        clients = new Client[num];
        for (int i = 0; i < num; i++) {
            clients[i] = new Client(i + 1);
        }
    }

    @Override
    public String toString() {

        return "Group Number:" + groupNumber +
                "|Incoming Hour:" + incomingHour +
                "|Out coming Hour:" + outComingHour+
                "|Order accept time:" + order.getAcceptTime() +
                "|Order complete time:" + order.getCompleteTime() +
                " |Clients count:" + clients.length +
                " |Table Number:" + table.getNumber() +
                " |Order status:" + order;
    }
}
