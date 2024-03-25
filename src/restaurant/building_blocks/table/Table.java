package restaurant.building_blocks.table;

import restaurant.building_blocks.order.OrderStatus;
import restaurant.building_blocks.menu.RestaurantMenu;
import restaurant.building_blocks.order.TableOrder;

public class Table {
    private final RestaurantMenu menu;
    private final int capacity;
    private TableOrder tableOrder;
    private final int number;
    private boolean isOccupied;

    public Table(RestaurantMenu menu, int capacity, int number) {
        this.menu = menu;
        this.number = number;
        this.capacity = capacity;
        tableOrder = new TableOrder();
        tableOrder.setStatus(OrderStatus.BLANK);
    }

    public synchronized boolean isOccupied() {
        return isOccupied;
    }


    public RestaurantMenu getMenu() {
        return menu;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumber() {
        return number;
    }

    public TableOrder getTableOrder() {
        return tableOrder;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }


    public void releaseDinnerTable() {
        tableOrder.truncate();
        tableOrder.setStatus(OrderStatus.BLANK);
        setOccupied(false);
    }
}
