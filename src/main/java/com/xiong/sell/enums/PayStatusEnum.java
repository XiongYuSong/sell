package com.xiong.sell.enums;

import lombok.Getter;

/**
 * @author Xiong YuSong
 * 2019/1/18 9:53
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    /**
     * 等待支付
     */
    WAIT(0, "等待支付"),
    /**
     * 支付成功
     */
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
