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
    <title>首页</title>
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
<!--轮播图部分开始-->
<div id="ljnz7097">
    <div class="center">
        <div class="slideshow" id="ljnz7097-slideshow">
            <img class="show" src="resource/qianduan/img/11.jpg">
            <img class="show" src="resource/qianduan/img/22.jpg">
            <img src="resource/qianduan/img/33.jpg">
        </div>
        <ul id="ljnz7097-slideshowPoints" class="slideshowPoints">
            <li class="active"></li>
            <li></li>
            <li></li>
        </ul>
        <div class="slideshowPage" id="ljnz7097-slideshowPage">
        </div>
    </div>
</div>
<!--轮播图部分结束-->
<!--图文展示部分开始-->

<div id="ljs2sik5" qw-c="imagearea" qw-areaitemnum="6">
    <div class="title">
        <div class="title7" qw-c="areatitle">
            公告最新推荐
        </div>
    </div>
    <div class="col-md-12">
        <div class="content">
            <c:if test="${ !empty noticezuixin6}">
                <c:forEach items="${ noticezuixin6}" var="item">
                    <div class="col-md-4" qw-c="entity">
                        <div class="main_item">
                            <div class="hover_cont">
                                <span> <a href="noticedetails.action?id=${item.id}"><img class="item_ico"
                                                                                         qw-c="entityimage"
                                                                                         src="resource/uploads/${item.pic}"></a> </span>
                                <h3 class="product_name"><a href="noticedetails.action?id=${item.id}"
                                                            qw-c="entitytitle">${item.title}</a></h3>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>


<!--图文展示部分结束-->
<!--文字展示部分开始-->


<!--文字展示部分结束-->
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


