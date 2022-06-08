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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UpdateProductController extends HttpServlet {
    private static Product obj;

    private final ProductService productService;

    public UpdateProductController() {
        productService = RetrofitGenerator.createService(ProductService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        obj = productService.getProductDetails(id).execute().body();
        if (obj == null) {
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        } else {
            req.setAttribute("product", obj);
            req.getRequestDispatcher("/product/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        obj.setName(req.getParameter("name"));
        obj.setPrice(new BigDecimal(req.getParameter("price")));

        productService.update(id, obj).execute();
        resp.sendRedirect("/products");
    }
}
