package com.productapp.service;

import com.productapp.dao.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProducts();
    public Product getById(String id);
    public Product addProduct(Product product);
    public Product updateProduct(String id, Product product);
    public Product deleteProduct(String id);

    public List<Product> getProductsByName(String name);
}
