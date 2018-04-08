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
    <title>查看主题：${topic.title}</title>
    <%@ include file="/WEB-INF/jsp/public/common.jsp" %>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/forum.css"/>
    <script language="javascript" src="${pageContext.request.contextPath }/style/script/fckeditor/fckeditor.js"
            charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            var fck = new FCKeditor("content");
            fck.Width = "90%";
            fck.ToolbarSet = "bbs";
            fck.BasePath = "${pageContext.request.contextPath }/style/script/fckeditor/";
            fck.ReplaceTextarea();
            s
        });

        function gotoPage(pageNum) {
            window.location.href = "topic_show?id=${id}&pageNum=" + pageNum;
        }
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 查看主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--内容显示-->
<div id="MainArea">
    <div id="PageHead"></div>
    <center>
        <div class="ItemBlock_Title1" style="width: 98%">
            <font class="MenuPoint"> &gt; </font>
            <s:a action="forum_list">论坛</s:a>
            <font class="MenuPoint"> &gt; </font>
            <s:a action="forum_show?fId=%{#topic.forum.fId}">${topic.forum.fName}</s:a>
            <font class="MenuPoint"> &gt;&gt; </font>帖子阅读
            <span style="margin-left:30px;">
                <s:a action="topic_addUI?fId=%{#topic.forum.fId}">
                    <img align="absmiddle"
                         src="${pageContext.request.contextPath }/style/blue/images/button/publishNewTopic.png"/></s:a>
			</span>
        </div>

        <div class="ForumPageTableBorder dataContainer" datakey="replyList">

            <!--显示主题标题等-->
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr valign="bottom">
                    <td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
                    <td class="ForumPageTableTitle"><b>本帖主题：${topic.title}</b></td>
                    <td class="ForumPageTableTitle" align="right" style="padding-right:12px;">
                        <s:a cssClass="detail" action="reply_addUI?tId=%{#topic.id}">
                            <img border="0"
                                 src="${pageContext.request.contextPath }/style/images/reply.gif"/>回复</s:a>
                        <a href="moveUI.html"><img border="0"
                                                   src="${pageContext.request.contextPath }/style/images/edit.gif"/>移动到其他版块</a>
                        <a href="#" onClick="return confirm('要把本主题设为精华吗？')">
                            <img border="0" src="${pageContext.request.contextPath }/style/images/forum_hot.gif"/>精华</a>
                        <a href="#" onClick="return confirm('要把本主题设为置顶吗？')">
                            <img border="0" src="${pageContext.request.contextPath }/style/images/forum_top.gif"/>置顶</a>
                        <a href="#" onClick="return confirm('要把本主题设为普通吗？')">
                            <img border="0"
                                 src="${pageContext.request.contextPath }/style/images/forum_comm.gif"/>普通</a>
                    </td>
                    <td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
                </tr>
                <tr height="1" class="ForumPageTableTitleLine">
                    <td colspan="4"></td>
                </tr>
            </table>

            <!-- ~~~~~~~~~~~~~~~ 显示主帖 ~~~~~~~~~~~~~~~ -->
            <div class="ListArea">
                <table border="0" cellpadding="0" cellspacing="1" width="100%">
                    <tr>
                        <td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
                            <!--作者头像-->
                            <div class="AuthorPhoto">
                                <img border="0" width="110" height="110"
                                     src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif"
                                     onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';"/>
                            </div>
                            <!--作者名称-->
                            <div class="AuthorName">${topic.author.uName}</div>
                        </td>
                        <td align="center">
                            <ul class="TopicFunc">
                                <!--操作列表-->
                                <li class="TopicFuncLi">
                                    <a class="detail"
                                       href="${pageContext.request.contextPath }/style/BBS_Topic/saveUI.html"><img
                                            border="0"
                                            src="${pageContext.request.contextPath }/style/images/edit.gif"/>编辑</a>
                                    <a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')"><img border="0"
                                                                                                          src="${pageContext.request.contextPath }/style/images/delete.gif"/>删除</a>
                                </li>
                                <!-- 文章表情与标题 -->
                                <li class="TopicSubject">
                                    <img width="19" height="19"
                                         src="${pageContext.request.contextPath }/style/images/face/face${topic.faceIcon}.gif"/>
                                    ${topic.title}
                                </li>
                            </ul>
                        </td>
                    </tr>
                    <tr><!-- 文章内容 -->
                        <td valign="top" align="center">
                            <div class="Content">${topic.content}</div>
                        </td>
                    </tr>
                    <tr><!--显示楼层等信息-->
                        <td class="Footer" height="28" align="center" valign="bottom">
                            <ul style="margin: 0px; width: 98%;">
                                <li style="float: left; line-height:18px;">
                                    <font color=#C30000>[楼主]</font>
                                    <s:date name="%{#topic.postTime}" format="yyyy-MM-dd HH:mm:ss"/>
                                </li>
                                <li style="float: right;">
                                    <a href="javascript:scroll(0,0)">
                                        <img border="0"
                                             src="${pageContext.request.contextPath }/style/images/top.gif"/></a>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </div>
            <!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


            <!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
            <s:iterator value="recordList" status="status">
                <div class="ListArea template">
                    <table border="0" cellpadding="0" cellspacing="1" width="100%">
                        <tr>
                            <td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
                                <!--作者头像-->
                                <div class="AuthorPhoto">
                                    <img border="0" width="110" height="110"
                                         src="${pageContext.request.contextPath }/style/images/defaultAvatar.gif"
                                         onerror="this.onerror=null; this.src='${pageContext.request.contextPath }/style/images/defaultAvatar.gif';"/>
                                </div>
                                <!--作者名称-->
                                <div class="AuthorName">${author.uName}</div>
                            </td>
                            <td align="center">
                                <ul class="TopicFunc">
                                    <!--操作列表-->
                                    <li class="TopicFuncLi">
                                        <a class="detail"
                                           href="${pageContext.request.contextPath }/style/BBS_Topic/saveUI.html">
                                            <img border="0"
                                                 src="${pageContext.request.contextPath }/style/images/edit.gif"/>编辑</a>
                                        <a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')">
                                            <img border="0"
                                                 src="${pageContext.request.contextPath }/style/images/delete.gif"/>删除</a>
                                    </li>
                                    <!-- 文章表情与标题 -->
                                    <li class="TopicSubject">
                                        <img width="19" height="19"
                                             src="${pageContext.request.contextPath }/style/images/face/${faceIcon}"/>
                                            ${title}
                                    </li>
                                </ul>
                            </td>
                        </tr>
                        <tr><!-- 文章内容 -->
                            <td valign="top" align="center">
                                <div class="Content">${content}</div>
                            </td>
                        </tr>
                        <tr><!--显示楼层等信息-->
                            <td class="Footer" height="28" align="center" valign="bottom">
                                <ul style="margin: 0px; width: 98%;">
                                    <li style="float: left; line-height:18px;"><font
                                            color=#C30000>[${status.count}楼]</font>
                                        <s:date name="%{postTime}" format="yyyy-MM-dd HH:mm:ss"/>
                                    </li>
                                    <li style="float: right;"><a href="javascript:scroll(0,0)">
                                        <img border="0"
                                             src="${pageContext.request.contextPath }/style/images/top.gif"/></a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </div>
            </s:iterator>
            <!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
        </div>

        <!--分页信息-->
        <div id=PageSelectorBar>
            <div id=PageSelectorMemo>
                页次：${currentPage}/${pageCount}页 &nbsp;
                每页显示：${pageSize}条 &nbsp;
                总记录数：${recordCount}条
            </div>
            <div id=PageSelectorSelectorArea>
                <!--
                <IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage2.png"/>
                -->
                <a href="javascript:void(0)" title="首页" style="cursor: hand;">
                    <img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/firstPage.png"/></a>

                <s:iterator begin="${beginPageIndex}" end="${endPageIndex}" var="num">
                    <s:if test="currentPage == #num">
                        <span class="PageSelectorNum PageSelectorSelected">${num}</span>
                    </s:if>
                    <s:else>
                        <span class="PageSelectorNum" style="cursor: hand;"
                              onClick="gotoPageNum(${num});">${num}</span>
                    </s:else>
                </s:iterator>

                <!--
                <IMG SRC="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage2.png"/>
                -->
                <a href="#" title="尾页" style="cursor: hand;">
                    <img src="${pageContext.request.contextPath }/style/blue/images/pageSelector/lastPage.png"/></a>

                转到：
                <select onchange="gotoPage(this.value)">
                    <s:iterator begin="1" end="%{pageCount}" var="num">
                        <option value="${num}">${num}</option>
                    </s:iterator>
                </select>
            </div>
        </div>

        <div class="ForumPageTableBorder" style="margin-top: 25px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr valign="bottom">
                    <td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
                    <td class="ForumPageTableTitle"><b>快速回复</b></td>
                    <td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
                </tr>
                <tr height="1" class="ForumPageTableTitleLine">
                    <td colspan="3"></td>
                </tr>
            </table>
        </div>
    </center>

    <!--快速回复-->
    <div class="QuictReply">
        <s:form action="reply_add">
            <div style="padding-left: 3px;">
                <table border="0" cellspacing="1" width="98%" cellpadding="5" class="TableStyle">
                    <tr height="30" class="Tint">
                        <td width="50px" class="Deep"><b>标题</b></td>
                        <td class="no_color_bg">
                            <s:textfield name="title" cssClass="InputStyle" value="回复：${topic.title}"
                                         cssStyle="width:90%"/>
                        </td>
                    </tr>
                    <tr height="30" class="Tint">
                        <td width="50px" class="Deep"><b>表情</b></td>
                        <td class="no_color_bg">
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
                                                <label for="r_${num}"><img width="19" height="19"
                                                                           src="${pageContext.request.contextPath }/style/images/face/face${num}.gif"
                                                                           align="absmiddle"
                                                                           disabled="true"/></label>
                                            </td>
                                        </s:iterator>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr class="Tint" height="200">
                        <td valign="top" rowspan="2" class="Deep"><b>内容</b></td>
                        <td valign="top" class="no_color_bg">
                            <s:textarea name="content" cssStyle="width: 95%; height: 300px"></s:textarea>
                        </td>
                    </tr>
                    <tr height="30" class="Tint">
                        <td class="no_color_bg" colspan="2" align="center">
                            <input type="image"
                                   src="${pageContext.request.contextPath }/style/blue/images/button/submit.PNG"
                                   style="margin-right:15px;"/>
                        </td>
                    </tr>
                </table>
            </div>
        </s:form>
    </div>
</div>

<div class="Description">
    说明：<br/>
    1，主帖只在第一页显示。<br/>
    2，只有是管理员才可以进行“移动”、“编辑”、“删除”、“精华”、“置顶”的操作。<br/>
    3，删除主帖，就会删除所有的跟帖（回复）。<br/>
</div>

</body>
</html>

