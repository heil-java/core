package com.easychn.common.api.controller;

import com.easychn.common.api.vo.Response;

public abstract class BaseController{

    private Response<Object> response = new Response<>();
    
	protected Response<?> success() {
        return response.success();
	}
	protected Response<?> success(String message) {
        return response.success(message);
	}
	protected <T> Response<?> success(T data) {
        return response.success(data);
	}
	protected <T> Response<?> success(String message,T data) {
        return response.success(message,data);
	}

	protected Response<?> error() {
        return response.error();
	}
	protected Response<?> error(Integer code) {
        return response.error(code);
	}
	protected Response<?> error(String message) {
        return response.error(message);
	}
	protected <T> Response<?> error(T data) {
        return response.error(data);
	}
	protected Response<?> error(Integer code,String message) {
        return response.error(code,message);
	}
	protected <T> Response<?> error(Integer code,T data) {
        return response.error(code,data);
	}
	protected <T> Response<?> error(String message,T data) {
        return response.error(message,data);
	}
	protected <T> Response<?> error(Integer code,String message,T data) {
        return response.error(code,message,data);
	}
}
