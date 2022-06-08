package com.example.ClientDemo3.service;

import com.example.ClientDemo3.entity.Product;
import com.example.ClientDemo3.retrofit.RetrofitGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    ProductService productService = RetrofitGenerator.createService(ProductService.class);

    @Test
    void getProducts() {
        try {
            List<Product> products = productService.getProducts().execute().body();
            for (Product pro : products){
                System.out.println(pro.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getProductDetails() {
        try {
            Product product = productService.getProductDetails(1).execute().body();
            System.out.println(product.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() {
        productService.save(new Product("Product 6", new BigDecimal(23)));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}