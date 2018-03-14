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
		System.out.println("CharEncodingFilter销毁**");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//所有中文进行统一编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//这句话必须加，进行下一程序
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("CharEncodingFilter初始化**");
	}

}
