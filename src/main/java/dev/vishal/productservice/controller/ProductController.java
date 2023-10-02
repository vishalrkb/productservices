package dev.vishal.productservice.controller;

import dev.vishal.productservice.dto.AddProductRequest;
import dev.vishal.productservice.dto.AddProductResponse;
import dev.vishal.productservice.dto.GenericProductDTO;
import dev.vishal.productservice.dto.UpdateProductDetailsDTO;
import dev.vishal.productservice.exception.NotFoundException;
import dev.vishal.productservice.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    //@Autowired is not recomended, because object can be initiated without any state
    private final ProductService productService;

    //Constructor injection: Best practice: you can pass required state while initilizing object
    @Lazy
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }



    //setter injection
//    @Autowired
//    public void setProductService(ProductServicve productService) {
//        this.productService = productService
//    }

    @PostMapping()
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody  AddProductRequest request) {
         return new ResponseEntity<>(
                 productService.addProduct(request),
                 HttpStatus.CREATED
         );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDTO> getProductById(@PathVariable String id) throws NotFoundException {
        System.out.println("id..."+id);
        return new ResponseEntity<>(
                productService.getProductById(UUID.fromString(id)),
                HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<List<GenericProductDTO>> getAllProducts() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id) {
        productService.deleteProduct(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<GenericProductDTO> updateProduct(@RequestBody UpdateProductDetailsDTO updateProductDetailsDTO) throws NotFoundException {
        return new ResponseEntity<>(
                productService.updateProduct(updateProductDetailsDTO),
                HttpStatus.OK
        );
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<GenericProductDTO>> getProductsByCategory(@PathVariable("id") String id) throws NotFoundException {
        return new ResponseEntity<>(
                productService.getAllProductsByCategory(UUID.fromString(id)),
                HttpStatus.OK
        );
    }


   /* @GetMapping("{id}")
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
    }*/




}
