package dev.vishal.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRequest {

    private String title;

    private String description;

    private double price;

    private String image;

    private String category;

}
