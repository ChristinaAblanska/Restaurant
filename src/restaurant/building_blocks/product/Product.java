package restaurant.building_blocks.product;

public abstract class Product {
    String name;

    public Product(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}