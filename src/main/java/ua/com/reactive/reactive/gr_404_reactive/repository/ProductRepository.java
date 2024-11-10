package ua.com.reactive.reactive.gr_404_reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.gr_404_reactive.entity.Product;


public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}