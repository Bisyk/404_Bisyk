package ua.com.reactive.reactive.gr_404_reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Orders;
import ua.com.reactive.reactive.gr_404_reactive.repository.OrderRepository;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Orders> list() {
        return orderRepository.findAll();
    }

    public Mono<Orders> addOne(Orders order) {
        return orderRepository.save(order);
    }
}
