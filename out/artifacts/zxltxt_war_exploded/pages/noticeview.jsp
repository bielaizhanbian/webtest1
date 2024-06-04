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
    <title>公告查看</title>
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
        公告查看
    </div>
    <div id="kv2no1ui">
        <div id="kv2nq1xw">
            <style>
                #searchform .form-control {
                    width: 200px;
                    float: left;
                    margin-left: 10px;
                }

                .btn-primary {
                    background: #d219cf;
                }

                .left {
                    float: left;
                    line-height: 40px;
                    margin-left: 30px;
                }
            </style>
            <form id="searchform" qw-c="searchform" style="text-align: left;width:90%;margin-bottom: 30px;"
                  method="post" action="">
                <div class="row">
                    <span class="left"></span>
                    <input class="form-control" id="search">
                    <button class="btn btn-primary" style="float: left;margin-left: 30px;" type="button"
                            onclick="goPage(1,10)">搜索
                    </button>
                </div>
            </form>
            <table class="table table-hover table-striped table-bordered" qw-c="table">
                <thead>
                <tr>
                    <td>标题

                    </td>
                    <td>封面

                    </td>
                    <td>内容

                    </td>
                    <td>发布时间

                    </td>
                    <td>发布人

                    </td>
                </tr>
                </thead>
                <tbody>


                <c:if test="${ !empty noticeall}">

                    <c:forEach items="${ noticeall}" var="item">


                        <tr>
                            <td> ${item.title }

                            </td>
                            <td> <!-- 将图片从服务器中获取并使用img展示，设置其宽高为100px -->

                                <img src="resource/uploads/${item.pic }" style="height:100px;width:100px;"/>

                            </td>
                            <td> ${item.comtent }

                            </td>
                            <td> ${item.addtime }

                            </td>
                            <td> ${item.publisher }

                            </td>
                        </tr>

                    </c:forEach>

                </c:if>

                </tbody>
            </table>
            <div id="tempStr1" style="text-align: center;margin-top: 30px;"></div>
            <div id="tempStr2" style="text-align: center"></div>
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
    var tablesave = "";
    var search = "";

    function tablechushihua() {
        $("tbody").attr("id", "allitems");
        $("tr").attr("class", "oneitem");
        tablesave = $("#allitems").html();
        tablesave = "<tbody id='allitems'>" + tablesave + "</tbody>";
    }

    tablechushihua();

    function goPage(pno, psize) {
        search = $("#search").val();
        $("#allitems").replaceWith(tablesave);

        console.log(tablesave);

        var num = $("#allitems .oneitem").length;

        var scindex = [];
        for (var i = 1; i < (num + 1); i++) {
            if ($("#allitems .oneitem")[i - 1].innerText.indexOf(search) == -1 && search) {
                scindex.push(i - 1);
            }
        }

        for (var i = scindex.length - 1; i >= 0; i--) {
            $("#allitems .oneitem")[scindex[i]].remove();
        }

        num = $("#allitems .oneitem").length;

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
        endRow = (endRow > num) ? num : endRow;  //40
        //遍历显示数据实现分页
        for (var i = 1; i < (num + 1); i++) {
            if (i >= startRow && i <= endRow) {
                $("#allitems .oneitem")[i - 1].style.display = "table-row";
            } else {
                $("#allitems .oneitem")[i - 1].style.display = "none";
            }
        }
        var tempStr1 = "共" + num + "条记录 分" + totalPage + "页 当前第" + currentPage + "页";

        var tempStr2 = "";


        if (currentPage > 1) {
            //第一页按钮
            tempStr2 += "<button onClick=\"goPage(" + (1) + "," + psize + ")\" class=\"btn btn-primary\"><<</button> ";
            //上一页按钮
            tempStr2 += "<button onClick=\"goPage(" + ((currentPage - 1)) + "," + psize + ")\" class=\"btn btn-primary\"><</button> ";
            //当前页
            tempStr2 += "<button class=\"btn btn-primary\">" + currentPage + "</button> ";
        } else {
            //第一页按钮
            tempStr2 += "<button class=\"btn btn-primary\"><<</button> ";
            //上一页按钮
            tempStr2 += "<button class=\"btn btn-primary\"><</button> ";
            //当前页
            tempStr2 += "<button class=\"btn btn-primary\">" + currentPage + "</button> ";
        }
        if (currentPage < totalPage) {
            //下一页
            tempStr2 += "<button onClick=\"goPage(" + (currentPage + 1) + "," + psize + ")\" class=\"btn btn-primary\">></button> ";
            //最后页
            tempStr2 += "<button onClick=\"goPage(" + (totalPage) + "," + psize + ")\" class=\"btn btn-primary\">>></button> ";
        } else {
            //下一页
            tempStr2 += "<button class=\"btn btn-primary\">></button> ";
            //最后页
            tempStr2 += "<button class=\"btn btn-primary\">>></button> ";
        }
        document.getElementById("tempStr1").innerHTML = tempStr1;
        document.getElementById("tempStr2").innerHTML = tempStr2;
    }

    goPage(1, 10)
</script>
<script>
    if ("${message}") {
        alert("${message}");
    }
</script>
</body>
</html>


