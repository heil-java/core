package com.easychn.common.api.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;;

@ApiModel(value = "响应消息")
public class Response<T> implements Serializable{
    private static final long serialVersionUID = 1L;
	
	private static final Integer SUCCESS = 0;
	private static final String SUCCESS_MESSAGE = "操作成功";

	private static final Integer ERROR = 1;
	private static final String ERROR_MESSAGE = "操作失败";
	
    @ApiModelProperty(value = "状态代码",required = true)
	private Integer code;
	
    @ApiModelProperty(value = "描述",required = true)
	private String message;

    @ApiModelProperty(value = "描述",required = true)
	private T data;
	
    public Response (){
		this.code = ERROR;
		this.message = ERROR_MESSAGE;
    }

	public Response<T> success() {
		this.code = SUCCESS;
		this.message = SUCCESS_MESSAGE;
        this.data = null;
        return this;
	}
	public Response<T> success(String message) {
		this.code = SUCCESS;
		this.message = (message == null || message.length() <= 0) ? SUCCESS_MESSAGE : message;
        this.data = null;
        return this;
	}
	public Response<T> success(T data) {
		this.code = SUCCESS;
		this.message = SUCCESS_MESSAGE;
		this.data = data;
        return this;
	}
	public Response<T> success(String message,T data) {
		this.code = SUCCESS;
		this.message = (message == null || message.length() <= 0) ? SUCCESS_MESSAGE : message;
		this.data = data;
        return this;
	}
	
	public Response<T> error() {
		this.code = ERROR;
		this.message = ERROR_MESSAGE;
        this.data = null;
        return this;
	}
	public Response<T> error(Integer code) {
		this.code = (code == null || code.equals(SUCCESS)) ? ERROR : code;
		this.message = ERROR_MESSAGE;
        this.data = null;
        return this;
	}
	public Response<T> error(String message ) {
		this.code = ERROR;
		this.message = (message == null || message.length() <= 0) ? ERROR_MESSAGE : message;
        this.data = null;
        return this;
	}
	public Response<T> error(T data) {
		this.code = ERROR;
		this.message = ERROR_MESSAGE;
		this.data = data;
        return this;
	}
	public Response<T> error(Integer code,String message) {
		this.code = (code == null || code.equals(SUCCESS)) ? ERROR : code;
		this.message = (message == null || message.length() <= 0) ? ERROR_MESSAGE : message;
        this.data = null;
        return this;
	}
	public Response<T> error(Integer code,T data) {
		this.code = (code == null || code.equals(SUCCESS)) ? ERROR : code;
		this.message = ERROR_MESSAGE;
		this.data = data;
        return this;
	}
	public Response<T> error(String message,T data) {
		this.code = ERROR;
		this.message = (message == null || message.length() <= 0) ? ERROR_MESSAGE : message;
		this.data = data;
        return this;
	}
	public Response<T> error(Integer code,String message,T data) {
		this.code = (code == null || code.equals(SUCCESS)) ? ERROR : code;
		this.message = (message == null || message.length() <= 0) ? ERROR_MESSAGE : message;
		this.data = data;
        return this;
	}
}
