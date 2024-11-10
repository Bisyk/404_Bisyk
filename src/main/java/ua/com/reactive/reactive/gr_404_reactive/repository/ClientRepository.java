package ua.com.reactive.reactive.gr_404_reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Client;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository

public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {
    @Query("SELECT id, username, password FROM client WHERE username = :username")
    Mono<Client> findByUsername(String username);
}

