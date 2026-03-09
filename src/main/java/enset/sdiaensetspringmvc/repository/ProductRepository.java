package enset.sdiaensetspringmvc.repository;

import enset.sdiaensetspringmvc.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}