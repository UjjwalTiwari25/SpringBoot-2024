package com.productapp.service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductRepo;
import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//PS ---> PD pull
@Service(value = "ps")
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo=productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(String id) {
        return productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));
    }

    @Override
    public Product addProduct(Product product) {
        productRepo.save(product);
       return  product;
    }

    @Override
    public Product updateProduct(String id, Product product) {
        Product productToUpdate= getById(id);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);

        return productToUpdate;
    }

    @Override
    public Product deleteProduct(String id) {
        Product productToDelete= getById(id);
        productRepo.delete(productToDelete);
        return productToDelete;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }
}
