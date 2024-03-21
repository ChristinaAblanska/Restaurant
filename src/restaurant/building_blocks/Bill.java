package restaurant.building_blocks;

import java.util.Map;
import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

public class Bill {
    public Order order;
    private double totalSum;

    public Bill(Order order) {
        this.order = order;
        this.totalSum = calculateTotal();
    }

    private double calculateTotal() {
        double orderPrice = order.calculateTotalPrice();
        double tips = orderPrice * 0.1;

        return orderPrice - tips;
    }

    public void printBill(){
        double total = 0.0;

        StringBuilder result = new StringBuilder();
        result.append("--------------- #").append(order.getOrderID()).append(" ---------------\n")
                .append("                                      \n");

        for (Map.Entry<Meal, Integer> entry : order.getMeals().entrySet()) {
            double price = entry.getKey().getPrice();
            int mealAmount = entry.getValue();
            double totPrice = price * mealAmount;

            int firstSpaceCount = 38 - (entry.getKey().getName().length() + String.format("%.2f", price).length());
            int secondSpaceCount = 36 - (String.valueOf(mealAmount).length() + String.format("%.2f", totPrice).length());

            result
                    .append(entry.getKey().getName())
                    .append(" ".repeat(firstSpaceCount))
                    .append(String.format("%.2f", price))
                    .append("\n")
                    .append("x ")
                    .append(mealAmount)
                    .append(" ".repeat(secondSpaceCount))
                    .append(String.format("%.2f", totPrice))
                    .append("\n");

            total += totPrice;
        }
        for (Map.Entry<Beverage, Integer> entry : order.getDrinks().entrySet()) {
            double price = entry.getKey().getPrice();
            int drinksAmount = entry.getValue();
            double totPrice = price * drinksAmount;

            int firstSpaceCount = 38 - (entry.getKey().getName().length() + String.format("%.2f", price).length());
            int secondSpaceCount = 36 - (String.valueOf(drinksAmount).length() + String.format("%.2f", totPrice).length());

            result
                    .append(entry.getKey().getName())
                    .append(" ".repeat(firstSpaceCount))
                    .append(String.format("%.2f", price))
                    .append("\n")
                    .append("x ")
                    .append(drinksAmount)
                    .append(" ".repeat(secondSpaceCount))
                    .append(String.format("%.2f", totPrice))
                    .append("\n");

            total += totPrice;
        }
        result.append("\n--------------------------------------\n");
        result.append("TOTAL: ")
                .append(" ".repeat(31 - String.format("%.2f", total).length()))
                .append(String.format("%.2f", total));
        System.out.println(result.toString());
    }
}
