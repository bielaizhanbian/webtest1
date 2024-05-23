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
    <title>搜索公告</title>
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
            <li><a href="" qw-c="operationname">搜索公告</a></li>
        </ul>
    </nav>
</div>
<!--面包屑部分结束-->
<!--搜索区部分开始-->
<div id="ljp6p70u">
    <div class="search bar5">
        <form qw-c="searchform" action="searchnotice.action" method="post">
            <input id="search" type="text" placeholder="请输入搜索条件" name="search">
            <button type="submit" id="searchbtn"></button>
        </form>
    </div>
</div>
<!--搜索区部分结束-->
<!--图文展示部分开始-->
<div id="ljs2sik5">
    <div class="content">
        <div class="operationname">
            <span qw-c="operationname">搜索公告</span>
        </div>
    </div>
    <div class="col-md-12" qw-c="imagearea" qw-areaitemnum="6">
        <div class="content" id="allitems">
            <c:if test="${ !empty noticeall}">
                <c:forEach items="${ noticeall}" var="item">
                    <div class="col-md-4 oneitem" qw-c="entity">
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
<!--分页部分开始-->
<div qw-c="paging" style="text-align: center;">
    <ul>
        <li><a href="JavaScript:;;" id="shangyiye">«</a></li>
        <li class="active"><a href="JavaScript:;;" id="dangqianye">1</a></li>
        <li><a href="JavaScript:;;" id="xiayiye">»</a></li>
    </ul>
</div>
<!--分页部分结束-->
<!--底部版权部分开始-->
<div id="ll4qp5gh">
    <div class="sub-footer">
        <p>Copyright © 2024 </p>
    </div>
</div>
<!--底部版权部分结束-->
<script src="resource/qianduan/js/js.js"></script>
<script>
    function goPage(pno, psize) {
        var itable = document.getElementById("allitems");
        console.log(itable);
        var num = $("#allitems .oneitem").length;//表格所有行数(所有记录数)
        console.log(num);
        var totalPage = 0;//总页数
        var pageSize = psize;//每页显示行数
        //总共分几页
        if (num / pageSize > parseInt(num / pageSize)) {
            totalPage = parseInt(num / pageSize) + 1;
        } else {
            totalPage = parseInt(num / pageSize);
        }
        var currentPage = pno;//当前页数
        var startRow = (currentPage - 1) * pageSize + 1;//开始显示的行 31
        var endRow = currentPage * pageSize;//结束显示的行  40
        endRow = (endRow > num) ? num : endRow; //40
        console.log(endRow);
        //遍历显示数据实现分页
        for (var i = 1; i < (num + 1); i++) {
            if (i >= startRow && i <= endRow) {
                console.log($("#allitems .oneitem")[i - 1]);
                $("#allitems .oneitem")[i - 1].style.display = "block";
            } else {
                $("#allitems .oneitem")[i - 1].style.display = "none";
            }
        }
        var tempStr = "共 " + num + " 条记录 分 " + totalPage
            + " 页 当前第 <span style=\"color:red;font-weight:bold;\">"
            + currentPage + "</span> 页<br/>";
        if (currentPage > 1) {
            $("#shangyiye").off("click");
            $("#shangyiye").click(function () {
                goPage(currentPage - 1, psize)
            });
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage-1)+","+psize+")\"><上一页</a>"
        } else {
            $("#shangyiye").off("click");
            //tempStr += "<a href='#'>首页</a>";
            //tempStr += "<a href='#'><上一页</a>";
        }
        if (currentPage < totalPage) {
            $("#xiayiye").off("click");
            $("#xiayiye").click(function () {
                goPage(currentPage + 1, psize)
            });
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页></a>";
            //tempStr += "<a href=\"#\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
        } else {
            $("#xiayiye").off("click");
            //tempStr += "<a href='#'>下一页></a>";
            //tempStr += "<a href='#'>尾页</a>";
        }
        try {
            document.getElementById("barcon").innerHTML = tempStr;
        } catch (error) {

        }
        $("#dangqianye").html(currentPage);
    }

    goPage(1, 6);

    if ("${message}") {
        alert("${message}");
    }

</script>
</body>
</html>


