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

    @PostMapping("/products")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return  productService.createProduct(productDTO);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @PutMapping("/products")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long productId){
        return  productService.updateProduct(productDTO, productId);
    }
}
