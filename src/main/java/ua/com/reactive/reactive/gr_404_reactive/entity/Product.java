package ua.com.reactive.reactive.gr_404_reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private String description;
    private String genre;
    private String band;
    private String image;
    private double price;
    private int quantityInStock;
}
