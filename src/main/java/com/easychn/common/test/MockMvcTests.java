package com.easychn.common.test;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

public class MockMvcTests{

	public static String request(MockMvc mockMvc,MockHttpServletRequestBuilder mockHttpServletRequestBuilder) {
		try {
			String result = "";
			result =  mockMvc.perform(mockHttpServletRequestBuilder).andExpect(status().isOk())
				.andDo(print()).andReturn().getResponse().getContentAsString();
			System.err.println(result);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static String request(ResultActions resultActions) {
		try {
			String result = "";
			result =  resultActions.andExpect(status().isOk())
				.andDo(print()).andReturn().getResponse().getContentAsString();
			System.err.println(result);
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
