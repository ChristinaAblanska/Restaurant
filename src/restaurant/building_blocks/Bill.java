package restaurant.building_blocks;

import java.util.Map;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

public class Bill {
    public Order order;

    public Bill(Order order) {
        this.order = order;
    }

    public void printBill(){
        System.out.printf("%-30s%t%-3s%t%-5s%t%-5s%n", "DESCRIPTION", "QTY", "PRICE", "TOTAL");
        for(Map.Entry<Meal, Integer> meal : order.getMeals().entrySet()){
            double total = (meal.getKey().getPrice() * meal.getValue());
            System.out.printf("%-30s%t%-3d%t%-5.2f%t%-5.2f%n", meal.getKey().getName(), meal.getValue(), meal.getKey().getPrice(), total);
        }
        for(Map.Entry<Beverage, Integer> drink : order.getDrinks().entrySet()){
            double total = (drink.getKey().getPrice() * drink.getValue());
            System.out.printf("%-30s%t%-3d%t%-5.2f%t%-5.2f%n", drink.getKey().getName(), drink.getValue(), drink.getKey().getPrice(), total);
        }
        System.out.printf("                                 TOTAL: %.2f%n", order.calculateTotalPrice());
    }
}
