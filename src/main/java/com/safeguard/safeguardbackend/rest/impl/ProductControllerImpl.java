package com.safeguard.safeguardbackend.rest.impl;

import com.safeguard.safeguardbackend.rest.ProductController;
import com.safeguard.safeguardbackend.model.Product;

import com.safeguard.safeguardbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductControllerImpl implements ProductController {

    @Autowired
    ProductService productService;

    @Override
    public ResponseEntity<Integer> createProduct(Product product) {
        var response = productService.createProduct(product);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Product> retrieveProduct(Integer productId) {
        var response = productService.retrieveProduct(productId);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<Product>> retrieveProducts() {
        var response = productService.retrieveProducts();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer productId) {
        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }
}