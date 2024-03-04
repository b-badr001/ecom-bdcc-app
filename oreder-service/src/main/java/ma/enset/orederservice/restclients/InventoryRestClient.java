package ma.enset.orederservice.restclients;

import ma.enset.orederservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(url="http://localhost:8087", name = "inv-service")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    public List<Product> getAllProducts();
}
