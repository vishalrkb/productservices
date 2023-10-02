package dev.vishal.productservice.repository;

import dev.vishal.productservice.dto.CategoryDTO;
import dev.vishal.productservice.model.Category;
import dev.vishal.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Modifying
    @Query(value = "insert into Category (name) values(:name)", nativeQuery = true)
    Category saveCategory(@Param("name") String name);

    Optional<Category> findCategoryByName(String name);


}
