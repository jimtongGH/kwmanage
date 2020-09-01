package com.taianting.springboot.util;

import java.util.Random;

public class SaltUtil {
    /**
     * 获取随机数
     * @param length 随机数长度
     * @return
     */
    public static String getRandomStr(int length){
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString().toUpperCase();
    }
}
