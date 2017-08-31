<%--
  Created by IntelliJ IDEA.
  User: Ezra
  Date: 2017/8/20
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>角色管理</title>
    <%@ include file="/WEB-INF/jsp/public/common.jsp"%>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 角色管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        <!-- 表头-->
        <thead>
        <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            <td width="200px">角色名称</td>
            <td width="300px">角色说明</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        <s:iterator value="#roles">
            <tr class="TableDetail1 template">
                <td>${rName}&nbsp;</td>
                <td>${rDescription}&nbsp;</td>
                <td>
                    <s:a action="role_delete?rId=%{rId }" onclick="return delConfirm()">删除</s:a>
                    <s:a action="role_updateUI?rId=%{rId }">修改</s:a>
                    <s:a action="role_toSetPrivilegePage?rId=%{rId }">设置权限</s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="role_addUI">
                <img src="${pageContext.request.contextPath }/style/images/createNew.png"/>
            </s:a>
        </div>
    </div>
</div>
</body>
</html>

