package com.xiong.sell.service.impl;

import com.xiong.sell.dataobject.ProductCategory;
import com.xiong.sell.repository.ProductCategoryRepository;
import com.xiong.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiong YuSong
 * 2019/1/17 11:28
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> optional =  productCategoryRepository.findById(categoryId);
        ProductCategory productCategory = null;
        if(optional.isPresent()){
            productCategory = optional.get();
        }
        return productCategory;
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
