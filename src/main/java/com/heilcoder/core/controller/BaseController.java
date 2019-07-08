package com.heilcoder.core.controller;

import com.heilcoder.core.pojo.Response;

import org.springframework.web.bind.annotation.RestController;

public abstract class BaseController<T>{

    private Response response = new Response<>();
    
	protected Response success() {
        return response.success();
	}
	protected Response success(String message) {
        return response.success(message);
	}
	protected Response success(T data) {
        return response.success(data);
	}
	protected Response success(String message,T data) {
        return response.success(message,data);
	}

	protected Response error() {
        return response.error();
	}
	protected Response error(Integer code) {
        return response.error(code);
	}
	protected Response error(String message) {
        return response.error(message);
	}
	protected Response error(T data) {
        return response.error(data);
	}
	protected Response error(Integer code,String message) {
        return response.error(code,message);
	}
	protected Response error(Integer code,T data) {
        return response.error(code,data);
	}
	protected Response error(String message,T data) {
        return response.error(message,data);
	}
	protected Response error(Integer code,String message,T data) {
        return response.error(code,message,data);
	}
}
