package restaurant.building_blocks.menu;

import restaurant.building_blocks.recipe.RecipeGenerator;
import restaurant.building_blocks.food.Meal;

public class UserMenu {
    //Задължително меню, което да има поне 10 ястия/напитки.
    //Ястията са с определен грамаж и количествата са ограничени. Напитките също да са ограничени.
    private static final RecipeGenerator recipeGenerator = new RecipeGenerator();

    public void showMainActionMenu() {
        System.out.println("---------------  SHIPKA  -------------");
        System.out.println("                                      ");
        System.out.println("1.                           New Order");
        System.out.println("2.                        Update Order");
        System.out.println("3.                        Revoke Order");
        System.out.println("4.                      Show Food Menu");
        System.out.println("5.                          View Order");
        System.out.println("                                      ");
        System.out.println("--------------------------------------");
        System.out.println("6.                                Exit");
        System.out.println("                                      ");
    }

    public void showNewOrderSubMenu() {
        System.out.println("---------------  ORDER  --------------");
        System.out.println("                                      ");
        System.out.println("1.                              Salads");
        System.out.println("2.                               Soups");
        System.out.println("3.                          Pre Course");
        System.out.println("4.                         Main Course");
        System.out.println("5.                            Desserts");
        System.out.println("6.                           Beverages");
        System.out.println("                                      ");
        System.out.println("--------------------------------------");
        System.out.println("7.                 Complete Order/Back");
        System.out.println("                                      ");
    }

    public void showSalads() {
        Meal meal1 = new Meal("Green Salad", recipeGenerator.generateGreenSalad());
        Meal meal2 = new Meal("Cabbage and Carrots Salad", recipeGenerator.generateCabbageCarrotSalad());
        Meal meal3 = new Meal("Shopska Salad", recipeGenerator.generateShopskaSalad());
        Meal meal4 = new Meal("Shepard's Salad", recipeGenerator.generateShepardSalad());

        double greenSaladPrice = Math.round(meal1.getPrice() * 100.0) / 100.0;
        double cabbageCarrotPrice = Math.round(meal2.getPrice() * 100.0) / 100.0;
        double shopskaSaladPrice = Math.round(meal3.getPrice() * 100.0) / 100.0;
        double shepardSaladPrice = Math.round(meal4.getPrice() * 100.0) / 100.0;

        StringBuilder saladsMenu = new StringBuilder();
        saladsMenu
                .append("--------------- SALADS ---------------\n")
                .append("                                      \n")
                .append("1. ").append(meal1.getName())
                .append(" ".repeat(35 - meal1.getName().length() - String.valueOf(greenSaladPrice).length()))
                .append(greenSaladPrice)
                .append("\n2. ").append(meal2.getName())
                .append(" ".repeat(35 - meal2.getName().length() - String.valueOf(cabbageCarrotPrice).length()))
                .append(cabbageCarrotPrice)
                .append("\n3. ").append(meal3.getName())
                .append(" ".repeat(35 - meal3.getName().length() - String.valueOf(shopskaSaladPrice).length()))
                .append(shopskaSaladPrice)
                .append("\n4. ").append(meal4.getName())
                .append(" ".repeat(35 - meal4.getName().length() - String.valueOf(shepardSaladPrice).length()))
                .append(shepardSaladPrice)
                .append("\n--------------------------------------\n")
                .append("5. Back to Main \n");

        System.out.println(saladsMenu.toString());

    }

    public void showSoups() {
        Meal meal1 = new Meal("Tarator", recipeGenerator.generateTarator());
        Meal meal2 = new Meal("Lentil Soup", recipeGenerator.generateLentilSoup());
        Meal meal3 = new Meal("Beef Soup", recipeGenerator.generateBeefSoup());
        Meal meal4 = new Meal("Chicken Soup", recipeGenerator.generateChickenSoup());

        double tarator = Math.round(meal1.getPrice() * 100.0) / 100.0;
        double lentilSoup = Math.round(meal2.getPrice() * 100.0) / 100.0;
        double beefSoup = Math.round(meal3.getPrice() * 100.0) / 100.0;
        double chickenSoup = Math.round(meal4.getPrice() * 100.0) / 100.0;

        StringBuilder soupsMenu = new StringBuilder();
        soupsMenu
                .append("---------------- SOUPS ---------------\n")
                .append("                                      \n")
                .append("1. ").append(meal1.getName())
                .append(" ".repeat(35 - meal1.getName().length() - String.valueOf(tarator).length()))
                .append(tarator)
                .append("\n2. ").append(meal2.getName())
                .append(" ".repeat(35 - meal2.getName().length() - String.valueOf(lentilSoup).length()))
                .append(lentilSoup)
                .append("\n3. ").append(meal3.getName())
                .append(" ".repeat(35 - meal3.getName().length() - String.valueOf(beefSoup).length()))
                .append(beefSoup)
                .append("\n4. ").append(meal4.getName())
                .append(" ".repeat(35 - meal4.getName().length() - String.valueOf(chickenSoup).length()))
                .append(chickenSoup)
                .append("\n--------------------------------------\n")
                .append("5. Back to Main \n");

        System.out.println(soupsMenu.toString());

    }

