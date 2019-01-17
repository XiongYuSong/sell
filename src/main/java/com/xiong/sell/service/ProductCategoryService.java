package com.xiong.sell.service;

import com.xiong.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 * @author Xiong YuSong
 * 2019/1/17 11:21
 */
public interface ProductCategoryService {
    /**
     * 查找一个商品类目
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找全部商品类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过多个商品属性查找商品类目
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存一个商品类目
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
