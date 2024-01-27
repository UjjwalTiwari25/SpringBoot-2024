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

    //    //?
//    public ProductServiceImpl(){
//        productDao=new ProductDaoMapImpl();
//    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}