    public void showPreCourse() {
        Meal meal1 = new Meal("Fried Eggs", recipeGenerator.generateFriedEggs());
        Meal meal2 = new Meal("Beans Stew", recipeGenerator.generateBeansStew());
        Meal meal3 = new Meal("Baked Cheese", recipeGenerator.generateBakedCheese());
        Meal meal4 = new Meal("Potato Cake", recipeGenerator.generatePotatoCake());

        double friedEggs = Math.round(meal1.getPrice() * 100.0) / 100.0;
        double beensStew = Math.round(meal2.getPrice() * 100.0) / 100.0;
        double bakedCheese = Math.round(meal3.getPrice() * 100.0) / 100.0;
        double potatoCake = Math.round(meal4.getPrice() * 100.0) / 100.0;

        StringBuilder preCourseMenu = new StringBuilder();
        preCourseMenu
                .append("------------- PRE COURSE -------------\n")
                .append("                                      \n")
                .append("1. ").append(meal1.getName())
                .append(" ".repeat(35 - meal1.getName().length() - String.valueOf(friedEggs).length()))
                .append(friedEggs)
                .append("\n2. ").append(meal2.getName())
                .append(" ".repeat(35 - meal2.getName().length() - String.valueOf(beensStew).length()))
                .append(beensStew)
                .append("\n3. ").append(meal3.getName())
                .append(" ".repeat(35 - meal3.getName().length() - String.valueOf(bakedCheese).length()))
                .append(bakedCheese)
                .append("\n4. ").append(meal4.getName())
                .append(" ".repeat(35 - meal4.getName().length() - String.valueOf(potatoCake).length()))
                .append(potatoCake)
                .append("\n--------------------------------------\n")
                .append("5. Back to Main \n");

        System.out.println(preCourseMenu.toString());
    }

    public void showMainCourse() {
        Meal meal1 = new Meal("Musaka", recipeGenerator.generateMusaka());
        Meal meal2 = new Meal("Kapama", recipeGenerator.generateKapama());
        Meal meal3 = new Meal("Chicken risotto", recipeGenerator.generateChickenRice());
        Meal meal4 = new Meal("Stuffed Peppers with sauce", recipeGenerator.generateStuffedPeppers());

        double musaka = Math.round(meal1.getPrice() * 100.0) / 100.0;
        double kapama = Math.round(meal2.getPrice() * 100.0) / 100.0;
        double chickenRisotto = Math.round(meal3.getPrice() * 100.0) / 100.0;
        double stuffedPeppers = Math.round(meal4.getPrice() * 100.0) / 100.0;

        StringBuilder mainCourseMenu = new StringBuilder();
        mainCourseMenu
                .append("------------- MAIN COURSE ------------\n")
                .append("                                      \n")
                .append("1. ").append(meal1.getName())
                .append(" ".repeat(35 - meal1.getName().length() - String.valueOf(musaka).length()))
                .append(musaka)
                .append("\n2. ").append(meal2.getName())
                .append(" ".repeat(35 - meal2.getName().length() - String.valueOf(kapama).length()))
                .append(kapama)
                .append("\n3. ").append(meal3.getName())
                .append(" ".repeat(35 - meal3.getName().length() - String.valueOf(chickenRisotto).length()))
                .append(chickenRisotto)
                .append("\n4. ").append(meal4.getName())
                .append(" ".repeat(35 - meal4.getName().length() - String.valueOf(stuffedPeppers).length()))
                .append(stuffedPeppers)
                .append("\n--------------------------------------\n")
                .append("5. Back to Main \n");

        System.out.println(mainCourseMenu.toString());
    }

