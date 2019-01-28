package com.xiong.sell.service;

import com.xiong.sell.dto.OrderDTO;

/**
 * @author Xiong YuSong
 * 2019/1/28 17:01
 */
public interface PushMessage {

    void orderStatus(OrderDTO orderDTO);
}
