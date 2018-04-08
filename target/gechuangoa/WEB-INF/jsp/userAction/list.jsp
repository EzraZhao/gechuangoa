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
    <title>用户管理</title>
    <%@ include file="/WEB-INF/jsp/public/common.jsp"%>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">

        <!-- 表头-->
        <thead>
        <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            <td width="100px">登陆名称</td>
            <td width="100px">用户名称</td>
            <td width="50px">性别</td>
            <td width="120px">手机</td>
            <td width="150px">邮箱</td>
            <td width="200px">描述</td>
            <td width="160px">角色</td>
            <td width="100px">部门</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer">
        <s:iterator value="users">
            <tr class="TableDetail1 template">
                <td>${uLoginName}&nbsp;</td>
                <td>${uName}&nbsp;</td>
                <td>${uSex ? '男' : '女'}&nbsp;</td>
                <td>${uPhone}&nbsp;</td>
                <td>${uEmail}&nbsp;</td>
                <td>${uDescription}&nbsp;</td>
                <td>
                    <s:iterator value="roles">
                        ${rName }&nbsp;
                    </s:iterator>
                </td>
                <td>${uDepartment.dName }&nbsp;</td>

                <td><s:a action="user_delete?uId=%{uId }" onclick="return delConfirm()">删除</s:a>
                    <s:a action="user_updateUI?uId=%{uId }">修改</s:a>
                    <s:a action="user_initPassword?uId=%{uId }" onclick="return window.confirm('您确定要初始化密码为1234吗?')">初始化密码</s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="user_addUI"><img
                    src="${pageContext.request.contextPath }/style/images/createNew.png"/></s:a>
        </div>
    </div>
</div>
</body>
</html>

