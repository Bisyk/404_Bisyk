package ua.com.reactive.reactive.gr_404_reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Client;

public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {
}

