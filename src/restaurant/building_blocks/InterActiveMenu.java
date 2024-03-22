package restaurant.building_blocks;

import restaurant.OrderStatus;
import restaurant.building_blocks.food.Meal;
import restaurant.building_blocks.food.Beverage;

import java.util.Scanner;

public class InterActiveMenu {
    private static final OrdersQueue ordersQueue = new OrdersQueue();

    public static OrdersQueue getOrdersQueue() {
        return ordersQueue;
    }

    public void interactWithTheMenu(Scanner scan) {
        int choice = 0;
        Menu menu = new Menu();

        menu.showMainActionMenu();
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice <= 6) {
            switch (choice) {
                // Create a new order
                case 1:
                    menu.showNewOrderSubMenu();
                    Order order = createNewOrder(menu, scan);
                    if (!order.isEmpty()) {
                        order.setOrderStatus(OrderStatus.ACTIVE);
                        ordersQueue.addOrder(order);
                    }
                    break;
                // Update and order by id
                case 2:
                    int idToUpdate = getOrderId(scan);
                    if (ordersQueue.getOrderQueue().isEmpty()) {
                        System.out.println("No orders to update!\n");
                        break;
                    } else {
                        System.out.println(ordersQueue.getOrder(idToUpdate).toString());
                        ordersQueue.removeOrder(idToUpdate);
                        menu.showNewOrderSubMenu();
                        Order newOrder = createNewOrder(menu, scan);
                        if (!newOrder.isEmpty()) {
                            newOrder.setOrderStatus(OrderStatus.ACTIVE);
                            ordersQueue.addOrder(newOrder);
                        }
                    }
                    break;
                // Revoke an order by id
                case 3:
                    int idToRemove = getOrderId(scan);
                    if (ordersQueue.getOrderQueue().isEmpty()) {
                        System.out.println("No orders to revoke!\n");
                        break;
                    } else {
                        if (ordersQueue.removeOrder(idToRemove)) {
                            System.out.println("Order #" + idToRemove + " is revoked!\n");
                        } else {
                            System.out.println("Sorry, the order is being processed!\n");
                        }
                    }
                    break;
                // Show main menu
                case 4:
                    menu.showMainRecipeMenu();
                    System.out.println();
                    break;
                // Print Order
                case 5:
                    int idToPrint = getOrderId(scan);
                    if (ordersQueue.containsOrder(idToPrint)) {
                        Order orderToPrint = ordersQueue.getOrder(idToPrint);
                        Bill bill = new Bill(orderToPrint);
                        bill.printBill();
                    } else {
                        System.out.println("Order #" + idToPrint + " does not exist!\n");
                    }
                    break;
                default:
                    return;
            }
            menu.showMainActionMenu();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
    }

