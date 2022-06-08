package com.example.ClientDemo3.controller;

import com.example.ClientDemo3.entity.Product;
import com.example.ClientDemo3.retrofit.RetrofitGenerator;
import com.example.ClientDemo3.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CreateProductController extends HttpServlet {
    private static Product obj;

    private final ProductService productService;

    public CreateProductController() {
        productService = RetrofitGenerator.createService(ProductService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obj = new Product("Product new", new BigDecimal(10));
        req.setAttribute("product", obj);
        req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        obj.setName(req.getParameter("name"));
        obj.setPrice(new BigDecimal (req.getParameter("price")));

        productService.save(obj).execute();
        resp.sendRedirect("/products");
    }
}
