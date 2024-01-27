package com.productapp.controller;

import com.productapp.config.AppConfig;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ProductService productService=new ProductServiceImpl();
//        List<Product> products=productService.getProducts();
//        products.forEach(p-> System.out.println(p));

        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService=ctx.getBean("ps", ProductService.class);
        List<Product> products=productService.getProducts();
        products.forEach(p-> System.out.println(p));
    }
}
