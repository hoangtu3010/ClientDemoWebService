package com.example.ClientDemo3.service;

import com.example.ClientDemo3.entity.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductService {
    @GET("api/v1/products")
    public Call<List<Product>> getProducts();

    @GET("api/v1/products/{id}")
    public Call<Product> getProductDetails(@Path("id") Integer id);

    @POST("api/v1/products")
    public Call<Product> save(@Body Product product);

    @PUT("api/v1/products/{id}")
    public Call<Boolean> update(@Path("id") Integer id, @Body Product product);

    @DELETE("api/v1/products/{id}")
    public Call<Boolean> delete(@Path("id") Integer id);
}
