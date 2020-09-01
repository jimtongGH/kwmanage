package com.taianting.springboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * MD5 单次加密
     * @param content 加密内容
     * @return 返回结果
     */
    public static String getMd5(String content){
        String result = md5(content);
        return result;
    }

    /**
     * MD5 多次加密
     * @param content  加密字符串
     * @param times 次数
     * @return
     */
    public static String getMd5(String content,int times){
        String result="";
        for(int i=0;i<times;i++){
            content=md5(content);
        }
        result=content;
        return result;
    }

    /**
     * MD5加密码
     * @param content
     * @return
     */
    public static String md5(String content){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(content.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String str = Integer.toHexString(b & 0xFF);
                if (str.length() == 1) {
                    sb.append("0");
                }
                sb.append(str);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result.toUpperCase();
    }
}
