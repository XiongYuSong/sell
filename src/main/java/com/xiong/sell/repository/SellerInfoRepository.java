package com.xiong.sell.repository;

import com.xiong.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xiong YuSong
 * 2019/1/27 19:45
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    /**
     * 通过openid查找卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
