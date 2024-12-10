package utez.edu.mx.foodOrders.order.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import utez.edu.mx.foodOrders.utils.*;

public class Order {

    private int id;
    private Waiter waiter;

    @JsonSerialize(using = DoubleLinkedListSerializer.class)
    private DoubleLinkedList<Food> foods;

    public Order(){}

    public Order(int id, Waiter waiter, DoubleLinkedList<Food> foods) {
        this.id = id;
        this.waiter = waiter;
        this.foods = foods;
    }

    public int getId() {
        return id;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public DoubleLinkedList<Food> getFoods() {
        return foods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setFoods(DoubleLinkedList<Food> foods) {
        this.foods = foods;
    }


    public double getTotalPrice() {
        double total = 0;

        for(int index = 0; index < foods.size(); index++) {
            total += foods.get(index).getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID de orden: ").append(id)
                .append("\nMesero: ").append(waiter)
                .append("\nPedidos: ");

        for (int i = 0; i < foods.size(); i++) {
            sb.append(foods.get(i));
            if (i < foods.size() - 1) {
                sb.append(", ");
            }
        }

        // Agregar el precio total
        sb.append("\nTotal: ").append(getTotalPrice());

        return sb.toString();
    }




}