    private int getChoice(Scanner scan) {
        String choice;
        do {
            choice = scan.nextLine();
            if (choice.matches("\\d")) {
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        } while (!(scan.hasNextInt()) || !choice.matches("\\d"));
        return Integer.parseInt(choice);
    }

    private int getOrderId(Scanner scan) {
//        int id = 0;
//        System.out.println("Enter id: ");
//        id = Integer.parseInt(scan.nextLine());
//        while (id < 10000 || id > 19999) {
//            System.out.println("Invalid input! Please try again!");
//            id = Integer.parseInt(scan.nextLine());
//        }
//        return id;

        String id;
        System.out.println("Enter id: ");
        id = scan.nextLine();
        while (!id.matches("[1]\\d\\d\\d\\d")) {
            System.out.println("Invalid input! Please try again!");
            id = scan.nextLine();
        }
        return Integer.parseInt(id);
    }

    private Order createNewOrder(Menu menu, Scanner scan) {
        Order order = new Order();
        int choice = 1;
        RecipeGenerator recipeGenerator = new RecipeGenerator();

//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice <= 7) {
            switch (choice) {
                case 1:
                    menu.showSalads();
                    orderSalad(order, scan, recipeGenerator, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 2:
                    menu.showSoups();
                    orderSoup(order, scan, recipeGenerator, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 3:
                    menu.showPreCourse();
                    orderPreCourse(order, scan, recipeGenerator, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 4:
                    menu.showMainCourse();
                    orderMainCourse(order, scan, recipeGenerator, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 5:
                    menu.showDesserts();
                    orderDesserts(order, scan, recipeGenerator, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 6:
                    menu.showBeverages();
                    orderBeverages(order, scan, menu);
                    menu.showNewOrderSubMenu();
                    break;
                case 7:
                    System.out.println(order.toString());
                    return order;
            }
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
        return order;
    }

    private void orderSalad(Order order, Scanner scan, RecipeGenerator recipeGenerator, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Meal greenSalad = new Meal("Green Salad", recipeGenerator.generateGreenSalad());
                    int countGreenSalads = getAmount(scan, "Green Salad");
                    order.addMeal(greenSalad, countGreenSalads);
                    break;
                case 2:
                    Meal cabbageCarrots = new Meal("Cabbage and Carrots Salad", recipeGenerator.generateCabbageCarrotSalad());
                    int countCabbageSalads = getAmount(scan, "Cabbage and Carrots Salad");
                    order.addMeal(cabbageCarrots, countCabbageSalads);
                    break;
                case 3:
                    Meal shopskaSalad = new Meal("Shopska Salad", recipeGenerator.generateShopskaSalad());
                    int countshopskaSalads = getAmount(scan, "Shopska Salad");
                    order.addMeal(shopskaSalad, countshopskaSalads);
                    break;
                case 4:
                    Meal shepardSalad = new Meal("Shepard's Salad", recipeGenerator.generateShopskaSalad());
                    int countShepardSalads = getAmount(scan, "Shepard's Salad");
                    order.addMeal(shepardSalad, countShepardSalads);
                    break;
                default:
                    return;
            }
            menu.showSalads();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
        return;
    }

    private void orderSoup(Order order, Scanner scan, RecipeGenerator recipeGenerator, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Meal tarator = new Meal("Tarator", recipeGenerator.generateTarator());
                    int countTarator = getAmount(scan, "Tarator");
                    order.addMeal(tarator, countTarator);
                    break;
                case 2:
                    Meal lentilSoup = new Meal("Lentil Soup", recipeGenerator.generateLentilSoup());
                    int countLentilSoups = getAmount(scan, "Lentil Soup");
                    order.addMeal(lentilSoup, countLentilSoups);
                    break;
                case 3:
                    Meal beefSoup = new Meal("Beef Soup", recipeGenerator.generateBeefSoup());
                    int countBeefSoups = getAmount(scan, "Beef Soup");
                    order.addMeal(beefSoup, countBeefSoups);
                    break;
                case 4:
                    Meal chickenSoup = new Meal("Chicken Soup", recipeGenerator.generateChickenSoup());
                    int countChickenSoups = getAmount(scan, "Chicken Soup");
                    order.addMeal(chickenSoup, countChickenSoups);
                    break;
                default:
                    return;
            }
            menu.showSoups();
            choice = Integer.parseInt(scan.nextLine());
        }
    }

    private void orderPreCourse(Order order, Scanner scan, RecipeGenerator recipeGenerator, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Meal friedEggs = new Meal("Fried eggs", recipeGenerator.generateFriedEggs());
                    int countFriedEggs = getAmount(scan, "Fried eggs");
                    order.addMeal(friedEggs, countFriedEggs);
                    break;
                case 2:
                    Meal beansStew = new Meal("Beans Stew", recipeGenerator.generateBeansStew());
                    int countBeansStew = getAmount(scan, "Beans Stew");
                    order.addMeal(beansStew, countBeansStew);
                    break;
                case 3:
                    Meal bakedCheese = new Meal("Baked Cheese", recipeGenerator.generateBakedCheese());
                    int countBakedCheese = getAmount(scan, "Baked Cheese");
                    order.addMeal(bakedCheese, countBakedCheese);
                    break;
                case 4:
                    Meal potatoCake = new Meal("Potato Cake", recipeGenerator.generatePotatoCake());
                    int countPotatoCake = getAmount(scan, "Potato Cake");
                    order.addMeal(potatoCake, countPotatoCake);
                    break;
                default:
                    return;
            }
            menu.showPreCourse();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
    }

    private void orderMainCourse(Order order, Scanner scan, RecipeGenerator recipeGenerator, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Meal musaka = new Meal("Musaka", recipeGenerator.generateMusaka());
                    int countMusaka = getAmount(scan, "Musaka");
                    order.addMeal(musaka, countMusaka);
                    break;
                case 2:
                    Meal kapama = new Meal("Kapama", recipeGenerator.generateKapama());
                    int countKapama = getAmount(scan, "Kapama");
                    order.addMeal(kapama, countKapama);
                    break;
                case 3:
                    Meal chickenRisotto = new Meal("Chicken Risotto", recipeGenerator.generateChickenRice());
                    int countChickenRisotto = getAmount(scan, "Chicken Risotto");
                    order.addMeal(chickenRisotto, countChickenRisotto);
                    break;
                case 4:
                    Meal stuffedPeppers = new Meal("Stuffed Peppers with white sauce", recipeGenerator.generateStuffedPeppers());
                    int countStuffedPeppers = getAmount(scan, "Stuffed Peppers with white souse");
                    order.addMeal(stuffedPeppers, countStuffedPeppers);
                    break;
                default:
                    return;
            }
            menu.showMainCourse();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
    }

    private void orderDesserts(Order order, Scanner scan, RecipeGenerator recipeGenerator, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Meal baklava = new Meal("Baklava", recipeGenerator.generateBaklava());
                    int countBaklava = getAmount(scan, "Baklava");
                    order.addMeal(baklava, countBaklava);
                    break;
                case 2:
                    Meal tolumbichki = new Meal("Tolumbichki", recipeGenerator.generateTolumbichki());
                    int countTolumbichki = getAmount(scan, "Tolumbichki");
                    order.addMeal(tolumbichki, countTolumbichki);
                    break;
                case 3:
                    Meal cookieCake = new Meal("Cookie Cake", recipeGenerator.generateCookieCake());
                    int countCookieCake = getAmount(scan, "Cookie Cake");
                    order.addMeal(cookieCake, countCookieCake);
                    break;
                case 4:
                    Meal pancake = new Meal("Chocolate Pancake", recipeGenerator.generatePancake());
                    int countPancakes = getAmount(scan, "Chocolate Pancake");
                    order.addMeal(pancake, countPancakes);
                    break;
                default:
                    return;
            }
            menu.showDesserts();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
    }

