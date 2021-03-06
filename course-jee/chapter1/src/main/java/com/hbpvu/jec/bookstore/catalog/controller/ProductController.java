package com.hbpvu.jec.bookstore.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;

import java.net.URI;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody Product createProductRequest){

        String product = productService.createProduct(createProductRequest);


        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {

        Product product = productService.getProduct(productId);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{productId}")
 
    public ResponseEntity<?> deleteProductCategory(@PathVariable("productId") String productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/product")

    public ResponseEntity<?> updateProduct(@RequestBody Product  updateProductRequest) {

        productService.updateProduct(updateProductRequest);

        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<?> getAllProducts(@RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "size", required = false) Integer size
                                            ) {

        Page<Product> list = productService.getAllProducts(sort, page, size);
    
      
        return ResponseEntity.ok(list);

    }
}
