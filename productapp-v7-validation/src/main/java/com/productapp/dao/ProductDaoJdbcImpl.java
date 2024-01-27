package com.productapp.dao;

import com.productapp.exceptions.ProductNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class ProductDaoJdbcImpl implements ProductDao{

    private static Map<Integer, Product> map=new HashMap<>();
    private static int counter=2;
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
        Product product= map.get(id);
        if(product==null)
            throw  new ProductNotFoundException("prduct with id "+ id +" is not found");
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        product.setId(++counter);
        map.put(counter, product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productToUpdate= getById(id);
        productToUpdate.setPrice(product.getPrice());
        map.put(id, productToUpdate);
        return productToUpdate;
    }

    @Override
    public Product deleteProduct(int id) {
        Product productToDelete= getById(id);
        map.remove(productToDelete.getId());
        return productToDelete;
    }
}
