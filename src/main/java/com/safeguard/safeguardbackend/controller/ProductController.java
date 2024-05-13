package com.safeguard.safeguardbackend.controller;

import com.safeguard.safeguardbackend.model.Product;
import com.safeguard.safeguardbackend.model.PetData;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;


@RestController
@EnableWebMvc
public class ProductController {
    @RequestMapping(path = "/pets", method = RequestMethod.POST)
    public Product createPet(@RequestBody Product newProduct) {
        if (newProduct.getName() == null || newProduct.getBreed() == null) {
            return null;
        }

        Product dbProduct = newProduct;
        dbProduct.setId(UUID.randomUUID().toString());
        return dbProduct;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public Product[] listPets(@RequestParam("limit") Optional<Integer> limit, Principal principal) {
        int queryLimit = 10;
        if (limit.isPresent()) {
            queryLimit = limit.get();
        }

        Product[] outputProducts = new Product[queryLimit];

        for (int i = 0; i < queryLimit; i++) {
            Product newProduct = new Product();
            newProduct.setId(UUID.randomUUID().toString());
            newProduct.setName(PetData.getRandomName());
            newProduct.setBreed(PetData.getRandomBreed());
            newProduct.setDateOfBirth(PetData.getRandomDoB());
            outputProducts[i] = newProduct;
        }

        return outputProducts;
    }

    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public Product listPets() {
        Product newProduct = new Product();
        newProduct.setId(UUID.randomUUID().toString());
        newProduct.setBreed(PetData.getRandomBreed());
        newProduct.setDateOfBirth(PetData.getRandomDoB());
        newProduct.setName(PetData.getRandomName());
        return newProduct;
    }

}