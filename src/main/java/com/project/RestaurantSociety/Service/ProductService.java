package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    ProductDTO updateProduct(ProductDTO productDTO, Long productId);
}
