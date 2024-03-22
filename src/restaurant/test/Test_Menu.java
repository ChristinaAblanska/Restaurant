package restaurant.test;

import org.junit.Test;
import restaurant.building_blocks.UserMenu;

public class Test_Menu {

    @Test
    public void testMenuShow() {
        UserMenu menu = new UserMenu();

        menu.showMainRecipeMenu();
    }

    @Test
    public void testActionMenuShow() {
        UserMenu menu = new UserMenu();

        menu.showMainActionMenu();
    }

    @Test
    public void testNewOrderSubMenu() {
        UserMenu menu = new UserMenu();

        menu.showNewOrderSubMenu();
    }



    @Test
    public void testShowSalads() {
        UserMenu menu = new UserMenu();

        menu.showSalads();
    }

    @Test
    public void testShowSoups() {
        UserMenu menu = new UserMenu();

        menu.showSoups();
    }
    @Test
    public void testShowPreCourse() {
        UserMenu menu = new UserMenu();

        menu.showPreCourse();
    }

    @Test
    public void testShowMainCourse() {
        UserMenu menu = new UserMenu();

        menu.showMainCourse();
    }

    @Test
    public void testShowDesserts() {
        UserMenu menu = new UserMenu();

        menu.showDesserts();
    }

    @Test
    public void testShowBeverages() {
        UserMenu menu = new UserMenu();

        menu.showBeverages();
    }

    @Test
    public void testShowSubMenu() {
        UserMenu menu = new UserMenu();

        menu.showNewOrderSubMenu();
    }
}
