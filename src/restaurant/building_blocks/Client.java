package restaurant.building_blocks;

import restaurant.building_blocks.food.Beverage;
import restaurant.building_blocks.food.Meal;

public class Client {

    //Клиентите може да поръчват по няколко неща, може да оставят или да не оставят бакшиши.
    private final int clientNumber;
    private Order individualOrder;

    public Order getIndividualOrder() {
        return individualOrder;
    }

    public void setIndividualOrder(Order individualOrder) {
        this.individualOrder = individualOrder;
    }

    public Client(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                '}';
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public Meal pickMeal(Object menu) {
        return null;
    }

    public Beverage pickDring(Object menu) {
        return null;
    }

}