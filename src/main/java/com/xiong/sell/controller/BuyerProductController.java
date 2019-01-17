package com.xiong.sell.controller;

import com.xiong.sell.dataobject.ProductCategory;
import com.xiong.sell.dataobject.ProductInfo;
import com.xiong.sell.service.ProductCategoryService;
import com.xiong.sell.service.ProductInfoService;
import com.xiong.sell.service.impl.ProductCategoryServiceImpl;
import com.xiong.sell.service.impl.ProductInfoServiceImpl;
import com.xiong.sell.utils.ResultVOUtils;
import com.xiong.sell.vo.ProductInfoVO;
import com.xiong.sell.vo.ProductVO;
import com.xiong.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiong YuSong
 * 2019/1/17 17:27
 */
@Controller
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @GetMapping("/list")
    @ResponseBody
    public ResultVO list() {
        // 1）查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        // 2）通过商品查询响应的类目
        List<Integer> categoryTypeList = productInfoList.stream().map(x -> x.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        // 3）拼装成对应的json
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType()) ){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtils.success(productVOList);
    }
}
