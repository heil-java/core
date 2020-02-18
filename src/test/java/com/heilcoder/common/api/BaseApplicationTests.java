package com.heilcoder.common.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.heilcoder.common.api.controller.BaseController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests extends BaseController{

	@Test
	public void successTest() {
        System.out.println("测试success()");
        System.out.println(success("测试"));
        System.out.println(success());
        System.out.println(success(123456789));
        System.out.println(success(false));
	}
	@Test
	public void errorTest() {
        System.out.println("测试error()");
        System.out.println(error(0));
        System.out.println(error(2));
        System.out.println(error("测试error自定义message"));
        System.out.println(error(0,"测试error传入code为0时被替换为默认值1"));
        System.out.println(error(2,"测试error自定义message"));
        System.out.println(error(3,"测试error传入data",false));
        System.out.println(error(4,"测试error传入data",123456));
        System.out.println(error(123));
        System.out.println(error(false));
	}
}
