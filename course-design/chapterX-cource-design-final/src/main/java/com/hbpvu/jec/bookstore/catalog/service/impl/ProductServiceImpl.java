package com.hbpvu.jec.bookstore.catalog.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hbpvu.jec.bookstore.catalog.repository.ProductCategoryRepository;
import com.hbpvu.jec.bookstore.catalog.repository.ProductRepository;
import com.hbpvu.jec.bookstore.catalog.repository.ReviewRepository;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Product;
import com.hbpvu.jec.bookstore.catalog.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.catalog.repository.dao.Review;
import com.hbpvu.jec.bookstore.catalog.service.ProductService;
import com.hbpvu.jec.bookstore.catalog.service.ReviewService;
import com.hbpvu.jec.bookstore.catalog.web.CreateProductRequest;
import com.hbpvu.jec.bookstore.catalog.web.ProductResponse;
import com.hbpvu.jec.bookstore.catalog.web.UpdateProductRequest;
import com.hbpvu.jec.bookstore.commons.util.CopyUtil;
import com.hbpvu.jec.bookstore.commons.util.IdNameTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.Valid;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    IdNameTransformer transformer;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String createProduct(@Valid CreateProductRequest createProductRequest) {
        Product product = new Product();
        CopyUtil.copy(createProductRequest, product);
        Product savedProduct = productRepository.save(product);
        return savedProduct.getProductId();
    }

    @Override
    public ProductResponse getProduct(String productId) {
        Optional<Product> productOptional =
                productRepository.findById(productId);

        Product product = productOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));
        transformer.fillDictionaryField(product);
        ProductResponse productResponse = objectMapper.convertValue(product, ProductResponse.class);
        populateRatingForProduct(productId, productResponse);
        return productResponse;
    }

    //This way of setting rating for productResponse is not okay, But this is okay for now.
    private void populateRatingForProduct(String productId, ProductResponse productResponse) {
        List<Review> reviewsForProduct = reviewService.getReviewsForProduct(productId);
        if (reviewsForProduct.size() > 0) {
            double sum = reviewsForProduct.stream().mapToDouble(Review::getRatingValue).sum();
            double rating = sum / reviewsForProduct.size();
            productResponse.setAverageRating(rating);
        }

        productResponse.setNoOfRatings(Math.toIntExact(reviewRepository.countAllByProductId(productId)));
    }

    @Override
    public void deleteProduct(String productId) {

        productRepository.deleteById(productId);

    }

    @Override
    public void updateProduct(UpdateProductRequest updateProductRequest) {

        Optional<Product> productOptional =
                productRepository.findById(updateProductRequest.getProductId());

        //check weather product exists
        final Product productExisting = productOptional.orElseThrow(() -> new RuntimeException("Product Id doesn't exist!"));

        productExisting.setProductId(updateProductRequest.getProductId());
        CopyUtil.copy(updateProductRequest, productExisting);
     /*   if (updateProductRequest.getProductName() != null) {
            productExisting.setProductName(updateProductRequest.getProductName());
        }

        if (updateProductRequest.getDescription() != null) {
            productExisting.setDescription(updateProductRequest.getDescription());
        }

        if (updateProductRequest.getPrice() != null) {
            productExisting.setPrice(updateProductRequest.getPrice());
        }

        if (updateProductRequest.getImageId() != null) {
            productExisting.setImageId(updateProductRequest.getImageId());
        }

       
        if (updateProductRequest.getAvailableItemCount() != null) {
            productExisting.setAvailableItemCount(updateProductRequest.getAvailableItemCount());
        }*/

        productExisting.setCreatedAt(productExisting.getCreatedAt());

        productRepository.save(productExisting);
    }

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    
    @Override
    public Page<ProductResponse> getAllProducts(String sort, Integer page, Integer size) {
        
    	Pageable pageable = PageUtils.getPageable(sort, page, size);
        Page<Product> allProducts = productRepository.findAll(pageable);
        /*填充productCategoryName */
        transformer.fillDictionaryFieldList(allProducts.getContent());
        Page<ProductResponse> allProductsResponse = allProducts.map(Product::fromEntity);
        allProductsResponse.forEach(productResponse -> populateRatingForProduct(productResponse.getProductId(), productResponse));

        return allProductsResponse;
    }
    static public void main(String[] s) throws Throwable {
    	Object obj = new Product();
    	Class pt = obj.getClass();
    	 Field fid = pt.getDeclaredField("description");
    	 Column clo = fid.getAnnotation(Column.class);
    	String cname =  clo.name();
    	
    }
}
