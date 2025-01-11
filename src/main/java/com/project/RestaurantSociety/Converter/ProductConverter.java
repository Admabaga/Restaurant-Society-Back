package com.project.RestaurantSociety.Converter;

import com.project.RestaurantSociety.DTO.ProductDTO;
import com.project.RestaurantSociety.Entity.Product;

public class ProductConverter {

    public static Product dtoToEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setDescription(productDTO.getDescription());
        return product;
    }

    public static ProductDTO entityToDto(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }
}