    private void orderBeverages(Order order, Scanner scan, Menu menu) {
        int choice = 1;
//        choice = Integer.parseInt(scan.nextLine());
        choice = getChoice(scan);

        while (choice > 0 && choice < 5) {
            switch (choice) {
                case 1:
                    Beverage juice = new Beverage("Juice", 4.40);
                    int countJuice = getAmount(scan, "Juice");
                    order.addDrink(juice, countJuice);
                    break;
                case 2:
                    Beverage lemonade = new Beverage("Lemonade", 5.80);
                    int countLemonade = getAmount(scan, "Lemonade");
                    order.addDrink(lemonade, countLemonade);
                    break;
                case 3:
                    Beverage softDrink = new Beverage("Soft Drink", 3.20);
                    int countSoftDrink = getAmount(scan, "Soft Drink");
                    order.addDrink(softDrink, countSoftDrink);
                    break;
                case 4:
                    Beverage beer = new Beverage("Beer", 6.20);
                    int countBeer = getAmount(scan, "Beer");
                    order.addDrink(beer, countBeer);
                    break;
                default:
                    return;
            }
            menu.showBeverages();
//            choice = Integer.parseInt(scan.nextLine());
            choice = getChoice(scan);
        }
    }

    private int getAmount(Scanner scan, String name) {
        int amount = 0;
        System.out.println("Enter amount of " + name + ": ");
        amount = Integer.parseInt(scan.nextLine());
        while (amount < 0 || amount > 20) {
            System.out.println("Invalid input! Please try again!");
            amount = Integer.parseInt(scan.nextLine());
        }
        return amount;

//        String amount;
//        System.out.println("Enter amount of " + name + ": ");
//        amount = scan.nextLine();
//        while (!amount.matches("\\d") || !amount.matches("\\d\\d")) {
//            System.out.println("Invalid input! Please try again!");
//            amount = scan.nextLine();
//        }
//        return Math.abs(Integer.parseInt(amount));
    }
}
