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
    <title>公告详情</title>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="resource/qianduan/css/config.css" rel="stylesheet">
    <script src="resource/qianduan/js/jquery.min.js"></script>
    <script src="resource/qianduan/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="resource/qianduan/css/css.css" rel="stylesheet">
</head>
<body>
<!--导航栏部分开始-->
<div id="lk249p9a">
    <nav id="navbar" class="">
        <div class="nav-wrapper">
            <c:import url="qtmenu.jsp"></c:import>
        </div>
    </nav>
</div>
<!--导航栏部分结束-->
<!--面包屑部分开始-->
<div id="ljp9xmrg">
    <nav aria-label="Breadcrumb" class="breadcrumb">
        <ul>
            <li><a href="IndexServlet?index.action">首页</a></li>
            <li><a href="" qw-c="operationname">公告详情</a></li>
        </ul>
    </nav>
</div>
<!--面包屑部分结束-->
<!--图文详情部分开始-->
<div id="ln9wdzz5">
    <header class="header">
        <div class="header-content">
            <div class="header-logo">
                <h1 class="logo" qw-c="operationname">公告详情</h1>
            </div>
        </div>
    </header>
    <div class="content-container" qw-c="detailsarea">
        <div class="left-container">
            <div class="product-image-container">


                <!--  使用img展示公告的封面  -->
                <img class="product-image-featured" id="featured" qw-c="entityimage"
                     src="resource/uploads/${notice.pic}" alt="Canon Image">


            </div>
        </div>
        <div class="right-container" qw-c="entitycontent" style="background-color: ">
            <div>
                <h1 class="title" qw-c="entitytitle">${notice.title}</h1>
            </div>

            <br>
            <h3>内容</h3>
            <div v-html="notice.comtent">${notice.comtent}</div>
            <div qw-c="entityattribute">
                <div class="subtitle-container">
                    <span qw-c="entitykey">发布时间</span>
                    <span qw-c="entityvalue">${notice.addtime}</span>
                </div>
            </div>
            <div qw-c="entityattribute">
                <div class="subtitle-container">
                    <span qw-c="entitykey">发布人</span>
                    <span qw-c="entityvalue">${notice.publisher}</span>
                </div>
            </div>

        </div>
    </div>
</div>
<!--图文详情部分结束-->
<!--评论区部分开始-->


<!--评论区部分结束-->
<!--底部版权部分开始-->
<div id="ll4qp5gh">
    <div class="sub-footer">
        <p>Copyright © 2024 </p>
    </div>
</div>
<!--底部版权部分结束-->
<script src="resource/qianduan/js/js.js"></script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


