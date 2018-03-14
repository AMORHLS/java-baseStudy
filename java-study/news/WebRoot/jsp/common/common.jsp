
<!-- jsp动作标签声明对象，公共对象，注意写完整限定名 (剪贴到common.jsp中作为公共的)-->
<jsp:useBean id="newsService" class="com.zl.service.impl.NewsServiceImpl"></jsp:useBean>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>