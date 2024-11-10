package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private String genre;
    private String band;
    private String image;
    private double price;
    private int quantityInStock;
}
