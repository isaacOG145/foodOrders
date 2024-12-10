package utez.edu.mx.foodOrders.order.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import utez.edu.mx.foodOrders.order.model.Order;
import utez.edu.mx.foodOrders.utils.*;

import java.util.Random;

@Service
public class OrderService {

    private final Stack<Order> completedOrders = new Stack<>();
    private final Queue<Order> ordersQueue = new Queue<>();
    private static int orderCounter = 0;

    public int generateUniqueOrderId() {
        return ++orderCounter;
    }

    public ResponseEntity<Message> generateOrders() {

        try{
            Random rand = new Random();

            int orderCount = rand.nextInt(100) + 1;

            for (int i = 0; i < orderCount; i++) {
                Order order = generateOrder();
                ordersQueue.offer(order);
            }
            return new ResponseEntity<>(new Message("Se agregaron " + orderCount + " ordenes",TypesResponse.SUCCESS), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Message("Hubo un error al generar las ordenes", TypesResponse.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Message> checkOrders() {
        try {

            Order nextOrder = ordersQueue.peek();

            System.out.println("Siguiente orden: " + nextOrder);

            if (nextOrder == null) {
                return new ResponseEntity<>(new Message("No hay mas órdenes que atender.", TypesResponse.WARNING), HttpStatus.OK);
            }

            return new ResponseEntity<>(new Message(nextOrder, "Siguiente orden", TypesResponse.SUCCESS), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Hubo un error al revisar las órdenes", TypesResponse.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Message> completeOrder() {
        try {
            Order nextOrder = ordersQueue.poll();

            if (nextOrder == null) {
                return new ResponseEntity<>(new Message("No hay órdenes en la cola para completar.", TypesResponse.WARNING), HttpStatus.OK);
            }

            completedOrders.push(nextOrder);

            return new ResponseEntity<>(new Message("Orden completada y movida a la pila.", TypesResponse.SUCCESS), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Hubo un error al completar la orden", TypesResponse.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Message> checkFinished() {
        try {

            Order lastOrder = completedOrders.peek();

            if (lastOrder == null) {
                return new ResponseEntity<>(new Message("Aun no se completan ordenes", TypesResponse.WARNING), HttpStatus.OK);
            }

            return new ResponseEntity<>(new Message(lastOrder, "Siguiente orden", TypesResponse.SUCCESS), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Hubo un error al revisar las órdenes", TypesResponse.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public Order generateOrder() {
        Random random = new Random();
        DoubleLinkedList<Food> listFood = new DoubleLinkedList<>();
        Order order = new Order();

        order.setWaiter(getRandomWaiter());
        order.setId(generateUniqueOrderId());

        int numFoods = random.nextInt(10) + 1;

        for (int i = 0; i < numFoods; i++) {
            listFood.add(getRandomFood());
        }

        order.setFoods(listFood);

        return order;
    }

    public Waiter getRandomWaiter() {
        Random random = new Random();

        Waiter[] waiters = Waiter.values();
        int index = random.nextInt(waiters.length);
        return waiters[index];
    }


    public Food getRandomFood() {
        Random random = new Random();
        Food[] foods = Food.values();
        int index = random.nextInt(foods.length);
        return foods[index];
    }

}
