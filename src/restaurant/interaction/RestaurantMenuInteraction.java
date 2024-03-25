package restaurant.interaction;

import restaurant.Main;
import restaurant.Restaurant;
import restaurant.building_blocks.menu.InterActiveMenu;
import restaurant.building_blocks.order.OrdersQueue;
import restaurant.building_blocks.menu.RestaurantMenu;
import restaurant.building_blocks.order.TableOrder;
import restaurant.building_blocks.person.employee.Cook;
import restaurant.building_blocks.person.employee.Waiter;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.product.Product;
import restaurant.building_blocks.product.ProductPerKilogram;
import restaurant.building_blocks.product.ProductPerLitre;
import restaurant.building_blocks.table.Table;
import restaurant.building_blocks.order.Order;

import java.util.*;

public class RestaurantMenuInteraction {
    private final Restaurant restaurant;
    private final InterActiveMenu interActiveMenu;
    private final Waiter waiter;
    private final Table[] tables;
    private final RestaurantMenu menu;

    private final Scanner scan;

    public RestaurantMenuInteraction(Restaurant restaurant, Scanner scan) {
        this.restaurant = restaurant;
        this.interActiveMenu = new InterActiveMenu();
        this.menu = new RestaurantMenu();
        Table table1 = new Table(menu, 4, new Random().nextInt(3) + 1);
        Table table2 = new Table(menu, 4, new Random().nextInt(8) + 4);
        this.tables = new Table[]{table1, table2};
        this.waiter = new Waiter(restaurant.getKitchen(), tables, new Random().nextInt(3) + 1,2200,1);
        this.scan = scan;
    }

    public void go() {
        ArrayList<Product> products = new ArrayList<>();

        InterActiveMenu interactWithClient = new InterActiveMenu();
        interactWithClient.interactWithTheMenu(scan);
        getIngredients(products, interactWithClient.getOrdersQueue());
//        updateTableOrder(table.getTableOrder(), interactWithClient.getOrdersQueue());

        // Stock Before Cooking
        HashMap<Product, Double> stockBefore = getStock(products);

        Cook cook = new Cook(tables[0].getTableOrder(), restaurant.getKitchen().getStorage(),2500);
        for (int i = 0; i < interactWithClient.getOrdersQueue().getSze(); i++) {
            ArrayList<Meal> result = cook.cookMeals(interactWithClient.getOrdersQueue().getOrderElement(i));
        }

        double turnoverBeforeOrder = restaurant.getTurnover();
        restaurant.updateTurnover(interactWithClient.getOrdersQueue());
        updateTips(waiter, interactWithClient.getOrdersQueue());

        System.out.println("\n");
        printOrderDetails(interactWithClient.getOrdersQueue());
        System.out.println("\n");
        printFinance(100000.0, turnoverBeforeOrder, restaurant.getTurnover());
        System.out.println("\n");
        printStock(stockBefore, products);

        scan.close();
        return;
    }

    private void updateTips(Waiter waiter, OrdersQueue ordersQueue) {
        for (int i = 0; i < ordersQueue.getSze(); i++) {
            Random random = new Random();
            double tips = 0.0;
            if (random.nextInt(10) % 2 == 0) {
                tips = ordersQueue.getOrderElement(i).calculateTotalPrice() * Main.TIPS;
            }
            waiter.updateTips(tips);
        }
    }

    private void printFinance(Double restaurantStart, Double restaurantLoad, Double profit) {
        System.out.println("| ----------------------------- FINANCE DETAILS ------------------------------ |");
        System.out.println("| ---------------------------------------------------------------------------- |");
        System.out.println("| Starting Turnover       | After Storage Load       | After Completing Orders |");
        System.out.println("| ---------------------------------------------------------------------------- |");
        System.out.printf("| %23.02f | %24.02f | %23.02f |%n", restaurantStart, restaurantLoad, profit);
        System.out.println("| ---------------------------------------------------------------------------- |");

    }

    private void printOrderDetails(OrdersQueue orders) {
        System.out.println("| ------------------------------ ORDER DETAILS ------------------------------- |");
        System.out.println("| ---------------------------------------------------------------------------- |");
        System.out.println("| Table #         | Waiter #        | Order #         | Order TOTAL:           |");
        System.out.println("| ---------------------------------------------------------------------------- |");
        for (int i = 0; i < orders.getSze(); i++) {
            double total = orders.getOrderElement(i).calculateTotalPrice();
            Random random = new Random();
            System.out.printf("| %-15d | %-15d | %-15d | %22.02f |%n", waiter.getTables()[random.nextInt(4) % 2].getNumber(), waiter.getWaiterNumber(),
                    orders.getOrderElement(i).getOrderID(), orders.getOrderElement(i).calculateTotalPrice());
        }
        System.out.println("| ---------------------------------------------------------------------------- |");
    }


    private HashMap<Product, Double> getStock(ArrayList<Product> products) {
        HashMap<Product, Double> stock = new HashMap<>();

        for (Product product : products) {
            stock.put(product, restaurant.getKitchen().getStorage().getStock(product.getName()));
        }

        return stock;
    }


    private void printStock(HashMap<Product, Double> stockBefore, ArrayList<Product> products) {
        System.out.println("| ----------------------------- STORAGE DETAILS ------------------------------ |");
        System.out.println("| Product Name                   |         Stock Before |          Stock After |");
        System.out.println("| ---------------------------------------------------------------------------- |");
        for (int i = 0; i < products.size(); i++) {
            String type = getProductType(products.get(i));
            String productName = products.get(i).getName();
            double productStockAfter = restaurant.getKitchen().getStorage().getStock(products.get(i).getName());
            System.out.printf("| %-30s | %-17.02f%s | %-17.02f%s |%n", productName, stockBefore.get(products.get(i)), type, productStockAfter, type);
        }
        System.out.println("| ---------------------------------------------------------------------------- |");
    }

    private String getProductType(Product product) {
        String result = "";
        if (product instanceof ProductPerKilogram) {
            result = " kg";
        } else if (product instanceof ProductPerLitre) {
            result = "ltr";
        } else {
            result = "pcs";
        }
        return result;
    }

    private void getIngredients(ArrayList<Product> products, OrdersQueue ordersQueue) {
        int size = ordersQueue.getSze();

        for (int i = 0; i < size; i++) {
            Order order = ordersQueue.getOrderElement(i);
            HashMap<Meal, Integer> meals = order.getMeals();
            for (Map.Entry<Meal, Integer> entry : meals.entrySet()) {
                for (Map.Entry<Product, Integer> product : entry.getKey().getRecipe().getIngredients().entrySet()) {
                    if (!products.contains(product.getKey())) {
                        products.add(product.getKey());
                    }
                }
            }
        }
    }

    private void updateTableOrder(TableOrder tableOrder, OrdersQueue ordersQueue) {
        int size = ordersQueue.getSze();
        for (int i = 0; i < size; i++) {
            tableOrder.add(ordersQueue.getOrderElement(i));
        }
    }

}
