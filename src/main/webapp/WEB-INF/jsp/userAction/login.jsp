<%--
  Created by IntelliJ IDEA.
  User: Ezra
  Date: 2017/8/29
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>登陆</title>
    <META http-equiv=Content-Type CONTENT="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/login.css"/>
    <script type="text/javascript">
        $(function () {
            document.forms[0].uLoginName.focus();
        })
        //解决嵌套问题，使上级窗口刷新
        //不等于自己代表有上级就刷新，等于自己代表没有被嵌套
        if (window.parent != window) {
            window.parent.location.reload(true);
        }
    </script>
</head>

<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 class=PageBody>
<s:form action="user_login" focusElement="loginNameInput">
    <div id="CenterAreaBg">
        <div id="CenterArea">
            <div id="LogoImg"><img border="0" src="${pageContext.request.contextPath}/style/blue/images/logo.png"/>
            </div>
            <div id="LoginInfo">
                <table BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <tr>
                        <td colspan="3"><!-- 显示错误 -->
                            <font color="red"><s:fielderror/></font>
                        </td>
                    </tr>
                    <tr>
                        <td width=45 class="Subject"><img border="0"
                                                          src="${pageContext.request.contextPath}/style/blue/images/login/userId.gif"/>
                        </td>
                        <td>
                            <s:textfield name="uLoginName" size="20" tabindex="1" cssClass="TextField required"
                                         id="loginNameInput"/>
                        </td>
                        <td rowspan="2" style="padding-left:10px;">
                            <input type="image" tabindex="3"
                                   src="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="Subject"><img border="0"
                                                 src="${pageContext.request.contextPath}/style/blue/images/login/password.gif"/>
                        </td>
                        <td><s:password name="uPassword" id="aa" size="20" tabindex="2" showPassword="false"
                                        cssClass="TextField required"/></td>
                    </tr>
                </table>
            </div>
            <div id="CopyRight"><a href="javascript:void(0)">&copy; 2017 版权所有 格创</a></div>
        </div>
    </div>
</s:form>
</body>

</html>

