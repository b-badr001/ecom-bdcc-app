package ma.enset.orederservice.web;

import ma.enset.orederservice.entities.Order;
import ma.enset.orederservice.repositories.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestControllers {
    private OrderRepository orderRepository;

    public OrderRestControllers(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable String id){
        return orderRepository.findById(id).get();
    }
}
