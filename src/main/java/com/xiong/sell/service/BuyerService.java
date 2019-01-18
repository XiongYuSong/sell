package com.xiong.sell.service;

import com.xiong.sell.dto.OrderDTO;

/**
 * @author Xiong YuSong
 * 2019/1/18 20:59
 */
public interface BuyerService {
    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
