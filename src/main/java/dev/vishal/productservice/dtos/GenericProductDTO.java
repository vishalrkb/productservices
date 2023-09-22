package dev.vishal.productservice.dtos;

public record GenericProductDTO(Long id, String title, double price, String category, String description, String image) {
}
