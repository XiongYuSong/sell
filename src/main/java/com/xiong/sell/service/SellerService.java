package com.xiong.sell.service;

import com.xiong.sell.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * @author Xiong YuSong
 * 2019/1/27 19:50
 */
public interface SellerService {

    /**
     * 通过openid查找卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
