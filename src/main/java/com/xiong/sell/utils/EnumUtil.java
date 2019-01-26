package com.xiong.sell.utils;

import com.xiong.sell.enums.CodeEnum;

/**
 * @author Xiong YuSong
 * 2019/1/26 10:57
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
