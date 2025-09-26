package ecommerce;

import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    
    private OrderRepository orderRepo = new OrderRepository();
    
    @PostMapping("/order")
    public String createOrder(@RequestBody Order order) {
        log.info("Hello")
        orderRepo.saveOrder(order);
        return "Order created";
    }
    
    @PostMapping("/order2")
    public String create_order_bad(@RequestBody Order order){
        orderRepo.save_order_duplicate(order);
        return"Order created duplicate";
    }
}