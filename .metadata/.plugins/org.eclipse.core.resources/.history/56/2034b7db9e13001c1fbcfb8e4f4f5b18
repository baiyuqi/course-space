package com.hbpvu.jec.bookstore.category.service.impl2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hbpvu.jec.bookstore.category.repository.ProductCategoryRepository;
import com.hbpvu.jec.bookstore.category.repository.dao.ProductCategory;
import com.hbpvu.jec.bookstore.category.service.ImplSwitch;
import com.hbpvu.jec.bookstore.category.service.ProductCategoryService;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-06
 */
@Service
@Primary
public class ProductCategoryServiceImpl2 implements ProductCategoryService {

    @PersistenceContext  EntityManager em;

    @Override
    public String createProductCategory(
    		ProductCategory cat) {
        em.persist(cat);
        return cat.getId();
    }

    @Override
    public ProductCategory getProductCategory(String productCategoryId) {
    	ProductCategory rst = em.find(ProductCategory.class, productCategoryId);
        return rst;
    }

    @Override
    public void deleteProductCategory(String productCategoryId) {
    	ProductCategory rst = em.find(ProductCategory.class, productCategoryId);
        em.remove(rst);

    }

    @Override
    public void updateProductCategory(ProductCategory cat ) {

        //To check weather the ProductCategory exist.
        ProductCategory old =
                this.getProductCategory(cat.getId());
        old.setName(cat.getName());
        old.setDescription(cat.getName());
        em.persist(old);

    }
    
    @Override
    public Page<ProductCategory> getAllProductCategories(String sort, Integer page, Integer size) {
        
        //set defaults
        if (size == null || size == 0) {
            size = 20;
        }
        
        //set defaults
        if (page == null || page == 0) {
            page = 0;
        }
        
        Pageable pageable;
        
        if (sort == null) {
            pageable = PageRequest.of(page, size);
        } else {
            Sort.Order order;
            
            try {
                String[] split = sort.split(",");
                
                Sort.Direction sortDirection = Sort.Direction.fromString(split[1]);
                order = new Sort.Order(sortDirection, split[0]).ignoreCase();
                pageable = PageRequest.of(page, size, Sort.by(order));
                
            } catch (Exception e) {
                throw new RuntimeException("Not a valid sort value, It should be 'fieldName,direction', example : 'productCategoryName,asc");
            }
            
        }
        
        List<ProductCategory> data = em.createQuery("from ProductCategory", ProductCategory.class).setFirstResult((int)pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        
        Page<ProductCategory> rst = new  PageImpl<ProductCategory>(data,pageable, data.size());
        return rst;
    }
}
