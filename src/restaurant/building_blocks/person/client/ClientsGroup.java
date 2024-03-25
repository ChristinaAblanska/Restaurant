package restaurant.building_blocks.person.client;

import restaurant.Restaurant;
import restaurant.building_blocks.order.Bill;
import restaurant.building_blocks.order.Order;
import restaurant.building_blocks.order.OrderStatus;
import restaurant.building_blocks.order.TableOrder;
import restaurant.building_blocks.person.client.Client;
import restaurant.building_blocks.table.Table;
import restaurant.simulation.WorkDay;

import java.util.*;

public class ClientsGroup implements Runnable {
    public static Random RANDOM = new Random();
    private final int groupNumber;
    private String incomingHour;
    private String outComingHour;
    private Client[] clients;
    private Table table;
    private final TableOrder tableOrder;
    private TableOrder backupTableOrder;

    public ClientsGroup(int groupNumber, Restaurant restaurant) {
        this.groupNumber = groupNumber;
        setRandomTable(restaurant.getTables());
        createRandomAmmoundOfClients(table.getCapacity());
        tableOrder = table.getTableOrder();
        Order individualOrder;
        for (Client client : clients) {

            individualOrder = new Order();
            //order at least 5 meals
            int mealsCount = RANDOM.nextInt(1, 6);
            for (int i = 0; i < mealsCount; i++) {
                int numberOfTheMeal = RANDOM.nextInt(1, 3);
                individualOrder.addMeal(client.pickRandomMeal(RANDOM, table.getMenu()), numberOfTheMeal);
            }
            int beverageCount = RANDOM.nextInt(1, 6);
            individualOrder.addDrink(client.pickRandomDrink(RANDOM, table.getMenu()), beverageCount);

            tableOrder.add(individualOrder);
            client.setIndividualOrder(individualOrder);
        }
    }

    public void run() {

        incomingHour = WorkDay.getTime().toString();
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
        for (Order ord : tableOrder) {
            if (ord.getOrderStatus().equals(OrderStatus.REVOKE_BY_KITCHEN)) {
                ord.setOrderStatus(OrderStatus.COMPLIMENTS);
            }
        }
        backupTableOrder = tableOrder.clone();
        //Get the price for every client bill to form the total bill for the table.
        Bill bill;
        double totalBillPrice = 0;
        for (Order order : tableOrder) {
            bill = new Bill(order);
            totalBillPrice += bill.getTotalSum();
        }
        Restaurant.turnover += totalBillPrice;
        table.releaseDinnerTable();
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

    public TableOrder getTableOrder() {
        return backupTableOrder;
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

        for (Client client : clients) {
            data.append("    Client :").append(client.getClientNumber()).append(" >>").append(client.getIndividualOrder().getOrderStatus()).append("\n")
                    .append(client.getIndividualOrder().toString());
        }
        data.append("----------------------------------------------------------------------------------------------");
        return String.valueOf(data);
    }
}
