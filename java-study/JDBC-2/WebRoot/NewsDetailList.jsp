<%@page import="com.zl.util.PageSupport"%>
<%@page import="com.zl.pojo.News"%>
<%@page import="com.zl.service.impl.NewsServiceImpl"%>
<%@page import="com.zl.service.NewsService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="newsService"
	class="com.zl.service.impl.NewsServiceImpl"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<style type="text/css">
<!--
-->
</style>
<script>
	/*点击增加跳转  */
	function addNews() {
		window.location = "newsDetailCreateSimple.jsp";
	}
	//提交表单frm，偷偷传递页码num
	function page_nav(frm,num){
		//找到表单中的pageIndex，然后赋值num
		frm.pageIndex.value=num;
		frm.submit();
	}
	//提交Go跳转，跳转前需要对数字进行有效验证，如果数字再范围才page_nav()
	function jump_to(frm,pageno){
	 	//var regexp=/^\d+$/;正则表达式^是1-9，结尾$
	 	var regexp=/^[1-9]\d*$/;
	 	var totalPage = document.getElementById("totalPage").value;
		if(!regexp.test(pageno)){
			alert("请输入 正确的数字！");
			return false;
		}else if((pageno-totalPage) > 0){
			alert("总页码一共"+totalPage+"页，请输入正确的页码！");
			return false;
		}else{
			page_nav(frm,pageno);
		}  
		
	}
</script>
</head>

<body>
	<!--页面顶部-->
	<div id="header">
		<div class="main-top">
			<div class="logo">
				<a href=""><span>新闻大视野</span>
				</a>
			</div>

			<div class="nav">
				<ul class="clearfix">
					<li><a href="#">首页</a>
					</li>
					<li><a href="#">国内</a>
					</li>
					<li><a href="#">国际</a>
					</li>
					<li><a href="#">娱乐</a>
					</li>
					<li><a href="#">军事</a>
					</li>
				</ul>
			</div>
		</div>
		<!--banner-->
		<div class="main-banner">
			<img src="images/banner.png" />
		</div>
		<!--管理工具栏-->
		<div class="admin-bar">
			<span class="fr">退出账户</span> 管理员：admin 2012-06-19
		</div>
	</div>
	<!--主体-->
	<div id="content" class="main-content clearfix">
		<div class="main-content-left">
			<!--新闻管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>新闻管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">新闻管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">最新新闻</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--主题管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>分类管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">分类管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">删除主题</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
			<!--账户管理-->
			<div class="class-box">
				<div class="class-box-header">
					<h3>用户管理</h3>
				</div>
				<div class="class-box-content">
					<ul>
						<li><a href="#">用户管理</a>
						</li>
						<li class="clear-bottom-line"><a href="#">付费服务</a>
						</li>
					</ul>
				</div>
			</div>
			<!--//-->
		</div>
		<div class="main-content-right">
			<!--即时新闻-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<form name="searchForm" id="searchForm"
							action="/JDBC-2/NewsDetailList.jsp" method="post">
							<div>
								新闻分类： <select name="categoryId">
									<option value="0">全部</option>

									<option value='1'>国内</option>

									<option value='2'>国际</option>

									<option value='3'>娱乐</option>

									<option value='4'>军事</option>

									<option value='5'>财经</option>

									<option value='6'>天气</option>

								</select> 新闻标题<input type="text" name="title" id="title" value='' />
								<button type="submit" class="page-btn">GO</button>
								<button type="button" onclick="addNews();" class="page-btn">增加</button>
								<input type="hidden" name="pageIndex" value="1" />
								 <!-- <input
									type="hidden" name="pageSize" value="10" /> <input
									type="hidden" name="totalPageCount" value="2" /> -->
							</div>
						</form>
						<table cellpadding="1" cellspacing="1" class="admin-list">
							<thead>
								<tr class="admin-list-head">
									<th>新闻标题</th>
									<th>作者</th>
									<th>时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<%
									//分页查询并显示
									//当前页码
									String currentPage=request.getParameter("pageIndex");
									if(currentPage==null){
									//用户首次访问页面
									currentPage="1";
									}
									int pageIndex =Integer.parseInt(currentPage) ;
									//获取新闻总数量
									int totalCount = newsService.getTotalCount();
									//页容量
									int pageSize = 3;
									//获取总页数
									PageSupport pageSupport = new PageSupport();
									pageSupport.setCurrentPageNo(pageIndex);
									pageSupport.setPageSize(pageSize);
									pageSupport.setTotalCount(totalCount);
									//总页数
									int totalPage = pageSupport.getTotalPageCount();
									//控制首页和尾页
									if(pageIndex<1){
										pageIndex=1;
									}else if(pageIndex>totalPage){
										pageIndex=totalPage;
									}
									/* NewsService newsService = new NewsServiceImpl(); */
									int i = 0;
									List<News> list = newsService.getPageNewsList(pageIndex, pageSize);
									for (News news : list) {
										i++;
								%>
								 <input type="hidden" id="totalPage" value="<%=totalPage%>"/>
								<tr <%if (i % 2 == 0) {%> class="admin-list-td-h2" <%}%>>
									<td><a href='newsDetailView.jsp?id=<%=news.getId()%>'><%=news.getTitle()%></a>
									</td>
									<td><%=news.getAuthor()%></td>
									<td><%=news.getCreateDate()%></td>
									<td><a href='adminNewsCreate.jsp?id=2'>修改</a> <a
										href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=2'">删除</a>
									</td>
								</tr>
								<%
									}
								%>

							</tbody>
						</table>
						<div class="page-bar">
							<ul class="page-num-ul clearfix">
								<li>共<%=totalCount%>条记录&nbsp;&nbsp;<%=pageIndex%>/<%=totalPage%>页</li>
								<%
									if(pageIndex>1){
								 %>
								<%-- <a href="NewsDetailList.jsp?pageIndex=1">首页</a>
								<a href="NewsDetailList.jsp?pageIndex=<%=pageIndex-1%>">上一页</a> --%>
								
								<a href="javaScript:page_nav(document.forms[0],1))">首页</a>
								<a href="javaScript:page_nav(document.forms[0],<%=pageIndex-1%>)">上一页</a>
								<%}if(pageIndex<totalPage){ %>
								<%-- <a href="NewsDetailList.jsp?pageIndex=<%=pageIndex+1%>">下一页</a>
								<a href="NewsDetailList.jsp?pageIndex=<%=totalPage%>">最后一页</a>&nbsp;&nbsp; --%>
								
								<a href="javaScript:page_nav(document.forms[0],<%=pageIndex+1%>)">下一页</a>
								<a href="javaScript:page_nav(document.forms[0],<%=totalPage%>)">最后一页</a>
								<%} %>
								&nbsp;&nbsp;
							</ul>
							<span class="page-go-form"><label>跳转至</label> <input
								type="text" name="inputPage" id="inputPage" class="page-key" />页
								<button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--底部-->
	<div class="main-footer-box">
		24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
		文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
		Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
		新闻中心版权所有
	</div>
</body>
</html>