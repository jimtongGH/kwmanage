package com.taianting.springboot.result;

/**
 * @author Shengjin Tong
 * @date 2020/1/12 - 5:04 下午
 */
public class Result {
    private int code;

    public Result(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }
}
