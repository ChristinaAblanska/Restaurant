package restaurant;

import restaurant.building_blocks.Client;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.Table;
import restaurant.building_blocks.TableOrder;

import java.util.*;

public class ClientsGroup implements Runnable {
    public static Random RANDOM = new Random();
    private final int groupNumber;
    private String incomingHour;
    private String outComingHour;
    private Client[] clients;
    private Table table;

    public ClientsGroup(int groupNumber, Restaurant restaurant) {
        this.incomingHour = WorkDay.getTime().toString();
        this.groupNumber = groupNumber;
        createMembers(restaurant.getSingleTableCapacity());
        //set table randomly here
        setRandomFurniture(restaurant);

    }

    public void run() {

        incomingHour = WorkDay.getTime().toString();

        TableOrder tableOrder = table.getTableOrder();
        for (Client client : clients) {

            Order individualOrder = new Order();
            //order.addMeal(client.pickMeal(table.getMenu()), 1);
            //order.addDrink(client.pickDring(table.getMenu()), 1);
            tableOrder.add(individualOrder);
            client.setIndividualOrder(individualOrder);
        }

        tableOrder.setStatus(OrderStatus.ACTIVE);

        synchronized (tableOrder) {
            while (!tableOrder.getStatus().equals(OrderStatus.IN_PROGRESS)) {
                try {
                    tableOrder.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        synchronized (tableOrder) {
            while (!tableOrder.getStatus().equals(OrderStatus.COMPLETED)) {
                try {
                    tableOrder.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        table.setOccupied(false);
        outComingHour = WorkDay.getTime().toString();
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
        StringBuilder data = new StringBuilder();
        data.append("Group number:").append(groupNumber);
        data.append(" | Incoming time:").append(incomingHour);
        data.append(" | Outcoming time:").append(outComingHour);
        data.append(" | Clients number:").append(clients.length);
        data.append(" | Table number:").append(table.getNumber());
        data.append("\n");

        for (int i = 0; i < clients.length; i++) {
            Client client = clients[i];
            data.append("    Client :").append(client.getClientNumber()).append("\n")
                    .append(client.getIndividualOrder().toString());
        }
        data.append("----------------------------------------------------------------------------------------------");
        return String.valueOf(data);
    }
}
