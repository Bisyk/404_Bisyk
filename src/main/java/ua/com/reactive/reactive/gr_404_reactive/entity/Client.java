package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Client {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Boolean isAdmin;
    private boolean isBlacklisted;

    public Client(String firstName, String lastName, String email, String phoneNumber, String address, Boolean isAdmin, boolean isBlacklisted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isAdmin = isAdmin;
        this.isBlacklisted = isBlacklisted;
    }
}
