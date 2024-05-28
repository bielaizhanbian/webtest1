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
    <title>修改好友</title>
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
        修改好友
    </div>
    <div id="kv2no1ui">
        <div id="kv2nq1xw">
            <form method="post" qw-c="operationform" action="updatefriendsact.action" enctype="multipart/form-data">
                <input name='id' style='display:none;' value="${friends.id}">
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">用户</label>
                    <div class="controls">
                        <!-- 定义用户下拉框 -->

                        <select id='user' onchange="userchange(this)" name="user" class="form-control"
                                qw-c="formselect"> <!-- 使用c标签的if表达式判断userall是否为空 -->

                            <c:if test="${ !empty userall}">

                                <!-- 使用c标签的forEach表达式循环输出userall -->

                                <c:forEach items="${ userall}" var="item">


                                    <option value="${item.name }">${item.name }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>


                            function userchange(select) {

                                /* 获取传入的select的选中项的项数， 将id为userid的选中项改变为与其一致  */

                                $("#userid").val($("#userid option:eq(" + select.selectedIndex + ")").val());
                            }

                        </script>
                        <script>
                            /* 设置id为user的值为request中的friends.user  */

                            $("#user").val("${friends.user}")</script>

                    </div>
                </div>
                <div style='display:none;' class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">用户id</label>
                    <div style='display:none;' class="controls">
                        <!-- 定义用户id下拉框 -->

                        <select id='userid' onchange="useridchange(this)" name="userid" class="form-control"
                                qw-c="formselect"> <!-- 使用c标签的if表达式判断userall是否为空 -->

                            <c:if test="${ !empty userall}">

                                <!-- 使用c标签的forEach表达式循环输出userall -->

                                <c:forEach items="${ userall}" var="item">


                                    <option value="${item.id }">${item.id }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>


                            function useridchange(select) {

                                /* 获取传入的select的选中项的项数， 将id为useridid的选中项改变为与其一致  */

                                $("#useridid").val($("#useridid option:eq(" + select.selectedIndex + ")").val());
                            }

                        </script>
                        <script>
                            /* 设置id为userid的值为request中的friends.userid  */

                            $("#userid").val("${friends.userid}")</script>

                    </div>
                </div>
                <div class="form-group" qw-c="forminputcomponent">
                    <label qw-c="forminputtext">好友</label>
                    <div class="controls">
                        <!-- 定义好友input输入框，并从request中取值friends.mingzi赋值  -->

                        <input name="mingzi" value="${friends.mingzi}" class="form-control" qw-c="forminput">
                    </div>
                </div>
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">分组</label>
                    <div class="controls">
                        <!-- 定义分组下拉框 -->

                        <select id='category' onchange="categorychange(this)" name="category" class="form-control"
                                qw-c="formselect"> <!-- 使用c标签的if表达式判断categoryall是否为空 -->

                            <c:if test="${ !empty categoryall}">

                                <!-- 使用c标签的forEach表达式循环输出categoryall -->

                                <c:forEach items="${ categoryall}" var="item">


                                    <option value="${item.name }">${item.name }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>


                            function categorychange(select) {

                                /* 获取传入的select的选中项的项数， 将id为categoryid的选中项改变为与其一致  */

                                $("#categoryid").val($("#categoryid option:eq(" + select.selectedIndex + ")").val());
                            }

                        </script>
                        <script>
                            /* 设置id为category的值为request中的friends.category  */

                            $("#category").val("${friends.category}")</script>

                    </div>
                </div>
                <div style='display:none;' class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">分组id</label>
                    <div style='display:none;' class="controls">
                        <!-- 定义分组id下拉框 -->

                        <select id='categoryid' onchange="categoryidchange(this)" name="categoryid" class="form-control"
                                qw-c="formselect"> <!-- 使用c标签的if表达式判断categoryall是否为空 -->

                            <c:if test="${ !empty categoryall}">

                                <!-- 使用c标签的forEach表达式循环输出categoryall -->

                                <c:forEach items="${ categoryall}" var="item">


                                    <option value="${item.id }">${item.id }</option>

                                </c:forEach>

                            </c:if>


                        </select>

                        <script>


                            function categoryidchange(select) {

                                /* 获取传入的select的选中项的项数， 将id为categoryidid的选中项改变为与其一致  */

                                $("#categoryidid").val($("#categoryidid option:eq(" + select.selectedIndex + ")").val());
                            }

                        </script>
                        <script>
                            /* 设置id为categoryid的值为request中的friends.categoryid  */

                            $("#categoryid").val("${friends.categoryid}")</script>

                    </div>
                </div>
                <div class="form-group" qw-c="formselectcomponent">
                    <label qw-c="formselecttext">状态</label>
                    <div class="controls">
                        <!-- 定义状态下拉框 -->

                        <select id='state' onchange="statechange(this)" name="state" class="form-control"
                                qw-c="formselect">
                            <option>待验证</option>
                            <option>同意</option>
                            <option>拒绝</option>
                        </select>
                        <script>
                            /* 将id为state的组件赋值为request中的friends.state字段 */

                            $("#state").val("${friends.state}")</script>

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


