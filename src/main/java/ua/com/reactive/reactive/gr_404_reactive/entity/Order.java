package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Client client;
    private List<Product> products;
    private LocalDateTime orderDate;
    private String status;
    private String comment;
    private String deliveryAddress;
    private String deliveryCity;
    private String deliveryCountry;
    private String deliveryZip;
    private double totalPrice;
}
