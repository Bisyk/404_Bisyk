package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "client")
public class Client implements UserDetails {

    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean isAdmin;
    private boolean isBlacklisted;

    private Set<GrantedAuthority> authorities = new HashSet<>();


    public Client(Long id, String username, String password, String firstName, String lastName, String email, String phoneNumber, String address, Boolean isAdmin, boolean isBlacklisted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isAdmin = isAdmin;
        this.isBlacklisted = isBlacklisted;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(authorities);
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
