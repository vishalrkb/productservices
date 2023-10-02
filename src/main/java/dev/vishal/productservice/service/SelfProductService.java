package dev.vishal.productservice.service;

import dev.vishal.productservice.dto.AddProductRequest;
import dev.vishal.productservice.dto.AddProductResponse;
import dev.vishal.productservice.dto.GenericProductDTO;
import dev.vishal.productservice.dto.UpdateProductDetailsDTO;
import dev.vishal.productservice.exception.NotFoundException;
import dev.vishal.productservice.model.Category;
import dev.vishal.productservice.model.Product;
import dev.vishal.productservice.repository.CategoryRepository;
import dev.vishal.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,  CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public AddProductResponse addProduct(AddProductRequest request) {

        AddProductResponse response = new AddProductResponse();

        Optional<Category> optionalCategory = categoryRepository.findCategoryByName(request.getCategory());
        Category category = new Category();

        if(optionalCategory.isEmpty()) {
            category.setName(request.getCategory());
            category = categoryRepository.save(category);
        } else {
            category = optionalCategory.get();
        }


        Product product = new Product();

        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImage(request.getImage());
       // category.setName(request.getCategory());
        product.setCategory(category);
        product = productRepository.save(product);
       // Product product = productRepository.saveProduct(request.getTitle(), request.getDescription(), category.getId(), request.getPrice(), request.getImage());

//        Category category = new Category();
//        Product product = new Product();
//
//        product.setTitle(request.getTitle());
//        product.setDescription(request.getDescription());
//        product.setPrice(request.getPrice());
//        product.setImage(request.getImage());
//        category.setName(request.getCategory());
//        product.setCategory(category);
//
//        product = productRepository.save(product);
//
        response.setId(product.getId().toString());
        response.setTitle(product.getTitle());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setImage((product.getImage()));
        response.setCategory(product.getCategory().getName());


        return response;

    }


    @Override
    public GenericProductDTO getProductById(UUID id) throws NotFoundException {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) {
            throw new NotFoundException(id + " not found");
        }

        Product product = productOptional.get();
        System.out.println(product.getCategory().getName());
        GenericProductDTO response = new GenericProductDTO(product.getId().toString(), product.getTitle(), product.getPrice(), product.getCategory().getName(),
                                                           product.getDescription(), product.getImage());

        return response;

    }

    @Override
    public List<GenericProductDTO> getAllProducts() {

        List<GenericProductDTO> response = new ArrayList<>();

        List<Product> products = productRepository.findAll();

        for(Product product : products) {

            GenericProductDTO genericProductDTO = new GenericProductDTO(product.getId().toString(), product.getTitle(), product.getPrice(), product.getCategory().getName(),
                                                                        product.getDescription(), product.getImage());

            response.add(genericProductDTO);
        }

        return response;

    }

    @Override
    @Transactional
    public GenericProductDTO updateProduct(UpdateProductDetailsDTO updateProductDetailsDTO) throws NotFoundException {
         Optional<Product> productOptional = productRepository.findById(UUID.fromString(updateProductDetailsDTO.id()));

        if(productOptional.isEmpty()) {
            throw new NotFoundException(updateProductDetailsDTO.id() + " not found");
        }

        Product product = productOptional.get();

        product.setTitle(updateProductDetailsDTO.title());
        product.setDescription(updateProductDetailsDTO.description());
        product.setPrice(updateProductDetailsDTO.price());
        product.setImage(updateProductDetailsDTO.image());
        productRepository.save(product);

        GenericProductDTO response = new GenericProductDTO(product.getId().toString(), product.getTitle(), product.getPrice(), product.getCategory().getName(),
                product.getDescription(), product.getImage());

        return response;

    }

    @Override
    @Transactional
    public void deleteProduct(UUID id) {

        productRepository.deleteProductById(id);


    }

    @Override
    public List<GenericProductDTO> getAllProductsByCategory(UUID id) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty()) {
            throw new NotFoundException(id + "Category not found");
        }
        List<GenericProductDTO> response = new ArrayList<>();
        List<Product> products = productRepository.getProductsByCategory(categoryOptional.get());

        for(Product product : products) {

            GenericProductDTO genericProductDTO = new GenericProductDTO(product.getId().toString(), product.getTitle(), product.getPrice(), product.getCategory().getName(),
                    product.getDescription(), product.getImage());

            response.add(genericProductDTO);
        }

        return response;
    }


}
