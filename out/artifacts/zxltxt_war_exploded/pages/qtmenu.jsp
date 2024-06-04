<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>菜单栏</title>
</head>
<body style="background: url(resource/houtai/img/6.jpg);background-size: cover">
<ul id="menu" qw-c="menu">
    <li style="font-size: 32px;margin-right: 500px;">在线聊天系统</li>
    <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="index.action">首页</a></li>
    <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="chat.action">聊天</a></li>
    <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="searchnotice.action">公告</a></li>
    <c:if test="${sessionScope.identity == '管理员'}">
        <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="adminindex.action">个人中心</a></li>
    </c:if>
    <c:if test="${sessionScope.identity == '用户'}">
        <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="userindex.action">个人中心</a></li>
    </c:if>
    <c:if test="${sessionScope.identity == '' || sessionScope.identity == null}">
        <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="login.action">登录</a></li>
        <li qw-c="menu-item"><a qw-c="menu-itema menu-itemtext" href="regist.action">注册</a></li>
    </c:if>
</ul>
</body>
</html>

