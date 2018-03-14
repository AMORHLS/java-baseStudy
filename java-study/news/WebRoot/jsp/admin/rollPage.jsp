<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'rollPage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
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
</script>

</head>

<body>
	<%
		//分页条的页面，所有使用分页页面的复用表
	%>
	<div class="page-bar">
		<ul class="page-num-ul clearfix">
			<li>共${param.totalCount }条记录&nbsp;&nbsp; ${param.pageIndex
				}/${param.totalPage }页</li>
			<%
				//if (pageIndex > 1) {
				//forms[0] dom内的第一个表单，下标从0开始
			%>
			<c:if test="${param.pageIndex>1 }">
				<a href="javaScript:page_nav(document.forms[0],1)">首页</a>
				<a href="javaScript:page_nav(document.forms[0],${param.pageIndex-1})">上一页</a>
			</c:if>
			<%-- <a href="newsDetailList.jsp?pageIndex=1">首页</a>
							<a href="newsDetailList.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>&nbsp;&nbsp; --%>
			<%
				/*}
				if (pageIndex - totalPage < 0) {*/
			%>
			<c:if test="${param.pageIndex-param.totalPage<0 }">
				<a href="javaScript:page_nav(document.forms[0],${param.pageIndex+1})">下一页</a>
				<a href="javaScript:page_nav(document.forms[0],${param.totalPage })">最后一页</a>
			</c:if>
			<%-- <a href="newsDetailList.jsp?pageIndex=<%=pageIndex + 1%>">下一页</a>
							<a href="newsDetailList.jsp?pageIndex=<%=totalPage%>">最后一页</a>&nbsp;&nbsp; --%>
			<%
				//	}
			%>
		</ul>
		<span class="page-go-form"><label>跳转至</label> <input
			type="text" name="inputPage" id="inputPage" class="page-key" />页
			<button type="button" class="page-btn"
				onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
	</div>
</body>
</html>
