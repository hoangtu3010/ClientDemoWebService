package com.example.ClientDemo3.controller;

import com.example.ClientDemo3.retrofit.RetrofitGenerator;
import com.example.ClientDemo3.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductController extends HttpServlet {
    private final ProductService productService;

    public DeleteProductController() {
        productService = RetrofitGenerator.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id).execute();
        resp.sendRedirect("/products");
    }
}
