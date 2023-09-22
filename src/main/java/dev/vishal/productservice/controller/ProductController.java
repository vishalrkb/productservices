package dev.vishal.productservice.controller;

import dev.vishal.productservice.dtos.ErrorDTO;
import dev.vishal.productservice.dtos.FakeStoreProductDTO;
import dev.vishal.productservice.dtos.GenericProductDTO;
import dev.vishal.productservice.dtos.GenericProductUpdateDTO;
import dev.vishal.productservice.exceptions.NotFoundException;
import dev.vishal.productservice.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    //@Autowired is not recomended, because object can be initiated without any state
    private ProductService productService;

    //Constructor injection: Best practice: you can pass required state while initilizing object
    @Lazy
    public ProductController(@Qualifier("fakeProductService") ProductService productService) {
        this.productService = productService;
    }

    //setter injection
//    @Autowired
//    public void setProductService(ProductServicve productService) {
//        this.productService = productService
//    }


    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws NotFoundException {
        //GenericProductDTO response = productService.getProductById(1l);
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDTO> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<GenericProductDTO>> getAllProducts() {
        return new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.OK
        );
    }

    @PutMapping("{id}")
    public void updateProduct(@RequestBody GenericProductUpdateDTO product, @PathParam("id") Long id) {
            productService.updateProduct(product, id);
    }




}
