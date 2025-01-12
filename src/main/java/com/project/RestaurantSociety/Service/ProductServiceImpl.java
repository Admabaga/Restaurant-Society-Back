package com.project.RestaurantSociety.Service;

import com.project.RestaurantSociety.Converter.ProductConverter;
import com.project.RestaurantSociety.DTO.ProductDTO;
import com.project.RestaurantSociety.Entity.Product;
import com.project.RestaurantSociety.Entity.User;
import com.project.RestaurantSociety.Repository.ProductRepository;
import com.project.RestaurantSociety.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()){
            throw new RuntimeException("Usuario no existe.");
        }
        User user = userOptional.get();
        Product product = ProductConverter.dtoToEntity(productDTO);
        fieldValidate(product);
        product.setUser(user);
        productRepository.save(product);
        return ProductConverter.entityToDto(product);
    }

    @Override
    public List<ProductDTO> getProducts(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()){
            throw new RuntimeException("Usuario no existe.");
        }
        List<Product> products = productRepository.findUserProductsById(userId);
        return products.stream()
                .map(ProductConverter::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (!productOptional.isPresent()){
            throw new RuntimeException(String.format("El producto con id %s no existe.", productId));
        }
        Product product = productOptional.get();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setDescription(productDTO.getDescription());
        productRepository.save(product);
        return ProductConverter.entityToDto(product);
    }

    public void fieldValidate(Product product){
        if (product.getProductName().isEmpty() || product.getProductName() == null){
            throw new RuntimeException("Debe ingresar un nombre del producto.");
        }
        if (product.getProductPrice().isNaN() || product.getProductPrice() == null){
            throw new RuntimeException("Debe ingresar un precio valido para el producto.");
        }
    }
}
