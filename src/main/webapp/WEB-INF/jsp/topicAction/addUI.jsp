<%--
  Created by IntelliJ IDEA.
  User: Ezra
  Date: 2017/9/2
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表新主题</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/forum.css"/>
    <%@ include file="/WEB-INF/jsp/public/common.jsp" %>
    <script src="${pageContext.request.contextPath }/fckeditor/fckeditor.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function () {
            var fck = new FCKeditor("content");
            fck.Width = "99%";
            fck.Height = "100%";
            fck.ToolbarSet = "bbs";
            fck.BasePath = "${pageContext.request.contextPath }/fckeditor/";
            //fck.Config['SkinPath'] = "${pageContext.request.contextPath }/scriipt/fckeditoreditor/skins/office2003/";
            //fck.Config['SkinPath'] = "http://bbs.itcast.cn:80/widgets/fckeditor/editor/skins/office2003/";
            fck.ReplaceTextarea();
        });
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 发表新主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="topic_add" style="margin: 0; padding: 0;">
        <s:hidden name="fId"/>
        <div id="PageHead"></div>
        <center>
            <div class="ItemBlock_Title1">
                <div width=85% style="float:left">
                    <font class="MenuPoint"> &gt; </font>
                    <s:a action="forum_list">论坛</s:a>
                    <font class="MenuPoint"> &gt; </font>
                    <s:a action="forum_show?fId=%{#forum.fId}">${forum.fName}</s:a>
                    <font class="MenuPoint"> &gt;&gt; </font>
                    发表新主题
                </div>
            </div>
            <div class="ItemBlockBorder">
                <table border="0" cellspacing="1" cellpadding="1" width="100%" id="InputArea">
                    <tr>
                        <td class="InputAreaBg" height="30">
                            <div class="InputTitle">标题</div>
                        </td>
                        <td class="InputAreaBg">
                            <div class="InputContent">
                                <s:textfield name="title" cssClass="InputStyle" style="width:100%"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="InputAreaBg" height="30">
                            <div class="InputTitle">表情</div>
                        </td>
                        <td class="InputAreaBg">
                            <div class="InputContent">
                                <!-- 显示表情符号 -->
                                <!--现在在设计单选框(radio)和复选框(checkbox)时都会给选择文字加上label增大选择范围，以提高用户体验。
                                    但在给单独的图片加label时无法成功。
                                    解决方法是：给图片img标签加上disabled即可。-->
                                <table cellpadding="0" border="0" cellspacing="0">
                                    <tr>
                                        <s:iterator begin="1" end="14" var="num">
                                            <td width="50" style="border-bottom:0 solid #ffffff">
                                                <input type="radio" name="faceIcon" value="${num}" id="r_${num}"/>
                                                <label for="r_${num}">
                                                    <img width="19" height="19" src="${pageContext.request.contextPath }/style/images/face/face${num}.gif"
                                                         align="absmiddle" disabled="true"/>
                                                </label>
                                            </td>
                                        </s:iterator>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr height="240">
                        <td class="InputAreaBg">
                            <div class="InputTitle">内容</div>
                        </td>
                        <td class="InputAreaBg">
                            <div class="InputContent">
                                <s:textarea name="content" cssStyle="width:650px;height:200px"></s:textarea>
                            </div>
                        </td>
                    </tr>
                    <tr height="30">
                        <td class="InputAreaBg" colspan="2" align="center">
                            <input type="image" src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG"
                                   style="margin-right:15px;"/>
                            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath }/style/blue/images/button/goBack.png"/></a>
                        </td>
                    </tr>
                </table>
            </div>
        </center>
    </s:form>
</div>

<div class="Description">
    说明：<br/>

</div>

</body>
</html>
