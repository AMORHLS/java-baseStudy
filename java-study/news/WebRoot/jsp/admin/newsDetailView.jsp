<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.sun.xml.internal.bind.v2.model.core.ID"%>
<%@page import="com.zl.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
	</head>
<body>
传递过来的新闻ID：${param.id }
<%
//新闻详情页
//先把传过来的ID拿到
	int id = Integer.parseInt(request.getParameter("id"));
	//调用后台方法根据id去查询新闻
	News news = newsService.getNewsById(id);
	//将对象放进作用域才能使用EL表达式进行取值
	request.setAttribute("news", news);

 %>
<div class="main-content-right">
      
        <div class="main-text-box">
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                    	<!--新闻的标题-->
                        <h1>${news.title }</h1>
                        <div class="source-bar">发布者：${news.author }分类：新闻信息 更新时间：${news.createDate }</div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：${news.summary }</b></span>
                                 <% // 新闻图片及新闻内容
                                 if(news.getPicPath()==null||"".equals(news.getPicPath())){
                                  %>
                                 新闻图片:暂无<br/> 
                                 <%}else{ %>
                                 <img src="<%=request.getContextPath()%>/upload<%=news.getPicPath()%>"/>
                                 <%} %>
                                 ${news.content }<!-- 新闻内容：三元的判断 -->
                         </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</body>
</html>