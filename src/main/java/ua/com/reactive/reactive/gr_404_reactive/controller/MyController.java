//package ua.com.reactive.reactive.gr_404_reactive.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import ua.com.reactive.reactive.gr_404_reactive.entity.Client;
//
//@RestController
//public class MyController{
//
//    @GetMapping("/clients")
//
//    public Flux<Client> getClients() {
//        Flux<Client> clients = Flux.just(
//                        new Client(1L, "Vasya", "Pypkin", "fafadf@lol.c",
//                                "+4342342342", "Kyiv", true, false)
//                )
//                .skip(0)
//                .take(2);
//
//        return clients;
//    }
//}
//
