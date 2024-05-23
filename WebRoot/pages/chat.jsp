<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
<head></head>
<body style="background: url(resource/houtai/img/3.jpg);background-size: cover">

<%--<body>--%>

<meta charset="UTF-8">
<title>聊天</title>
<!--<link href="css/bootstrap.min.css" rel="stylesheet">-->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/qianduan/css/config.css" rel="stylesheet">
<script src="resource/qianduan/js/jquery.min.js"></script>
<script src="resource/qianduan/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<link href="resource/qianduan/css/css.css" rel="stylesheet">
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
            <li><a href="" qw-c="operationname">聊天</a></li>
        </ul>
    </nav>
</div>
<!--面包屑部分结束-->
<!--图文详情部分开始-->
<div id="ln9wdzz5">
    <header class="header">
        <div class="header-content">
            <div class="header-logo">
                <h1 class="logo" qw-c="operationname">聊天</h1>
            </div>
        </div>
    </header>
    <div class="content-container" qw-c="detailsarea">
        <div class="row mychatbox">
            <div class="col-3 col-lg-3 my-main-card my-scroll">
                <div class="my-main-card-head">
                    聊天列表
                </div>
                <div id="contactList">
                </div>
            </div>
            <div class="col-9 col-lg-9 my-main-card" id="chatBox">
                <div class="my-main-card-head" id="targetName"></div>
                <div class="message-box" id="messageList">
                </div>
                <div class="send-box">
                    <textarea class="chat-textarea" placeholder="请输入..." id="message"></textarea>
                    <label class="inputLabel"> <input style="display: none" type="file" accept="image/*"
                                                      id="pictureInput"> <img src="resource/chat/chatpicture.jpg"
                                                                              height="30"> </label>
                    <label class="inputLabel"> <input style="display: none" type="file" accept="video/*"
                                                      id="videoInput"> <img src="resource/chat/chatvideo.jpg"
                                                                            height="30"> </label>
                    <label class="inputLabel"> <input style="display: none" type="file" accept="" id="fileInput"> <img
                            src="resource/chat/chatfile.jpg" height="30"> </label>
                    <button type="button" class="btn btn-primary" onclick="sendMessage('0')">发送</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--图文详情部分结束-->
