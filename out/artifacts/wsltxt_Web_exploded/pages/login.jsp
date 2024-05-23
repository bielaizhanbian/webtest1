<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="resource/houtai/css/bootstrap.min.css">
</head>
<body style="background: url(resource/houtai/img/4.jpg);background-size: cover">
<div id="kv2jbf78">
    <form action="loginact.action" qw-c="form" method="post">
        <span id="kv2jbf79" qw-c="operationname">登录</span>
        <div class="form-group">
            <input class="form-control" placeholder="请输入用户名" qw-c="username" name="username" type="text">
        </div>

        <div class="form-group" qw-c="passwordcomponent">
            <input class="form-control" placeholder="请输入密码" qw-c="password" name="password" type="password">
        </div>


        <div class="form-group">
            <select class="form-control" qw-c="identity" name="identity">
                <option>管理员</option>
                <option>用户</option>
            </select>
        </div>
        <div class="form-group">
            <button class="btn btn-primary" qw-c="operationbutton">登录</button>
        </div>
    </form>
    <div qw-c="infotext">
        没有账号，点击<a href="regist.action">注册</a>
    </div>
</div>
<style>

    .btn-primary {
        background: #1976d2;
        width: 100%;
        height: 50px;
    }

    .form-group {
        margin-top: 10px;
    }

    #kv2jbf79 {
        font-size: 22px;
    }

    #kv2jbf78 {
        width: 400px;
        margin: auto;
        margin-top: 150px;
        min-height: 100px;
        background: white;
        border-radius: 5px;
        padding: 30px;
    }
</style>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


