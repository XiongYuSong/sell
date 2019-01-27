package com.xiong.sell.controller;

import com.xiong.sell.dataobject.ProductCategory;
import com.xiong.sell.enums.ResultEnum;
import com.xiong.sell.exception.SellException;
import com.xiong.sell.form.CategoryForm;
import com.xiong.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Xiong YuSong
 * 2019/1/27 13:19
 */
@Controller
@Slf4j
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        //如果categoryId不为空，则查找出来保存
        if (categoryId != null && categoryId > 0) {
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }


    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        //1.表单验证
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        ProductCategory category = new ProductCategory();
        if (categoryForm.getCategoryId() != null && categoryForm.getCategoryId() > 0) {
            category = categoryService.findOne(categoryForm.getCategoryId());
        }
        BeanUtils.copyProperties(categoryForm, category);
        //2.保存
        try {
            categoryService.save(category);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        //3.跳转保存成功页面
        map.put("msg", ResultEnum.CATEGORY_SAVE_SUCCESS.getMessage());
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
