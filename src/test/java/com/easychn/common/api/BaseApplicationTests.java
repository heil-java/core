package com.easychn.common.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.easychn.common.api.vo.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests{

	@Test
	public void successTest() {
		Response<Object> response = new Response<Object>();
        System.out.println("测试success()");
        System.out.println(response.success("测试"));
        System.out.println(response.success());
        System.out.println(response.success(123456789));
        System.out.println(response.success(false));
	}
	@Test
	public void errorTest() {
		Response<Object> response = new Response<Object>();
        System.out.println("测试error()");
        System.out.println(response.error(0));
        System.out.println(response.error(2));
        System.out.println(response.error("测试error自定义message"));
        System.out.println(response.error(0,"测试error传入code为0时被替换为默认值1"));
        System.out.println(response.error(2,"测试error自定义message"));
        System.out.println(response.error(3,"测试error传入data",false));
        System.out.println(response.error(4,"测试error传入data",123456));
        System.out.println(response.error(123));
        System.out.println(response.error(false));
	}
}
