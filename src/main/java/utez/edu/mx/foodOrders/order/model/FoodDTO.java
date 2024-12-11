package utez.edu.mx.foodOrders.order.model;

public class FoodDTO {
    private String name;
    private double price;

    public FoodDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
