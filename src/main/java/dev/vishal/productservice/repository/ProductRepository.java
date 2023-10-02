package dev.vishal.productservice.repository;


import dev.vishal.productservice.dto.AddProductResponse;
import dev.vishal.productservice.model.Category;
import dev.vishal.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Modifying
    @Query(value = "insert into Product (title, description, category, price, image) values(:title, :description, :category,:price, :image)", nativeQuery = true)
    Product saveProduct(@Param("title") String title, @Param("description") String description, @Param("category") UUID category, @Param("price") double price, @Param("image") String image);

    Optional<Product> findById(UUID id);

    void deleteProductById(UUID id);

//    @Query(value = "select p from Product p where p.category = :id")
//    List<Product> getProductByCategory(@Param("id") UUID id);

    List<Product>  getProductsByCategory(Category category);

}
