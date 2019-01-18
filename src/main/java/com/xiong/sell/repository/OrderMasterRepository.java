package com.xiong.sell.repository;

import com.xiong.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Xiong YuSong
 * 2019/1/18 9:58
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**
     * 分页显示，通过买家的openid查找他的订单信息
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
