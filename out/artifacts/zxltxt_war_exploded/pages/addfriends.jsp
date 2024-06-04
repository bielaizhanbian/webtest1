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
    <title>添加好友</title>
    <link rel="stylesheet" href="resource/houtai/css/bootstrap.min.css">
    <link rel="stylesheet" href="resource/houtai/css/style.css">
    <link href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
    <script src="resource/houtai/js/jquery.min.js"></script>

</head>
<body>

<div id="kv2jbf74">
   <div id="kv2j7gst">
        <a style="color: white;font-size: 29px;" href="index.action">在线聊天系统</a>
    </div>
</div>
<div id="kv2jg5wg">

    <c:import url="htmenu.jsp"></c:import>

</div>
<div id="kv2jg8jy">
    <div id="kv2jbf75" qw-c="operationname">
        添加好友
    </div>
    <div id="kv2no1ui">
        <div id="kv2nq1xw">
            <form method="post" qw-c="operationform" action="addfriendsact.action" enctype="multipart/form-data">
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">用户</label>
                    <div class="controls">


                        <select id='user' onchange="userchange(this)" name="user" class="form-control"
                                qw-c="formselect"> <!-- 用c标签的if表达式判断userall是否为空  -->

                            <c:if test="${ !empty userall}">

                                <!-- 用c标签的forEach循环展示 request中的userall -->

                                <c:forEach items="${ userall}" var="item">


                                    <option value="${item.name }">${item.name }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>
                            function GetQueryString(name) {
                                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                if (r != null) return (r[2]);
                                return null;
                            }

                            var user = GetQueryString("user");

                            if (user != null) {

                                $("#user").val(user);

                                $("#user option:selected").siblings().remove();
                            }

                            function userchange() {

                                // 获取页面加载时的选中option的索引
                                var selectedIndex = $("#user").get(0).selectedIndex;

                                $("#userid").val($("#userid option:eq(" + selectedIndex + ")").val());

                            }

                            $("#user").val("${friends.user}");                        </script>
                    </div>
                </div> <!-- 设置display为none,设置为不可见 -->

                <div style='display:none;' class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">用户id</label>
                    <!-- 设置display为none,设置为不可见 -->

                    <div style='display:none;' class="controls">


                        <select id='userid' onchange="useridchange(this)" name="userid" class="form-control"
                                qw-c="formselect"> <!-- 用c标签的if表达式判断userall是否为空  -->

                            <c:if test="${ !empty userall}">

                                <!-- 用c标签的forEach循环展示 request中的userall -->

                                <c:forEach items="${ userall}" var="item">


                                    <option value="${item.id }">${item.id }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>
                            function GetQueryString(name) {
                                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                if (r != null) return (r[2]);
                                return null;
                            }

                            var userid = GetQueryString("userid");

                            if (userid != null) {

                                $("#userid").val(userid);

                                $("#userid option:selected").siblings().remove();
                            }

                            $("#userid").val("${friends.userid}");                        </script>
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">好友</label>
                    <div class="controls">
                        <!-- 定义 好友输入框 -->

                        <input name="mingzi" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">分组</label>
                    <div class="controls">


                        <select id='category' onchange="categorychange(this)" name="category" class="form-control"
                                qw-c="formselect"> <!-- 用c标签的if表达式判断categoryall是否为空  -->

                            <c:if test="${ !empty categoryall}">

                                <!-- 用c标签的forEach循环展示 request中的categoryall -->

                                <c:forEach items="${ categoryall}" var="item">


                                    <option value="${item.name }">${item.name }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>
                            function GetQueryString(name) {
                                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                if (r != null) return (r[2]);
                                return null;
                            }

                            var category = GetQueryString("category");

                            if (category != null) {

                                $("#category").val(category);

                                $("#category option:selected").siblings().remove();
                            }

                            function categorychange() {

                                // 获取页面加载时的选中option的索引
                                var selectedIndex = $("#category").get(0).selectedIndex;

                                $("#categoryid").val($("#categoryid option:eq(" + selectedIndex + ")").val());

                            }

                            $("#category").val("${friends.category}");                        </script>
                    </div>
                </div> <!-- 设置display为none,设置为不可见 -->

                <div style='display:none;' class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">分组id</label>
                    <!-- 设置display为none,设置为不可见 -->

                    <div style='display:none;' class="controls">


                        <select id='categoryid' onchange="categoryidchange(this)" name="categoryid" class="form-control"
                                qw-c="formselect"> <!-- 用c标签的if表达式判断categoryall是否为空  -->

                            <c:if test="${ !empty categoryall}">

                                <!-- 用c标签的forEach循环展示 request中的categoryall -->

                                <c:forEach items="${ categoryall}" var="item">


                                    <option value="${item.id }">${item.id }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>
                            function GetQueryString(name) {
                                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                                var r = decodeURIComponent(window.location.search.substr(1)).match(reg);
                                if (r != null) return (r[2]);
                                return null;
                            }

                            var categoryid = GetQueryString("categoryid");

                            if (categoryid != null) {

                                $("#categoryid").val(categoryid);

                                $("#categoryid option:selected").siblings().remove();
                            }

                            $("#categoryid").val("${friends.categoryid}");                        </script>
                    </div>
                </div>
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">状态</label>
                    <div class="controls">


                        <select id='state' onchange="statechange(this)" name="state" class="form-control"
                                qw-c="formselect">
                            <option>待验证</option>
                            <option>同意</option>
                            <option>拒绝</option>
                        </select> <!-- 为下拉框添加自定义数据 -->


                    </div>
                </div>


                <div class="form-group">
                    <button class="btn btn-primary" qw-c="operationbutton" style="background-color: #d219cf; border-color: #d219cf;">添加</button>
                </div>
            </form>
        </div>
    </div>
    <div id="kv2jbf76">
        在线聊天系统
    </div>
