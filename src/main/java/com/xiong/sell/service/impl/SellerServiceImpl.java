package com.xiong.sell.service.impl;

import com.xiong.sell.dataobject.SellerInfo;
import com.xiong.sell.repository.SellerInfoRepository;
import com.xiong.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiong YuSong
 * 2019/1/27 19:52
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findSellerInfoByOpenid(openid);
    }
}
