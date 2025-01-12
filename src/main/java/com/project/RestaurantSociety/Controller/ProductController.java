package com.project.RestaurantSociety.Controller;

import com.project.RestaurantSociety.DTO.ProductDTO;
import com.project.RestaurantSociety.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/users/{userId}/products")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO, @PathVariable Long userId){
        return  productService.createProduct(productDTO, userId);
    }

    @GetMapping("/users/{userId}/products")
    public List<ProductDTO> getProducts(@PathVariable Long userId){
        return productService.getProducts(userId);
    }

    @PutMapping("/users/{userId}/products/{productId}")
    public ProductDTO updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO ){
        return  productService.updateProduct(productDTO, productId);
    }
}
