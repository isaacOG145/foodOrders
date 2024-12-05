package utez.edu.mx.foodOrders.utils;

public class Node<E>{

    public E data;
    public Node<E> next;

    public Node(E data){
        this.data = data;
        this.next = null;
    }

    public E getData(){
        return this.data;
    }
}
