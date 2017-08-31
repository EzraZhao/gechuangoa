<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>GeChuang OA</title>
	<%@ include file="/WEB-INF/jsp/public/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

	<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="home_top">
		<frameset cols="180,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="home_left">
			<frame noresize name="right" scrolling="yes" src="home_right">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="home_bottom">
	</frameset>

	<noframes><body>
</body>
</noframes></html>



