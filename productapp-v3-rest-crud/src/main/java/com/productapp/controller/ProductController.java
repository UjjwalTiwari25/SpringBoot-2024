package com.productapp.controller;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //----get all products

    @GetMapping(path = "products")
    public List<Product> getAll(){
        return productService.getProducts();
    }

    //----get product by id
    @GetMapping(path = "products/{id}")
    public Product getById(@PathVariable(name = "id")  int id){
        return productService.getById(id);
    }

    //----add product
    @PostMapping(path = "products")
    public Product addProduct(@RequestBody Product product){
        return  productService.addProduct(product);
    }
    //----update product
    @PutMapping(path = "products/{id}")
    public Product updateProduct(@PathVariable(name = "id")  int id, @RequestBody Product product){
        return  productService.updateProduct(id, product);
    }

    //----delete by id product
    @DeleteMapping (path = "products/{id}")
    public Product deleteById(@PathVariable(name = "id")  int id){
        return productService.deleteProduct(id);
    }

}
