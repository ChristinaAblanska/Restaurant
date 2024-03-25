package restaurant.simulation;


import restaurant.ClientsGroup;
import restaurant.Restaurant;
import restaurant.building_blocks.TableOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RestaurantSimulator {

    private final WorkDay workDay;
    private final Restaurant restaurant;
    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    public RestaurantSimulator(Restaurant restaurant) {
        this.restaurant = restaurant;
        workDay = new WorkDay();
    }

    public void startSimulation() {

        workDay.start();
        try {
            workDay.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int groupNumber = 1;

        WorkDay.historyAsString.addData(restaurant.toString());
        List<ClientsGroup> clients = new ArrayList<>();

        restaurant.getManager().openRestaurant();

        executor.submit(restaurant.getWaiter_1Thread());
        executor.submit(restaurant.getWaiter_2Thread());


        WorkDay.historyAsString.addData("Open restaurant time =" + WorkDay.getTime());
        WorkDay.historyAsString.addData("Turnover in the beginning =" + Restaurant.turnover);
        // WorkDay.historyAsString.addData("Storage at the beginning of the day :\n" + restaurant.getKitchenStorageStock());
        while (workDay.isRun()) {

            if (restaurant.isOpenRestaurant()) {
                //clean the restaurant
                if (restaurant.isCleaningTime(WorkDay.getTime())) {
                    restaurant.getCleaner().cleanRestaurant();

                } else
                    //invite clients
                    if (restaurant.getOccupiedTablesNumber() < workDay.getHourlyLoad()) {

                        ClientsGroup gr = new ClientsGroup(groupNumber, restaurant);
                        clients.add(gr);
                        executor.submit(gr);

                        groupNumber++;

                    }
            }
        }
        restaurant.getOwner().payWaitersSalaries();
        restaurant.getOwner().payCookSalary();
        restaurant.getOwner().payManagerSalary();
        restaurant.getOwner().payCleanerSalary();

        restaurant.getManager().closeRestaurant();
        // WorkDay.historyAsString.addData("Storage after end of the day :\n" + restaurant.getKitchenStorageStock());
        executor.shutdown();

        WorkDay.historyAsString.addData("Turnover in the end =" + Restaurant.turnover);

        for (ClientsGroup group : clients) {
            WorkDay.historyAsString.addData(group.toString());
        }
        //Get the most ordered mails

        for (ClientsGroup group : clients) {
            TableOrder t_o = group.getTableOrder();

            WorkDay.historyAsString.addData(group.toString());
        }
        WorkDay.historyAsString.print();
        System.exit(0);
    }
}
