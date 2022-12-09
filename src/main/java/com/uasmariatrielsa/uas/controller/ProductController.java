/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uasmariatrielsa.uas.controller;
import com.uasmariatrielsa.uas.model.Product;
import com.uasmariatrielsa.uas.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8088/product
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }
    // http://localhost:8088/product/1   (PathVariable) Detail

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }
    // http://localhost:8088/product 

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
    // http://localhost:8088/product/1

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        return productService.delete(id);
    }
    // http://localhost:8088/product/1

}

