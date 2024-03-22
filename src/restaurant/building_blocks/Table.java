package restaurant.building_blocks;

import restaurant.OrderStatus;

public class Table {

    private final int capacity;

    public int getNumber() {
        return number;
    }

    public TableOrder getTableOrder() {
        return tableOrder;
    }

    private TableOrder tableOrder;
    private final int number;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    private boolean isOccupied;

    public Table(int capacity, int number) {
        this.number = number;
        this.capacity = capacity;
        tableOrder = new TableOrder();
        tableOrder.setStatus(OrderStatus.BLANK);
    }

    public synchronized boolean isOccupied() {
        return isOccupied;
    }


    public Menu getMenu() {
        return null;
    }

    public int getCapacity() {
        return capacity;
    }

}
