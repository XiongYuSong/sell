package com.xiong.sell.service;

import com.xiong.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Xiong YuSong
 * 2019/1/18 13:15
 */
@Service
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 根据订单ID查询订单
     * @param orderId
     * @return
     */
    OrderDTO findOne(String orderId);

    /**
     * 通过买家openid查询他的所有订单，分页返回
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     * @param orderDTO
     * @return
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     * @param orderDTO
     * @return
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     * @param orderDTO
     * @return
     */
    OrderDTO paid(OrderDTO orderDTO);

    /**
     * 查询所有的订单
     * @param pageable
     * @return
     */
    Page<OrderDTO> findList(Pageable pageable);
}
