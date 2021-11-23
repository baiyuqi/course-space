package com.hbpvu.jec.bookstore.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.hbpvu.jec.bookstore.aop.Cache;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;
import com.hbpvu.jec.bookstore.catalog.web.CreateProductRequest;
import com.hbpvu.jec.bookstore.catalog.web.ProductResponse;
import com.hbpvu.jec.bookstore.catalog.web.ProductsPagedResponse;
import com.hbpvu.jec.bookstore.catalog.web.UpdateProductRequest;

import javax.validation.Valid;
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
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductRequest createProductRequest){

        String product = productService.createProduct(createProductRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{productId}")
                .buildAndExpand(product).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productId") String productId) {

        ProductResponse product = productService.getProduct(productId);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{productId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> deleteProductCategory(@PathVariable("productId") String productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/product")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
        productService.updateProduct(updateProductRequest);
        return ResponseEntity.noContent().build();
    }

 
    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<?> getAllProducts(@RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "size", required = false) Integer size,
                                            PagedResourcesAssembler<ProductResponse> assembler) {

        Page<ProductResponse> list = productService.getAllProducts(sort, page, size);
        ProductsPagedResponse productsPagedResponse = new ProductsPagedResponse();
        productsPagedResponse.setPage(list);
        return ResponseEntity.ok(productsPagedResponse);

    }
}
