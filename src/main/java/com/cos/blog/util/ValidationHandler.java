package com.cos.blog.util;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationHandler {
	
	// Don't Repeat Yourself => DRY 하게 코드를 짜세요!!
	public int validation(List<String> keys ,HttpServletRequest request, HttpServletResponse response) {
		Enumeration<String> e = request.getParameterNames();
		
		// 키 값이 null인지 검증
		
		
		// 키 공백인 것 검증
		while (e.hasMoreElements()) {
			String key = e.nextElement();

			if (request.getParameter(key).equals("")) {
				System.out.println(key + "값이 공백입니다");
				return -1;
			}
		}
		return 1;
	}
}
