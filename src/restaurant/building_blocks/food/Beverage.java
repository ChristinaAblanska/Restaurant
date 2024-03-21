package restaurant.building_blocks.food;

public class Beverage {
    public String name;
    public double price;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //TO DO
    //Do we need this?
    void consume() {
        System.out.println("The drink is consumed!");
    }
}