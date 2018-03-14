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
			window.location = "newsDetailCreateSimple.jsp";
		}
		//表单提交 ，同时偷偷传递页码
		function page_nav(frm, num) {
			//通过frm表单找到字段pageIndex 的隐藏域赋值为num(页码)
			frm.pageIndex.value = num;
			//表单提交
			frm.submit();
		}
		//实现跳转功能：跳转至！跳转前需要进行有效验证，如果数字正确，才能pag_nav()
		function jump_to(frm, pageno) {
			//var regexp=/^\d+$/;正则表达式
			var regexp = /^[1-9]\d*$/;//只能是数字
			//拿到隐藏域中提交的总页数（document.getElementById("totalPage").value找到对应的值）
			var totalPage = document.getElementById("totalPage").value;
			if (!regexp.test(pageno)) { //如果test(匹配)不上
				alert("请输入 正确的数字！");
				return false;
			} else if ((pageno - totalPage) > 0) {
				alert("总页码一共" + totalPage + "页，请输入正确的页码！");
				return false;
			} else {
				page_nav(frm, pageno);
			}
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
								int i = 0; //隔行换色 在这里计数 
								for (News news : list) {
									i++; //进来一个对象计数+1
							%>
							<!-- 实现跳转所需要的隐藏域 -->
							<input type="hidden" id="totalPage" value="<%=totalPage%>" />
							<!-- if(i%2==0)进行判断，偶数行换色 -->
							<tr <%if (i % 2 == 0) {%> class="admin-list-td-h2" <%}%>>
								<td><a href='newsDetailView.jsp?id=<%=news.getId()%>'><%=news.getTitle()%></a>
								</td>
								<td><%=news.getAuthor()%></td>
								<td><%=news.getCreateDate()%></td>
								<td><a href='adminNewsCreate.jsp?id=2'>修改</a> <a
									href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=<%=news.getId()%>'">删除</a>
								</td>
							</tr>
							<%
								}
							%>


						</tbody>
					</table>
					<div class="page-bar">
						<ul class="page-num-ul clearfix">
							<li>共<%=totalCount%>条记录&nbsp;&nbsp; <%=pageIndex%>/<%=totalPage%>页</li>
							<%
								if (pageIndex > 1) {
									//forms[0] dom内的第一个表单，下标从0开始
							%>
							<a href="javaScript:page_nav(document.forms[0],1)">首页</a>
							<a href="javaScript:page_nav(document.forms[0],<%=pageIndex - 1%>)">上一页</a>

							<%-- <a href="newsDetailList.jsp?pageIndex=1">首页</a>
							<a href="newsDetailList.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>&nbsp;&nbsp; --%>
							<%
								}
								if (pageIndex - totalPage < 0) {
							%>
							<a href="javaScript:page_nav(document.forms[0],<%=pageIndex + 1%>)">下一页</a>
							<a href="javaScript:page_nav(document.forms[0],<%=totalPage%>)">最后一页</a>

							<%-- <a href="newsDetailList.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
							<a href="newsDetailList.jsp?pageIndex=<%=totalPage%>">最后一页</a>&nbsp;&nbsp; --%>
							<%
								}
							%>
						</ul>
						<span class="page-go-form"><label>跳转至</label> <input
							type="text" name="inputPage" id="inputPage" class="page-key" />页
							<button type="button" class="page-btn"
								onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--底部-->

</body>
</html>