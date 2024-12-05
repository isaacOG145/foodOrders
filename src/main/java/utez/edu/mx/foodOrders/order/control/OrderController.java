package utez.edu.mx.foodOrders.order.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.foodOrders.utils.Message;
import utez.edu.mx.foodOrders.utils.TypesResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/generateOrders")
    public ResponseEntity<Message> generateOrders() {
        return orderService.generateOrders();
    }

    @GetMapping("/checkOrder")
    public ResponseEntity<Message> checkOrder() {
        return orderService.checkOrders();
    }

    @GetMapping("/completeOrder")
    public ResponseEntity<Message> completeOrder() {
        return orderService.completeOrder();
    }

    @GetMapping("/checkFinished")
    public ResponseEntity<Message> checkFinished() {
        return orderService.checkFinished();
    }

}
