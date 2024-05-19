package com.safeguard.safeguardbackend.rest;

import com.safeguard.safeguardbackend.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public interface ProductController {

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    ResponseEntity<Integer> createProduct(@RequestBody Product product);

    @RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
    ResponseEntity<Product> retrieveProduct(@PathVariable("id") Integer productId);

    @RequestMapping(path = "/product", method = RequestMethod.GET)
    ResponseEntity<List<Product>> retrieveProducts();

    @RequestMapping(path = "/product/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer productId);
}
