package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    @Id
    private Long id;
    private Long clientId;
    private LocalDateTime orderDate;
    private String status;
    private String comment;
    private String deliveryAddress;
    private String deliveryCity;
    private String deliveryCountry;
    private String deliveryZip;
    private double totalPrice;
}

