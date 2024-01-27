package com.productapp.controller;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //ResponseEntity= data + status code
    @GetMapping(path = "products")
    public ResponseEntity<List<Product>> getAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    //----get product by id
    @GetMapping(path = "products/{id}")
    public ResponseEntity<Product> getById(@PathVariable(name = "id")  int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    //----add product
    @PostMapping(path = "products")
    public ResponseEntity<Product> addProduct( @Valid @RequestBody Product product){
        Product productAdded=  productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
    }
    //----update product
    @PutMapping(path = "products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "id")  int id, @RequestBody Product product){
        Product productUpdated=  productService.updateProduct(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }

    //----delete by id product
    @DeleteMapping (path = "products/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable(name = "id")  int id){
        Product productDeleted= productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
