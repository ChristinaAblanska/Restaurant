package restaurant.building_blocks;

import restaurant.OrderStatus;

public class Table {

    private final int capacity;
    //private Thread waiter;


    public int getNumber() {
        return number;
    }

    public TableOrder getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(TableOrder tableOrder) {
        this.tableOrder = tableOrder;
    }

    private TableOrder tableOrder;
    private final int number;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    private boolean isOccupied;

    public Table(int capacity, int number) {
        this.number = number;
        // this.waiter = waiter;
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

}
