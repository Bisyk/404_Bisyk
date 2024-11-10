package ua.com.reactive.reactive.gr_404_reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Client;
import ua.com.reactive.reactive.gr_404_reactive.entity.Message;
import ua.com.reactive.reactive.gr_404_reactive.entity.Orders;
import ua.com.reactive.reactive.gr_404_reactive.entity.Product;
import ua.com.reactive.reactive.gr_404_reactive.service.ClientService;
import ua.com.reactive.reactive.gr_404_reactive.service.MessageService;
import ua.com.reactive.reactive.gr_404_reactive.service.OrderService;
import ua.com.reactive.reactive.gr_404_reactive.service.ProductService;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class MainController {

    private final MessageService messageService;
    private final ClientService clientService;
    private final ProductService productService;
    private final OrderService orderService;


    @GetMapping
    public Flux<Message> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count) {
        return messageService.list();
    }

    @PostMapping
    public Mono<Message> create(@RequestBody Message message) {
        return messageService.addOne(message);
    }

    @GetMapping("/client")
    public Flux<Client> listClients() {
        return clientService.list();
    }


    @PostMapping("/client")
    public Mono<Client> createClient(@RequestBody Client client) {
        return clientService.addOne(client);
    }

    @GetMapping("/product")
    public Flux<Product> listProducts() {
        return productService.list();
    }


    @PostMapping("/product")
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.addOne(product);
    }

    @GetMapping("/order")
    public Flux<Orders> listOrders() {
        return orderService.list();
    }

    @PostMapping("/order")
    public Mono<Orders> createOrder(@RequestBody Orders orders) {
        return orderService.addOne(orders);
    }
}
