package restaurant;

import restaurant.building_blocks.Client;
import restaurant.building_blocks.Order;
import restaurant.building_blocks.table.Table;
import restaurant.building_blocks.TableOrder;
import restaurant.simulation.WorkDay;

import java.util.*;

public class ClientsGroup implements Runnable {
    public static Random RANDOM = new Random();
    private final int groupNumber;
    private String incomingHour;
    private String outComingHour;
    private Client[] clients;
    private Table table;

    public ClientsGroup(int groupNumber, Table[] tables) {
        this.groupNumber = groupNumber;
        setRandomTable(tables);
        createRandomAmmoundOfClients(table.getCapacity());
    }

    public void run() {

        incomingHour = WorkDay.getTime().toString();

        TableOrder tableOrder = table.getTableOrder();
        for (Client client : clients) {

            Order individualOrder = new Order();

            //Pick random number of meals
            int numberOfMeals = RANDOM.nextInt(1, 4);
            for (int i = 0; i < numberOfMeals + 1; i++) {
                int numberOfMeal = RANDOM.nextInt(1, 3);
                individualOrder.addMeal(client.pickRandomMeal(RANDOM, table.getMenu()), numberOfMeal);
            }

            int numberOfDrinks = RANDOM.nextInt(1, 4);
            individualOrder.addDrink(client.pickRandomDrink(RANDOM, table.getMenu()), numberOfDrinks);

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


     /*   for (Order order : tableOrder) {
            if (order.getOrderStatus().equals(OrderStatus.REVOKE)) {

                //System.out.println(this);
            }
        }*/
        tableOrder.setStatus(OrderStatus.BLANK);
        table.setOccupied(false);
        outComingHour = WorkDay.getTime().toString();
    }

    public void setRandomTable(Table[] tables) {
        List<Table> freeTables = pickAllFreeTables(tables);
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

    public void createRandomAmmoundOfClients(int clientsNumber) {
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
        data.append(" | Waiter:").append(table.getTableOrder().getWaiter().getWaiterNumber());
        data.append("\n");

        for (int i = 0; i < clients.length; i++) {
            Client client = clients[i];
            data.append("    Client :").append(client.getClientNumber()).append(" >>").append(client.getIndividualOrder().getOrderStatus()).append("\n")
                    .append(client.getIndividualOrder().toString());
        }
        data.append("----------------------------------------------------------------------------------------------");
        return String.valueOf(data);
    }
}
