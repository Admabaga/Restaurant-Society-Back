package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, Long userId);

    List<ProductDTO> getProducts(Long userId);

    ProductDTO updateProduct(ProductDTO productDTO, Long productId);
}
