<%@page import="com.zl.util.PageSupport"%>
<%@page import="com.zl.pojo.News"%>
<%@page import="java.util.List"%>
<%@page import="com.zl.service.impl.NewsServiceImpl"%>
<%@page import="com.zl.service.NewsService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- jsp动作标签声明对象，公共对象，注意写完整限定名 (剪贴到common.jsp中作为公共的)-->
<!--用jsp:include 进行包含  -->
<!--动态包含无法使用，页面报错，newsService无法使用,因为使用的是结果需要复制：静态包含 <jsp:include page="../common/common.jsp" /> -->

<%@include file="../common/common.jsp"%>
<!--使用TSTL需要赋值的标签（2）  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>无标题文档</title> <%-- <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/> --%>
	<style type="text/css">
</style>
	<script>
		/*点击增加,实现窗口跳转  */
		function addNews() {
			window.location = "<%=request.getContextPath()%>/jsp/admin/newsDetailCreateSimple.jsp";
		}
		
		//删除功能
		var flag = '${param.flag}';
		if(flag!=null && flag!="" && undefined !=flag){
			if(flag=='success'){
				alert('删除成功');
			}else{
				alert('删除失败');
			}
		}
	</script>
</head>

<body>
	<!--页面顶部-->

	<!--主体-->

	<div class="main-content-right">
		<!--即时新闻-->
		<div class="main-text-box">
			<div class="main-text-box-tbg">
				<div class="main-text-box-bbg">
					<form name="searchForm" id="searchForm"
						action="/news/jsp/admin/newsDetailList.jsp" method="post">
						<div>
							新闻分类： <select name="categoryId">
								<option value="0">全部</option>

								<option value='1'>国内</option>

								<option value='2'>国际</option>

								<option value='3'>娱乐</option>

								<option value='4'>军事</option>

								<option value='5'>财经</option>

								<option value='6'>天气</option>

							</select> 新闻标题 <input type="text" name="title" id="title" value='' />
							<button type="submit" class="page-btn">GO</button>
							<button type="button" onclick="addNews();" class="page-btn">增加</button>
							<input type="hidden" name="pageIndex" value="1" />
							<!--pageIndex通过隐藏域的方式拿到  -->
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
							<%-- 调用java就得用<% %> NewsService newsService = new NewsServiceImpl();--%>
							<%
								/*分页查询并显示*/
								/* int pageIndex = 1; //当前页码(不能写死) */
								String currentPage = request.getParameter("pageIndex");
								if (currentPage == null) {
									//用户首次访问页面
									currentPage = "1";
								}
								int pageIndex = Integer.parseInt(currentPage);
								int totalCount = newsService.getTotalCount();//获取新闻总数量
								int pageSize = 3; //页容量
								//获取总页数
								PageSupport pageSupport = new PageSupport();
								pageSupport.setCurrentPageNo(pageIndex);//设置当前页码
								pageSupport.setPageSize(pageSize);//设置页容量
								pageSupport.setTotalCount(totalCount); //设置总数量
								int totalPage = pageSupport.getTotalPageCount();//总页数
								//控制首页和尾页
								if (pageIndex < 1) {
									pageIndex = 1;
								} else if (pageIndex - totalPage > 0) {
									pageIndex = totalPage;
								}
								
								List<News> list = newsService.getPageNewsList(pageIndex, pageSize);
								//将集合放进作用域中
								request.setAttribute("list", list);
								
								/*int i = 0; //隔行换色 在这里计数 
								for (News news : list) {
									i++; //进来一个对象计数+1*/
							%>
							<!-- 实现跳转所需要的隐藏域:分页的总页数 -->
							<input type="hidden" id="totalPage" value="<%=totalPage%>" />
							
							<c:forEach items="${list }" var="news" varStatus="status">
							<!-- if(i%2==0)进行判断，偶数行换色 -->
							<%-- <tr <%if (i % 2 == 0) {%> class="admin-list-td-h2" <%}%>> --%>
							<tr <c:if test="${status.count%2==0 }">class="admin-list-td-h2"</c:if>>
								<td><a href='newsDetailView.jsp?id=${news.id }'>
								<c:out value="${news.title }" escapeXml="true"></c:out></a>
								</td>
								<td>${news.author }</td>
								<!--用jstl格式化日期  -->
								<td>
								<fmt:formatDate value="${news.createDate }" pattern="yyyy-mm-dd" />
								</td>
								<td><a href='adminNewsCreate.jsp?id=2'>修改</a> <a
									href="javascript:if(confirm('确认是否删除此新闻？')) location='<%=request.getContextPath() %>/servlet/DeleteService?id=${news.id }'">删除</a>
								</td>
							</tr>
							</c:forEach>
							<%
								//}
							%>


						</tbody>
					</table>
					<%//原来的分页条 %>
					<%//在这里需要进行类型转换，传参的时候value需要String totalCount等都是int %>
					<c:import url="rollPage.jsp">
						<c:param name="totalCount" value="<%=Integer.toString(totalCount) %>"></c:param>
						<c:param name="pageIndex" value="<%=Integer.toString(pageIndex) %>"></c:param>
						<c:param name="totalPage" value="<%=Integer.toString(totalPage) %>"></c:param>
					</c:import>
					
				</div>
			</div>
		</div>
	</div>
	<!--底部-->

</body>
</html>