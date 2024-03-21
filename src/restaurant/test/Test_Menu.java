package restaurant.test;

import org.junit.Test;
import restaurant.building_blocks.Menu;

public class Test_Menu {

    @Test
    public void testMenuShow() {
        Menu menu = new Menu();

        menu.showMainRecipeMenu();
    }

    @Test
    public void testActionMenuShow() {
        Menu menu = new Menu();

        menu.showMainActionMenu();
    }

    @Test
    public void testNewOrderSubMenu() {
        Menu menu = new Menu();

        menu.showNewOrderSubMenu();
    }



    @Test
    public void testShowSalads() {
        Menu menu = new Menu();

        menu.showSalads();
    }

    @Test
    public void testShowSoups() {
        Menu menu = new Menu();

        menu.showSoups();
    }
    @Test
    public void testShowPreCourse() {
        Menu menu = new Menu();

        menu.showPreCourse();
    }

    @Test
    public void testShowMainCourse() {
        Menu menu = new Menu();

        menu.showMainCourse();
    }

    @Test
    public void testShowDesserts() {
        Menu menu = new Menu();

        menu.showDesserts();
    }

    @Test
    public void testShowBeverages() {
        Menu menu = new Menu();

        menu.showBeverages();
    }

    @Test
    public void testShowSubMenu() {
        Menu menu = new Menu();

        menu.showNewOrderSubMenu();
    }
}
