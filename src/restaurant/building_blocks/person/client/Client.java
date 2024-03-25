package restaurant.building_blocks.person.client;

import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.menu.RestaurantMenu;
import restaurant.building_blocks.order.Order;

import java.util.List;
import java.util.Random;

public class Client {

    //Клиентите може да поръчват по няколко неща, може да оставят или да не оставят бакшиши.
    private final int clientNumber;
    private Order individualOrder;

    public Order getIndividualOrder() {
        return individualOrder;
    }

    public void setIndividualOrder(Order individualOrder) {
        this.individualOrder = individualOrder;
    }

    public Client(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                '}';
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public Meal pickRandomMeal(Random rand, RestaurantMenu menu) {
        List<Meal> meals = menu.getMeals();
        int target = rand.nextInt(0, meals.size());
        return meals.get(target);
    }

    public Beverage pickRandomDrink(Random rand, RestaurantMenu menu) {
        List<Beverage> beverages = menu.getBeverages();
        int target = rand.nextInt(0, beverages.size());
        return beverages.get(target);
    }

}