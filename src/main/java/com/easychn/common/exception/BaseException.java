package com.easychn.common.exception;

/**
 * 自定义异常类
 */
public class BaseException extends Exception{
	private static final long serialVersionUID = 3938034262156625393L;

	//构造函数
    public BaseException(String message){
        super(message);
    }
}
