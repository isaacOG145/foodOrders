package utez.edu.mx.foodOrders.utils;

public class DoubleNode<T> {
    T data;
    DoubleNode<T> next;
    DoubleNode<T> prev;

    DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
