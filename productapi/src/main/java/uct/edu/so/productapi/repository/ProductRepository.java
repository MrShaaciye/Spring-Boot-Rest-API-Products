package uct.edu.so.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uct.edu.so.productapi.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    ProductModel findByName(String name);
}
