package com.productapp.service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductRepo;
import com.productapp.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//PS ---> PD pull
@Service(value = "ps")
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;

    private Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo=productRepo;
    }

    @Override
    public List<Product> getProducts() {
        long start= System.currentTimeMillis();
        List<Product> products =productRepo.findAll();
        long end=System.currentTimeMillis();

        logger.info("time taken for ex of getProducts is "+ (end-start)+" ms");
        return products;
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));
    }

    @Override
    public Product addProduct(Product product) {
        productRepo.save(product);
       return  product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getById(id);
        productToUpdate.setPrice(product.getPrice());
        productRepo.save(productToUpdate);

        return productToUpdate;
    }

    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getById(id);
        productRepo.delete(productToDelete);
        return productToDelete;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }
}
