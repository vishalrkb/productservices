package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.GenericProductDTO;
import dev.vishal.productservice.dtos.GenericProductUpdateDTO;
import dev.vishal.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public void updateProduct(GenericProductUpdateDTO product, Long id) {

    }
}
