package com.xiong.sell.utils;

import java.util.Random;

/**
 * @author Xiong YuSong
 * 2019/1/18 14:08
 */
public class KeyUtil {

    /**
     * 生成唯一的Key
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer a = random.nextInt(900000) + 10000;
        return System.currentTimeMillis() + String.valueOf(a);
    }
}
