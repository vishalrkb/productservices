package dev.vishal.productservice.service;

import dev.vishal.productservice.dto.AddProductRequest;
import dev.vishal.productservice.dto.AddProductResponse;
import dev.vishal.productservice.dto.GenericProductDTO;
import dev.vishal.productservice.dto.UpdateProductDetailsDTO;
import dev.vishal.productservice.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

     AddProductResponse addProduct(AddProductRequest request);

     GenericProductDTO getProductById(UUID id) throws NotFoundException;

    // GenericProductDTO deleteProduct(Long id);

    // List<GenericProductDTO> getAllProducts();

    // void updateProduct(GenericProductUpdateDTO product, Long id);


     List<GenericProductDTO> getAllProducts();

     GenericProductDTO updateProduct(UpdateProductDetailsDTO updateProductDetailsDTO) throws NotFoundException;

     void deleteProduct(UUID id);

     List<GenericProductDTO> getAllProductsByCategory(UUID id) throws NotFoundException;
}
