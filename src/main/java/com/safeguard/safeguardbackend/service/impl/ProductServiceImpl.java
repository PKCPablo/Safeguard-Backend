package com.safeguard.safeguardbackend.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.safeguard.safeguardbackend.model.Product;
import com.safeguard.safeguardbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Override
    public Product retrieveProduct(Integer productId) {
        return dynamoDBMapper.load(Product.class, productId);
    }

    @Override
    public List<Product> retrieveProducts() {
        return dynamoDBMapper.scan(Product.class, new DynamoDBScanExpression());
    }

    @Override
    public Void deleteProduct(Integer productId) {
        var product = dynamoDBMapper.load(Product.class, productId);
        dynamoDBMapper.delete(product);
        return null;
    }

    @Override
    public Integer createProduct(Product newProduct) {
        dynamoDBMapper.save(newProduct);
        return newProduct.getId();
    }

    @Override
    public Void updateProduct(Integer productId, Product product) {
        dynamoDBMapper.save(product);
        return null;
    }
}
