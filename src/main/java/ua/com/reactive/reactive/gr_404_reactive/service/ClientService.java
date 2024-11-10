package ua.com.reactive.reactive.gr_404_reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.gr_404_reactive.entity.Client;
import ua.com.reactive.reactive.gr_404_reactive.repository.ClientRepository;
import ua.com.reactive.reactive.gr_404_reactive.repository.RoleRepository;
import ua.com.reactive.reactive.gr_404_reactive.repository.RolesHasUsersRepository;

import java.util.HashSet;


@Service
@RequiredArgsConstructor
public class ClientService implements ReactiveUserDetailsService {

    private final ClientRepository clientRepository;

    private final RolesHasUsersRepository rolesHasUsersRepository;
    private final RoleRepository roleRepository;

//    @Autowired
//    public ClientService(ClientRepository clientRepository) {
//        this.clientRepository = clientRepository;
//    }

    public Flux<Client> list() {
        return clientRepository.findAll();
    }

    public Mono<Client> addOne(Client client) {
        return clientRepository.save(client);
    }

    public Flux<GrantedAuthority> getAuthorities(Long userId) {
        return rolesHasUsersRepository.findRoleIdsByUserId(userId)
                .flatMap(roleId -> roleRepository.findById(roleId))
                .map(role -> role).cast(GrantedAuthority.class);
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        return clientRepository.findByUsername(username)
                .flatMap(user ->
                        getAuthorities(user.getId())
                                .collectList()
                                .map(authorities -> {
                                    user.setAuthorities(new HashSet<>(authorities));
                                    return user;
                                })
                );
    }
}
