package dev.vishal.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GenericProductUpdateDTO {

    String title;

    Double price;

    String description;

    String image;

    String category;

    @Override
    public String toString() {
        return "GenericProductUpdateDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
