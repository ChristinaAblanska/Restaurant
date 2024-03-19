package restaurant.building_blocks;

public class Table {

    private final int capacity;
    //private Thread waiter;


    public int getNumber() {
        return number;
    }

    private Order order;
    private final int number;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    private boolean isOccupied;

    public Table(int capacity, int number) {
        this.number = number;
        // this.waiter = waiter;
        this.capacity = capacity;
        order = new Order();

    }

    public synchronized boolean isOccupied() {
        return isOccupied;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return null;
    }

    @Override
    public String toString() {
        return "Table{" +
                "capacity=" + capacity +
                ", order=" + order +
                ", number=" + number +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
