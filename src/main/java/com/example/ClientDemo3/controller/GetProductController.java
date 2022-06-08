package com.example.ClientDemo3.controller;

import com.example.ClientDemo3.entity.Product;
import com.example.ClientDemo3.retrofit.RetrofitGenerator;
import com.example.ClientDemo3.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetProductController extends HttpServlet {
    private final ProductService productService;

    public GetProductController() {
        productService = RetrofitGenerator.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getProducts().execute().body();
        req.setAttribute("listProducts", products);
        req.getRequestDispatcher("/product/product-list.jsp").forward(req, resp);
    }
}
