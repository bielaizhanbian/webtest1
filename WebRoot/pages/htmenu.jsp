<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>菜单栏</title>
</head>
<body>
<c:if test="${sessionScope.identity == '管理员' }">
    <body>
    <ul qw-c="menu">

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">个人中心</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">


                <li qw-c="menuitemselectitem"><a href="adminindex.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">个人中心</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">用户管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="adduser.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加用户</a></li>
                <li qw-c="menuitemselectitem"><a href="usermanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">用户管理</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">好友管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addfriends.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加好友</a></li>
                <li qw-c="menuitemselectitem"><a href="friendsmanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">好友管理</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">分组管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addcategory.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加分组</a></li>
                <li qw-c="menuitemselectitem"><a href="categorymanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">分组管理</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">公告管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addnotice.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加公告</a></li>
                <li qw-c="menuitemselectitem"><a href="noticemanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">公告管理</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">聊天管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addchat.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加聊天</a></li>
                <li qw-c="menuitemselectitem"><a href="chatmanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">聊天管理</a></li>

            </ul>
        </li>


        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">退出系统</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="exitsystem.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li>
            </ul>
        </li>
    </ul>
    </body>
</c:if><c:if test="${sessionScope.identity == '用户' }">
    <body>
    <ul qw-c="menu">

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">个人中心</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">


                <li qw-c="menuitemselectitem"><a href="userindex.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">个人中心</a></li>

            </ul>
        </li>



        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">我的好友</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addfriends.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加好友</a></li>
                <li qw-c="menuitemselectitem"><a href="friendsmanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">好友管理</a></li>

            </ul>
        </li>

        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">分组管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addcategory.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加分组</a></li>
                <li qw-c="menuitemselectitem"><a href="categorymanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">分组管理</a></li>

            </ul>
        </li>


        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">聊天管理</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">

                <li qw-c="menuitemselectitem"><a href="addchat.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">添加聊天</a></li>
                <li qw-c="menuitemselectitem"><a href="chatmanage.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">聊天管理</a></li>
                <li qw-c="menuitemselectitem"><a href="chat.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">聊天管理</a></li>

            </ul>
        </li>


        <li qw-c="menuitem"><a href="#" class="menu-btn" qw-c="menuitema"> <i class="fa fa-send"></i> <span
                qw-c="menuitematext">退出系统</span> </a>
            <ul class="menu-show" qw-c="menuitemselect">
                <li qw-c="menuitemselectitem"><a href="exitsystem.action"
                                                 qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li>
            </ul>
        </li>
    </ul>
    </body>
</c:if>
</body>
</html>


