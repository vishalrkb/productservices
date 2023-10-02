package dev.vishal.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductResponse {

    private String id;

    private String title;

    private String description;

    private double price;

    private String image;

    private String category;

}
