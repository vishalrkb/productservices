package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.FakeStoreProductDTO;
import dev.vishal.productservice.dtos.GenericProductDTO;
import dev.vishal.productservice.dtos.GenericProductUpdateDTO;
import dev.vishal.productservice.exceptions.NotFoundException;
import dev.vishal.productservice.model.Product;

import java.util.List;

public interface ProductService {

     GenericProductDTO getProductById(Long id) throws NotFoundException;

     GenericProductDTO deleteProduct(Long id);

     List<GenericProductDTO> getAllProducts();

     void updateProduct(GenericProductUpdateDTO product, Long id);
}
