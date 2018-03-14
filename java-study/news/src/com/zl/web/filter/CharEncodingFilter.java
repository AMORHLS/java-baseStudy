package com.zl.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharEncodingFilter implements Filter {

	public void destroy() {
		System.out.println("CharEncodingFilter����**");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�������Ľ���ͳһ����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//��仰����ӣ�������һ����
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CharEncodingFilter��ʼ��**");
	}

}
