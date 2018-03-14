package com.zl.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.pojo.News;
import com.zl.service.NewsService;
import com.zl.service.impl.NewsServiceImpl;

public class DeleteService extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);//万能写法
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //删除新闻的处理页面 获取要删除新闻的id  调用后台方法，根据id将该新闻删除
	    int id = Integer.parseInt(request.getParameter("id"));
	    News news = new News();
	    news.setId(id);
	    String flag = "failed";
	    NewsService newsService = new NewsServiceImpl();
	    if(newsService.deleteNews(news)){
	    	flag = "success";
	    }
	    response.sendRedirect("/news/jsp/admin/newsDetailList.jsp?flag="+flag);
	}

	
}