    public void showDesserts() {
        Meal meal1 = new Meal("Baklava", recipeGenerator.generateBaklava());
        Meal meal2 = new Meal("Tolumbichki", recipeGenerator.generateTolumbichki());
        Meal meal3 = new Meal("Cookie Cake", recipeGenerator.generateCookieCake());
        Meal meal4 = new Meal("Chocolate pancake", recipeGenerator.generatePancake());

        double baklava = Math.round(meal1.getPrice() * 100.0) / 100.0;
        double tolumbichki = Math.round(meal2.getPrice() * 100.0) / 100.0;
        double cookieCake = Math.round(meal3.getPrice() * 100.0) / 100.0;
        double chocolatePancae = Math.round(meal4.getPrice() * 100.0) / 100.0;

        StringBuilder mainCourseMenu = new StringBuilder();
        mainCourseMenu
                .append("-------------- DESSERTS --------------\n")
                .append("                                      \n")
                .append("1. ").append(meal1.getName())
                .append(" ".repeat(35 - meal1.getName().length() - String.valueOf(baklava).length()))
                .append(baklava)
                .append("\n2. ").append(meal2.getName())
                .append(" ".repeat(35 - meal2.getName().length() - String.valueOf(tolumbichki).length()))
                .append(tolumbichki)
                .append("\n3. ").append(meal3.getName())
                .append(" ".repeat(35 - meal3.getName().length() - String.valueOf(cookieCake).length()))
                .append(cookieCake)
                .append("\n4. ").append(meal4.getName())
                .append(" ".repeat(35 - meal4.getName().length() - String.valueOf(chocolatePancae).length()))
                .append(chocolatePancae)
                .append("\n--------------------------------------\n")
                .append("5. Back to Main \n");

        System.out.println(mainCourseMenu.toString());
    }

    public void showBeverages() {
        System.out.println("-------------- BEVERAGES -------------");
        System.out.println("                                      ");
        System.out.println("1. Juice                          4.40");
        System.out.println("2. Lemonade                       5.80");
        System.out.println("3. Soft Drink                     3.20");
        System.out.println("4. Beer Light/Dark                6.20");
        System.out.println("                                      ");
        System.out.println("--------------------------------------");
        System.out.println("5. Back to Main                       ");
        System.out.println("                                      ");
    }
    public void showMainRecipeMenu() {
        System.out.println("                               e   e                              ");
        System.out.println("                              d8b d8b      e e   888 8e  8888 8888");
        System.out.println("                             e Y8b Y8b   d88 88b 888 88b 8888 8888");
        System.out.println("                            d8b Y8b Y8b  888     888 888 Y888 888P");
        System.out.println("                           d888b Y8b Y8b   YeeP  888 888   88 88 ");

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("--------------- SALADS ---------------                  --------------- SOUPS ---------------");
        System.out.println("                                                                                             ");
        System.out.println("1. Green Salad                   10.20                  1. Tarator                       5.60");
        System.out.println("2. Cabbage and Carrots            9.40                  2. Lentil Soup                   8.70");
        System.out.println("3. Shopska Salad                  8.50                  3. Beef Soup                     5.00");
        System.out.println("4. Shepard's Salad               11.90                  4. Chicken Soup                  6.80");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------------- PRE COURSE -------------                ------------- MAIN COURSE -------------");
        System.out.println("                                                                                             ");
        System.out.println("1. Fried Eggs                     8.80                1. Musaka                         10.40");
        System.out.println("2. Beans Stew                     7.60                2. Kapama                         18.70");
        System.out.println("3. Baked Cheese                  13.20                3. Chicken risotto                15.00");
        System.out.println("4. Potatoe Cake                  10.50                4. Stuffed Peppers with sauce     16.30");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("-------------- DESSERTS --------------                -------------- BEVERAGES --------------");
        System.out.println("                                                                                             ");
        System.out.println("1. Baklava                       12.40                1. Juice                           4.40");
        System.out.println("2. Tolumbichki                    8.70                2. Lemonade                        5.80");
        System.out.println("3. Cookie Cake                    7.90                3. Soft Drink                      3.20");
        System.out.println("4. Chocolate pancake             11.70                4. Beer Light/Dark                 6.20");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
    }
}
