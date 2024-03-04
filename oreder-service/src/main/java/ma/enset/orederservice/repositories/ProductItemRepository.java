package ma.enset.orederservice.repositories;

import ma.enset.orederservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

}
