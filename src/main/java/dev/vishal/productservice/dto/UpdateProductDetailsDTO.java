package dev.vishal.productservice.dto;

public record UpdateProductDetailsDTO(String id, String title, double price, String description, String image) {
}
