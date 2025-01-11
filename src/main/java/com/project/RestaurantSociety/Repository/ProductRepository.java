package com.project.RestaurantSociety.Repository;

import com.project.RestaurantSociety.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
