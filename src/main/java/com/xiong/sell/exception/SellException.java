package com.xiong.sell.exception;

import com.xiong.sell.enums.ResultEnum;

/**
 * @author Xiong YuSong
 * 2019/1/18 13:41
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
