package com.xiong.sell.service.impl;

import com.xiong.sell.dataobject.ProductInfo;
import com.xiong.sell.enums.ProductStatusEnum;
import com.xiong.sell.repository.ProductInfoRepository;
import com.xiong.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 商品详细
 *
 * @author Xiong YuSong
 * 2019/1/17 15:30
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> optional = productInfoRepository.findById(productId);
        ProductInfo productInfo = null;
        if (optional.isPresent()) {
            productInfo = optional.get();
        }
        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
