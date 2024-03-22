package restaurant.simulation;


import restaurant.ClientsGroup;
import restaurant.Restaurant;

import java.util.ArrayList;

public class RestaurantSimulator {

    private final WorkDay workDay;
    private final Restaurant restaurant;


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

        ArrayList<ClientsGroup> groupsArray = new ArrayList<>();
        int groupNumber = 1;

        WorkDay.history.addData(restaurant.toString());

        restaurant.getOwner().openRestaurant();
        WorkDay.history.addData("Open restaurant time =" + WorkDay.getTime());
        WorkDay.history.addData("Turnover in the beginning =" + Restaurant.turnover);
        WorkDay.history.addData("Storage at the beginning of the day :\n" + restaurant.getKitchenStorageStock());
        while (workDay.isRun()) {

            if (restaurant.isOpenRestaurant()) {
                //clean the restaurant
                if (restaurant.isCleaningTime(WorkDay.getTime())) {
                    restaurant.getCleaner().cleanRestaurant();

                } else
                    //invite clients
                    if (restaurant.getOccupiedTablesNumber() < workDay.getHourlyLoad()) {

                        ClientsGroup group = new ClientsGroup(groupNumber, restaurant.getTables());
                        groupsArray.add(group);
                        Thread t = new Thread(group);
                        t.start();
                        groupNumber++;
                    }
            }
        }
        WorkDay.history.addData("Turnover in the end =" + Restaurant.turnover);
        WorkDay.history.addData("Storage at the end of thr day :\n" + restaurant.getKitchenStorageStock());
        for (ClientsGroup clientsGroup : groupsArray) {
            WorkDay.history.addData(clientsGroup.toString());
        }
        WorkDay.history.print();
    }
}
