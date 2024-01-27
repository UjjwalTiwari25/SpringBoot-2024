package com.productapp.dao;

import java.util.List;

public interface ProductDao {
	public List<Product> getProducts();
	public Product getById(int id);
	public Product addProduct(Product product);
	public Product updateProduct(int id, Product product);
	public Product deleteProduct(int id);
}
