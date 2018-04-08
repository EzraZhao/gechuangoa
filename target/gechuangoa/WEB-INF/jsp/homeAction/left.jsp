<%--
  Created by IntelliJ IDEA.
  User: Ezra
  Date: 2017/8/29
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>导航菜单</title>
    <%@ include file="/WEB-INF/jsp/public/common.jsp"%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/menu.css"/>

    <script type="text/javascript">
        function menuClick(menuDiv) {
            // 先把所有菜单关闭
            $(".MenuLevel2").not($(menuDiv).next()).hide();
            // toggler属性显示隐藏切换
            $(menuDiv).next().toggle();
        }
    </script>

</head>

<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <s:iterator value="#application.topPrivileges">
            <s:if test="#session.currentUser.hasPrivilegeByName(pName)">
                <li class="level1">
                    <div onClick="menuClick(this);" class="level1Style">
                        <img src="${pageContext.request.contextPath }/style/images/MenuIcon/${pIcon}" class="Icon"/> ${pName}
                    </div>
                   <ul style="display: none;" class="MenuLevel2">
                        <s:iterator value="children">
                            <s:if test="#session.currentUser.hasPrivilegeByName(pName)">
                                <li class="level2">
                                    <div class="level2Style"><img src="${pageContext.request.contextPath }/style/images/MenuIcon/menu_arrow_single.gif"/>
                                        <a target="right" href="${pageContext.request.contextPath}/${pUrl}.action"> ${pName}</a></div>
                                </li>
                            </s:if>
                        </s:iterator>
                    </ul>
                </li>
            </s:if>
        </s:iterator>
    </ul>
</div>
</body>
</html>

