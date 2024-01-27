package com.productapp.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//@Primary
public class ProductDaoJdbcImpl implements ProductDao{

    private static Map<Integer, Product> map=new HashMap<>();
    static {
        map.put(1, new Product(1, "dell laptop", new BigDecimal(100000)));
        map.put(2, new Product(2, "laptop cover", new BigDecimal(1000)));
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("using jdbc implementation");
        return new ArrayList<>(map.values());
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }
}
