package com.project.RestaurantSociety.Repository;

import com.project.RestaurantSociety.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.user u WHERE u.userId = :userId")
    List<Product> findUserProductsById(@Param("userId") Long userId);
}