<!--评论区部分开始--> {评论模板}
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
<link href="resource/chat/chat.css" rel="stylesheet">
<script>
    var messageList = []
    var messageTimer = undefined
    var divScroll = $("#messageList");
    var myid = "${sessionScope.id}"
    var myidentity = "${sessionScope.identity}"
    var myname = "${sessionScope.mingzi}"
    var targetid = ""
    var targetidentity = ""
    var targetname = ""
    var getContactListSQL = "SELECT \n" +
        "    CASE\n" +
        "        WHEN senderid = " + myid + " AND senderidentity = '" + myidentity + "' THEN receiverid\n" +
        "        ELSE senderid\n" +
        "    END AS contactid,\n" +
        "    CASE\n" +
        "        WHEN senderid = " + myid + " AND senderidentity = '" + myidentity + "' THEN receiveridentity\n" +
        "        ELSE senderidentity\n" +
        "    END AS contactidentity,\n" +
        "\t\tCASE\n" +
        "        WHEN senderid = " + myid + " AND senderidentity = '" + myidentity + "' THEN receivername\n" +
        "        ELSE sendername\n" +
        "    END AS contactname,\n" +
        "    COUNT(CASE WHEN receiverid = " + myid + " AND receiveridentity = '" + myidentity + "' AND isread = '0' THEN '1' END) AS unreadcount\n" +
        "FROM\n" +
        "    t_chat\n" +
        "WHERE\n" +
        "    (senderid = " + myid + " AND senderidentity = '" + myidentity + "') OR (receiverid = " + myid + " AND receiveridentity = '" + myidentity + "')\n" +
        "GROUP BY\n" +
        "    contactid, contactidentity;"
    // 判断是不是从打招呼页面跳转，是则进入到对应聊天页
    var params = getURLParams()
    var toid = params['toid']
    var toidentity = params['toidentity']
    var toname = params['toname']
    if (toid && toidentity) {
        // 获取本人与聊天对象的聊天记录
        var getMessageListSQL = "select * from t_chat where (senderid = " + toid + " and senderidentity = '" + toidentity + "' and receiverid = " + myid + " and receiveridentity = '" + myidentity + "')or(senderid = " + myid + " and senderidentity = '" + myidentity + "' and receiverid = " + toid + " and receiveridentity = '" + toidentity + "') order by sendtime "
        $.ajax({
            url: 'executequery.action',
            type: 'POST',
            data: {sql: getMessageListSQL},
            success: function (response) {
                if (response.result.length > 0) {//已发过消息
                    console.log("已发过消息")
                    targetid = toid
                    targetidentity = toidentity
                    getContactList()
                    setInterval(function () {
                        getContactList()
                    }, 3000)
                } else {//未发过消息
                    console.log("未发过消息")
                    targetid = toid
                    targetidentity = toidentity
                    targetname = toname
                    //直接创建消息记录，并进行初始化
                    var sendMessageSQL = "insert into t_chat(`senderid`,`senderidentity`,`sendername`,`receiverid`,`receiveridentity`,`receivername`,`sendtime`,`message`,`isread`,`type`) value(" + myid + ",'" + myidentity + "','" + myname + "'," + targetid + ",'" + targetidentity + "','" + targetname + "','" + getCurrentDateTime() + "','你好','" + 0 + "','0')"
                    $.ajax({
                        url: 'executeadd.action',
                        type: 'POST',
                        data: {sql: sendMessageSQL},
                        success: function (response) {
                            getContactList()
                            setInterval(function () {
                                getContactList()
                            }, 3000)
                        },
                        error: function (error) {
                            // 请求失败的处理
                            console.log("请求失败");
                        }
                    });
                }
            },
            error: function (error) {
                console.log("请求失败")
            }
        })

    } else {
        getContactList()
        setInterval(function () {
            getContactList()
        }, 3000)
    }

    function getContactList() {
        $.ajax({
            url: 'executequery.action',
            type: 'POST',
            data: {sql: getContactListSQL},
            success: function (response) {
                var divStr = ""
                $("#contactList").empty()
                response.result.forEach(function (item) {
                    if (targetid === item.contactid + "" && targetidentity === item.contactidentity) {
                        targetname = item.contactname
                        divStr += "<div name='contact-item' class=\"contact-item user-active\" contact-id='" + item.contactid + "' contact-identity='" + item.contactidentity + "'><div class='contactName'>" + item.contactname
                    } else {
                        divStr += "<div name='contact-item' class=\"contact-item\" contact-id='" + item.contactid + "' contact-identity='" + item.contactidentity + "'><div class='contactName'>" + item.contactname
                    }
                    if (item.unreadcount > 0) {
                        if (targetid === item.contactid + "" && targetidentity === item.contactidentity) {
                            divStr += "</div><span style='display: none;'>" + item.unreadcount + "</span></div>"
                        } else {
                            divStr += "</div><span style='display: inline-block;'>" + item.unreadcount + "</span></div>"
                        }
                    } else {
                        divStr += "</div><span style='display: none;'>" + item.unreadcount + "</span></div>"
                    }
                })


                $("#contactList").append($(divStr))
                // 打招呼点击过来后初始化聊天
                if (toid) {
                    $("#chatBox").show()
                    $("#targetName").text(targetname)
                    getMessageList('0')
                    clearInterval(messageTimer)
                    messageTimer = setInterval(function () {
                        getMessageList('1')
                    }, 3000)
                    toid = undefined
                }
                $("[name='contact-item']").click(function () {
                    $(".contact-item").attr("class", "contact-item")
                    $(this).attr("class", "contact-item user-active")
                    $("#message").val("")
                    $("#chatBox").show()
                    var contactid = $(this).attr("contact-id")
                    var contactidentity = $(this).attr("contact-identity")
                    targetname = $(this).find(".contactName").text()
                    $("#targetName").text(targetname)
                    targetid = contactid
                    targetidentity = contactidentity
                    getMessageList('0')
                    clearInterval(messageTimer)
                    messageTimer = setInterval(function () {
                        getMessageList('1')
                    }, 3000)
                })
            },
            error: function (error) {
                console.log("请求失败")
            }
        });
    }

    function readMessage() {
        var readMessageSQL = "update t_chat set isread = '1' where senderid = " + targetid + " and senderidentity = '" + targetidentity + "' and receiverid = " + myid + " and receiveridentity = '" + myidentity + "'"
        $.ajax({
            url: 'executeadd.action',
            type: 'POST',
            data: {sql: readMessageSQL},
            success: function (response) {
                $("[contact-id='" + targetid + "'][contact-identity='" + targetidentity + "']").find("span").hide()
            },
            error: function (error) {
                // 请求失败的处理
                console.log("请求失败");
            }
        });
    }

    function getMessageList(type) {
        readMessage()
        var getMessageListSQL = "select * from t_chat where (senderid = " + targetid + " and senderidentity = '" + targetidentity + "' and receiverid = " + myid + " and receiveridentity = '" + myidentity + "')or(senderid = " + myid + " and senderidentity = '" + myidentity + "' and receiverid = " + targetid + " and receiveridentity = '" + targetidentity + "') order by sendtime "
        $.ajax({
            url: 'executequery.action',
            type: 'POST',
            data: {sql: getMessageListSQL},
            success: function (response) {
                var divStr = ""
                if (type === '0') {
                    messageList = response.result
                    $("#messageList").empty()
                    messageList.forEach(function (item) {
                        if (myid === item.senderid + "" && myidentity === item.senderidentity) {
                            divStr += "                    <div class=\"messageItem\">\n" +
                                "                        <div class=\"userAvatarBox\"></div>\n" +
                                "                        <div class=\"messageBox\">"
                            if (item.type === '0') {
                                divStr += "<div class=\"messageRight\">" + item.message + "</div>"
                            } else if (item.type === '1') {
                                divStr += "<img class=\"picRight\" src=\"resource/uploads/" + item.message + "\">"
                            } else if (item.type === '2') {
                                divStr += "<video  class=\"picRight\" src=\"resource/uploads/" + item.message + "\" controls></video>"
                            } else if (item.type === '3') {
                                divStr += "<div class=\"fileRight\">\n" +
                                    "                                <div class=\"file-top\">\n" +
                                    "                                    <img class=\"filePic\" src=\"resource/chat/chatfilePic.jpg\"\n" +
                                    "                                         height=\"90\">\n" +
                                    "                                    " + item.message.split(".")[1] + "\n" +
                                    "                                </div>\n" +
                                    "                                <div class=\"file-bottom\"><a href=\"resource/uploads/" + item.message + "\" download>下载</a></div>\n" +
                                    "                            </div>"
                            }
                            divStr += "</div>\n" +
                                "                        <div class=\"userAvatarBox\"><div class=\"userAvatar\">" + item.sendername.substring(0, 1) + "</div></div>\n" +
                                "                    </div>"
                        } else {
                            divStr += "                    <div class=\"messageItem\">\n" +
                                "                        <div class=\"userAvatarBox\"><div class=\"userAvatar\">" + item.sendername.substring(0, 1) + "</div></div>\n" +
                                "                        <div class=\"messageBox\">"
                            if (item.type === '0') {
                                divStr += "<div class=\"messageLeft\">" + item.message + "</div>"
                            } else if (item.type === '1') {
                                divStr += "<img class=\"picLeft\" src=\"resource/uploads/" + item.message + "\">"
                            } else if (item.type === '2') {
                                divStr += "<video class=\"picLeft\" src=\"resource/uploads/" + item.message + "\" controls></video>"
                            } else if (item.type === '3') {
                                divStr += "<div class=\"fileLeft\">\n" +
                                    "                                <div class=\"file-top\">\n" +
                                    "                                    <img class=\"filePic\" src=\"resource/chat/chatfilePic.jpg\"\n" +
                                    "                                         height=\"90\">\n" +
                                    "                                    " + item.message.split(".")[1] + "\n" +
                                    "                                </div>\n" +
                                    "                                <div class=\"file-bottom\"><a href=\"resource/uploads/" + item.message + "\" download>下载</a></div>\n" +
                                    "                            </div>"
                            }
                            divStr += "</div>\n" +
                                "                        <div class=\"userAvatarBox\"></div>\n" +
                                "                    </div>"
                        }
                    })
                    $("#messageList").append($(divStr))
                    setTimeout(function () {
                        divScroll.scrollTop(divScroll.prop('scrollHeight'));
                    }, 50)
                } else { //刷新
                    if (response.result.length > messageList.length) {
                        var oldlength = messageList.length
                        messageList = response.result
                        messageList.forEach(function (item, index) {
                            if (index >= oldlength) {
                                if (myid === item.senderid + "" && myidentity === item.senderidentity) {
                                    divStr += "                    <div class=\"messageItem\">\n" +
                                        "                        <div class=\"userAvatarBox\"></div>\n" +
                                        "                        <div class=\"messageBox\">"
                                    if (item.type === '0') {
                                        divStr += "<div class=\"messageRight\">" + item.message + "</div>"
                                    } else if (item.type === '1') {
                                        divStr += "<img class=\"picRight\" src=\"resource/uploads/" + item.message + "\">"
                                    } else if (item.type === '2') {
                                        divStr += "<video  class=\"picRight\" src=\"resource/uploads/" + item.message + "\" controls></video>"
                                    } else if (item.type === '3') {
                                        divStr += "<div class=\"fileRight\">\n" +
                                            "                                <div class=\"file-top\">\n" +
                                            "                                    <img class=\"filePic\" src=\"resource/chat/chatfilePic.jpg\"\n" +
                                            "                                         height=\"90\">\n" +
                                            "                                    " + item.message.split(".")[1] + "\n" +
                                            "                                </div>\n" +
                                            "                                <div class=\"file-bottom\"><a href=\"resource/uploads/" + item.message + "\" download>下载</a></div>\n" +
                                            "                            </div>"
                                    }
                                    divStr += "</div>\n" +
                                        "                        <div class=\"userAvatarBox\"><div class=\"userAvatar\">" + item.sendername.substring(0, 1) + "</div></div>\n" +
                                        "                    </div>"
                                } else {
                                    divStr += "                    <div class=\"messageItem\">\n" +
                                        "                        <div class=\"userAvatarBox\"><div class=\"userAvatar\">" + item.sendername.substring(0, 1) + "</div></div>\n" +
                                        "                        <div class=\"messageBox\">"
                                    if (item.type === '0') {
                                        divStr += "<div class=\"messageLeft\">" + item.message + "</div>"
                                    } else if (item.type === '1') {
                                        divStr += "<img class=\"picLeft\" src=\"resource/uploads/" + item.message + "\">"
                                    } else if (item.type === '2') {
                                        divStr += "<video class=\"picLeft\" src=\"resource/uploads/" + item.message + "\" controls></video>"
                                    } else if (item.type === '3') {
                                        divStr += "<div class=\"fileLeft\">\n" +
                                            "                                <div class=\"file-top\">\n" +
                                            "                                    <img class=\"filePic\" src=\"resource/chat/chatfilePic.jpg\"\n" +
                                            "                                         height=\"90\">\n" +
                                            "                                    " + item.message.split(".")[1] + "\n" +
                                            "                                </div>\n" +
                                            "                                <div class=\"file-bottom\"><a href=\"resource/uploads/" + item.message + "\" download>下载</a></div>\n" +
                                            "                            </div>"
                                    }
                                    divStr += "</div>\n" +
                                        "                        <div class=\"userAvatarBox\"></div>\n" +
                                        "                    </div>"
                                }
                            }

                        })
                        $("#messageList").append($(divStr))
                        if (divScroll.scrollTop() > divScroll.prop('scrollHeight') - 800) {
                            setTimeout(function () {
                                divScroll.scrollTop(divScroll.prop('scrollHeight'));
                            }, 50)
                        }
                    }
                }

            },
            error: function (error) {
                // 请求失败的处理
                console.log("请求失败");
            }
        });
    }

    function sendMessage(type, filename) {
        var message = $("#message").val()
        if (type === '0' && !message) {
            return
        }
        if (type !== '0') {
            message = filename
        }
        var sendMessageSQL = "insert into t_chat(`senderid`,`senderidentity`,`sendername`,`receiverid`,`receiveridentity`,`receivername`,`sendtime`,`message`,`isread`,`type`) value(" + myid + ",'" + myidentity + "','" + myname + "'," + targetid + ",'" + targetidentity + "','" + targetname + "','" + getCurrentDateTime() + "','" + message + "','" + 0 + "','" + type + "')"
        $.ajax({
            url: 'executeadd.action',
            type: 'POST',
            data: {sql: sendMessageSQL},
            success: function (response) {
                var divStr = ""
                divStr += "                    <div class=\"messageItem\">\n" +
                    "                        <div class=\"userAvatarBox\"></div>\n" +
                    "                        <div class=\"messageBox\">"
                if (type === '0') {
                    divStr += "<div class=\"messageRight\">" + message + "</div>"
                } else if (type === '1') {
                    divStr += "<img class=\"picRight\" src=\"resource/uploads/" + message + "\">"
                } else if (type === '2') {
                    divStr += "<video class=\"picRight\" src=\"resource/uploads/" + message + "\" controls></video>"
                } else if (type === '3') {
                    divStr += "<div class=\"fileRight\">\n" +
                        "                                <div class=\"file-top\">\n" +
                        "                                    <img class=\"filePic\" src=\"resource/chat/chatfilePic.jpg\"\n" +
                        "                                         height=\"90\">\n" +
                        "                                    " + message.split(".")[1] + "\n" +
                        "                                </div>\n" +
                        "                                <div class=\"file-bottom\"><a href=\"resource/uploads/" + message + "\" download>下载</a></div>\n" +
                        "                            </div>"
                }
                divStr += "</div>\n" +
                    "                        <div class=\"userAvatarBox\"><div class=\"userAvatar\">" + myname.substring(0, 1) + "</div></div>\n" +
                    "                    </div>"
                $("#messageList").append($(divStr))
                divScroll.scrollTop(divScroll.prop('scrollHeight'));
                if (type === '0') {
                    $("#message").val("")
                }
                messageList.push({})
            },
            error: function (error) {
                // 请求失败的处理
                console.log("请求失败");
            }
        });
    }

    $("#message").on("keydown", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault()
            sendMessage('0')
        }
    })

    function getCurrentDateTime() {
        var date = new Date();
        var year = date.getFullYear();
        var month = (date.getMonth() + 1).toString().padStart(2, '0');
        var day = date.getDate().toString().padStart(2, '0');
        var hour = date.getHours().toString().padStart(2, '0');
        var minute = date.getMinutes().toString().padStart(2, '0');
        var second = date.getSeconds().toString().padStart(2, '0');

        var formattedDate = year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
        return formattedDate;
    }


    $('#pictureInput').change(function (e) {
        var file = e.target.files[0];
        if (file) {
            var formData = new FormData();
            formData.append('file', file);
            $.ajax({
                url: 'addfilejson.action',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    sendMessage('1', response)
                    // 处理上传成功的响应
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    // 处理上传失败的响应
                }
            });
        }
    });


    $('#videoInput').change(function (e) {
        var file = e.target.files[0];
        if (file) {
            var formData = new FormData();
            formData.append('file', file);
            $.ajax({
                url: 'addfilejson.action',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    sendMessage('2', response)
                    // 处理上传成功的响应
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    // 处理上传失败的响应
                }
            });
        }
    });

    $('#fileInput').change(function (e) {
        var file = e.target.files[0];
        if (file) {
            var formData = new FormData();
            formData.append('file', file);
            $.ajax({
                url: 'addfilejson.action',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (response) {
                    sendMessage('3', response)
                    // 处理上传成功的响应
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    // 处理上传失败的响应
                }
            });
        }
    });

    function getURLParams() {
        var params = {};
        var url = window.location.href;
        var queryString = url.split("?")[1];
        if (queryString) {
            var keyValuePairs = queryString.split("&");
            for (var i = 0; i < keyValuePairs.length; i++) {
                var keyValuePair = keyValuePairs[i].split("=");
                var paramName = decodeURIComponent(keyValuePair[0]);
                var paramValue = decodeURIComponent(keyValuePair[1]);
                params[paramName] = paramValue;
            }
        }
        return params;
    }
</script>
</body>
</html>

