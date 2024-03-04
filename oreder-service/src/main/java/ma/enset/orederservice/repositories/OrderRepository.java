package ma.enset.orederservice.repositories;

import ma.enset.orederservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
