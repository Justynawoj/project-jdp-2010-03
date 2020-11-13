package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.exception.NotFoundException;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(final Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product with id: " + productId + " is not present in DB"));
    }

    @Override
    public void deleteProduct(final Long productId) {
        Product productToDelete = findById(productId);
        productRepository.delete(productToDelete);
    }

    @Override
    public Product saveProduct(final Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(final Long productId, final Product product) {
        Product productToUpdate = findById(productId);
        productToUpdate.setGroup(product.getGroup());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantityInStock(product.getQuantityInStock());
        productToUpdate.setTitle(product.getTitle());

        return productRepository.save(productToUpdate);
    }
}



