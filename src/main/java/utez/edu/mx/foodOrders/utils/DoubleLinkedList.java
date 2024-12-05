package utez.edu.mx.foodOrders.utils;

public class DoubleLinkedList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    // Constructor
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice está fuera de los límites de la lista"
            );
        }

        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "El índice está fuera de los límites de la lista"
            );
        }

        DoubleNode<T> current;
        if (index == 0) {
            current = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return true;
    }

    public int size() {
        return size;
    }
}