</div>
<style>

    #kv2nq1xw {
        padding: 50px 20px;
        background: white;
        min-height: 700px;
        box-shadow: 1px 1px 1px #eeeeee;
    }

    #kv2jbf76 {
        height: 71px;
        box-shadow: 1px 0 5px rgb(0 0 10%);
        background: white;
        color: #67757c;
        font-size: 14px;
        line-height: 71px;
        padding-left: 20px;
    }

    #kv2no1ui {
        padding: 30px;
        width: 100%;
    }

    #kv2jbf75 {
        height: 71px;
        box-shadow: 1px 0 5px rgb(0 0 10%);
        background: white;
        line-height: 71px;
        padding-left: 20px;
        font-size: 21px;
        color: #d219cf;
    }

    .menu-show {
        padding-left: 30px !important;
    }

    .menu-btn {
        position: relative;
    }

    .menu-btn.active {
        border-left: 4px solid #d219cf;
        color: #d219cf !important;
    }

    .menu-btn.active:after {
        transform: rotate(
                135deg) translate(0, -50%);
    }

    .menu-btn:after {
        position: absolute;
        content: '';
        width: 7px;
        height: 7px;
        border-width: 1px 0 0 1px;
        border-style: solid;
        border-color: #607d8b;
        right: 1em;
        top: 33%;
        width: 7px;
        transform: rotate(
                -135deg) translate(0, -50%);
        transition: all .3s ease-out;
    }

    #kv2jg5wg li i {
        width: 27px;
    }

    #kv2jg5wg li a {
        min-height: 44px;
        text-decoration: none;
        color: #607d8b;
        padding: 8px 55px 8px 15px;
        display: block;
        font-size: 14px;
    }

    #kv2jg5wg li {
        min-height: 44px;
    }

    #kv2jg5wg ul {
        list-style: none;
        padding: 0;
    }

    #kv2jg8jy {
        width: 100%;
        position: fixed;
        top: 0;
        bottom: 0;
        height: 100%;
        padding-top: 50px;
        padding-left: 240px;
        z-index: -20;
        background: #eef5f9;
        overflow: auto;
    }

    #kv2jg5wg {
        background: white;
        width: 240px;
        position: fixed;
        top: 0;
        bottom: 0;
        box-shadow: 1px 1px 1px #eee;
        height: 100%;
        padding-top: 66px;
        z-index: -5;
        overflow: auto;
    }

    #kv2jbf74 {
        background: #d219cf;
        min-height: 56px;
        position: fixed;
        width: 100%;
    }

    #kv2j7gst {
        width: 240px;
        float: left;
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        color: white;
        line-height: 56px;
    }
</style>
<style>

    .menu-show {
        display: none;
    }
</style>

<script>
    $(".menu-btn").click(function () {
        $(this).toggleClass("active");
        $(this).next().slideToggle(10);
    });
</script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


