package com.safeguard.safeguardbackend.service;

import com.safeguard.safeguardbackend.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    @Transactional(readOnly = true)
    Product retrieveProduct(Integer productId);

    @Transactional(readOnly = true)
    List<Product> retrieveProducts();

    @Transactional(readOnly = false)
    Void deleteProduct(Integer productId);

    @Transactional(readOnly = false)
    Integer createProduct(Product product);
}
