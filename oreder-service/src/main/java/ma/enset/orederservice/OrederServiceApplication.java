package ma.enset.orederservice;

import ma.enset.orederservice.entities.Order;
import ma.enset.orederservice.entities.OrderState;
import ma.enset.orederservice.entities.ProductItem;
import ma.enset.orederservice.model.Product;
import ma.enset.orederservice.repositories.OrderRepository;
import ma.enset.orederservice.repositories.ProductItemRepository;
import ma.enset.orederservice.restclients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class OrederServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrederServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository,
                                        ProductItemRepository productItemRepository,
                                        InventoryRestClient inventoryRestClient){
        return args -> {
            List<Product> allProducts = inventoryRestClient.getAllProducts();
            for(int i = 0; i < 5; i++){
                Order order = Order.builder()
                        .id(UUID.randomUUID().toString())
                        .date(LocalDate.now())
                        .state(OrderState.PENDING)
                        .build();
                Order savedOrder = orderRepository.save(order);
                allProducts.forEach(p->{
                    ProductItem productItem = ProductItem.builder()
                            .productId(p.getId())
                            .quantity(new Random().nextInt(28))
                            .price(p.getPrice())
                            .order(savedOrder)
                            .build();
                    productItemRepository.save(productItem);
                });
            }
        };
    }

}
