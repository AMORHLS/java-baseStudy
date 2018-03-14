package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {

	public MyServlet3() {
		super();
	}

	public void destroy() {
		System.out.println("销毁servlet***");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入doGet***");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入doPost***");
	}

	public void init() throws ServletException {
		System.out.println("初始化servlet***");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("进入service***");
		super.service(arg0, arg1);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化servlet***");
		String name=config.getInitParameter("charsetname");
		System.out.println(name);
		super.init(config);
	}

}
