package ua.com.reactive.reactive.gr_404_reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Client;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("Hello World!"));
    }

    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("User Page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        Flux<Client> users = Flux.
                just(
                        new Client(1L, "Vasya", "1234", "Vasya", "Ivanov", "vasya@example.com", "555-01-01", "123 Main St", true, false),
                        new Client(2L, "Inna", "1234", "Inna", "Petrova", "inna@example.com", "555-02-02", "124 Main St", false, false),
                        new Client(3L, "Ira", "1234", "Ira", "Sidorova", "ira@example.com", "555-03-03", "125 Main St", false, false)
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, Client.class);
    }

}
