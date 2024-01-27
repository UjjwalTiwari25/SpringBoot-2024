package com.productapp.service;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.dao.ProductDaoJdbcImpl;
import com.productapp.dao.ProductDaoMapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//PS ---> PD pull
@Service(value = "ps")
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getProducts() {
        if(1==1)
            throw new RuntimeException("some internal server error");
        return productDao.getProducts();
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productDao.updateProduct(id, product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
}
