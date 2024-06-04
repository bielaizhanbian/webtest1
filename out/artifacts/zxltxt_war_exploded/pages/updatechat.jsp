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
    <title>修改聊天</title>
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
        修改聊天
    </div>
    <div id="kv2no1ui">
        <div id="kv2nq1xw">
            <form method="post" qw-c="operationform" action="updatechatact.action" enctype="multipart/form-data">
                <input name='id' style='display:none;' value="${chat.id}">
                <div style='display:none;' class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">发送者id</label>
                    <div style='display:none;' class="controls">
                        <!-- 定义发送者idinput输入框，并从request中取值chat.senderid赋值  -->

                        <input name="senderid" value="${chat.senderid}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">发送者身份</label>
                    <div class="controls">
                        <!-- 定义发送者身份input输入框，并从request中取值chat.senderidentity赋值  -->

                        <input name="senderidentity" value="${chat.senderidentity}" class="form-control"
                               qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">发送者名字</label>
                    <div class="controls">
                        <!-- 定义发送者名字input输入框，并从request中取值chat.sendername赋值  -->

                        <input name="sendername" value="${chat.sendername}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div style='display:none;' class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">接收者id</label>
                    <div style='display:none;' class="controls">
                        <!-- 定义接收者idinput输入框，并从request中取值chat.receiverid赋值  -->

                        <input name="receiverid" value="${chat.receiverid}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">接收者身份</label>
                    <div class="controls">
                        <!-- 定义接收者身份input输入框，并从request中取值chat.receiveridentity赋值  -->

                        <input name="receiveridentity" value="${chat.receiveridentity}" class="form-control"
                               qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">接收者名字</label>
                    <div class="controls">
                        <!-- 定义接收者名字input输入框，并从request中取值chat.receivername赋值  -->

                        <input name="receivername" value="${chat.receivername}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">发送时间</label>
                    <div class="controls">
                        <!-- 定义发送时间input输入框，并从request中取值chat.sendtime赋值  -->

                        <input name="sendtime" value="${chat.sendtime}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">发送内容</label>
                    <div class="controls">
                        <!-- 定义发送内容input输入框，并从request中取值chat.message赋值  -->

                        <input name="message" value="${chat.message}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">已读状态</label>
                    <div class="controls">
                        <!-- 定义已读状态input输入框，并从request中取值chat.isread赋值  -->

                        <input name="isread" value="${chat.isread}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">类型</label>
                    <div class="controls">
                        <!-- 定义类型input输入框，并从request中取值chat.type赋值  -->

                        <input name="type" value="${chat.type}" class="form-control" qw-c="forminput">
                    </div>
                </div>


                <div class="form-group">
                    <button class="btn btn-primary" qw-c="operationbutton" style="background-color: #d219cf; border-color: #d219cf;">修改</button>
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


