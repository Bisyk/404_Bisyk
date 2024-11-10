package ua.com.reactive.reactive.gr_404_reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Product;
import ua.com.reactive.reactive.gr_404_reactive.repository.ProductRepository;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> list() {
        return productRepository.findAll();
    }

    public Mono<Product> addOne(Product product) {
        return productRepository.save(product);
    }
}
