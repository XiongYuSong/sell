package com.xiong.sell.repository;

import com.xiong.sell.dataobject.ProductCategory;
import com.xiong.sell.service.impl.ProductCategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Xiong YuSong
 * 2019/1/17 9:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOneTest() {
        Optional<ProductCategory> optional = repository.findById(1);
        if (optional.isPresent()) {
            System.out.println(optional.get().toString());
        }
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory  = null;
        Optional<ProductCategory> optional = repository.findById(3);
        if (optional.isPresent()) {
            productCategory = optional.get();
        }
        productCategory.setCategoryName("女生");
        repository.save(productCategory);
    }
}