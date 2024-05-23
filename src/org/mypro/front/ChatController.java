package org.mypro.front;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.mypro.service.ChatServiceImp;

import org.mypro.entity.Chat;

import org.mypro.entity.ChatExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class ChatController {


    private static final Log logger = LogFactory.getLog(ChatController.class);

    @Autowired
    private ChatServiceImp chatservice;


    //定义方法addchat,响应页面addchat请求

    @RequestMapping(value = "addchat")

    public String addchat(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addchat

        logger.debug("ChatController.addchat ......");

        chatservice.addchat(request, session);

        return "addchat";

    }


    //定义addchatact方法,将聊天信息插入到数据库的t_chat表中

    @RequestMapping(value = "addchatact")

    public String addchatact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Chat chat) throws IOException {

        //输出当前方法日志，表示正在执行ChatController.addchatact方法

        logger.debug("ChatController.addchatact ......");

        chatservice.addchatact(request, session, chat); //返回聊天管理方法，执行聊天信息的查询

        return "forward:/chatmanage.action";

    }


    //定义chatmanage方法响应页面请求

    @RequestMapping(value = "chatmanage")

    public String chatmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行ChatController.chatmanage

        logger.debug("ChatController.chatmanage ......");


        chatservice.chatmanage(request, session); //返回到聊天管理页面

        return "chatmanage";

    }


    // 定义 chatview方法

    @RequestMapping(value = "chatview")

    public String chatview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行ChatController.chatview方法

        logger.debug("ChatController.chatview ......");


        chatservice.chatview(request, session);

        // 返回聊天查看页面

        return "chatview";

    }


    // 定义 updatechat方法

    @RequestMapping(value = "updatechat")

    public String updatechat(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志ChatController.updatechat，表示正在执行该方法

        logger.debug("ChatController.updatechat ......");


        chatservice.updatechat(request, session, id); // 返回修改聊天页面

        return "updatechat";

    }


    // 定义updatechatact处理聊天修改

    @RequestMapping(value = "updatechatact")

    public String updatechatact(HttpServletRequest request, HttpServletResponse response, Chat chat, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法ChatController.updatechatact

        logger.debug("ChatController.updatechatact ......");

        chatservice.updatechatact(request, chat, session);

        // 返回聊天管理方法

        return "forward:/chatmanage.action";

    }


    // 定义deletechat,处理删除聊天

    @RequestMapping(value = "deletechat")

    public String deletechat(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行ChatController.deletechat方法

        logger.debug("ChatController.deletechat ......");

        chatservice.deletechat(request, session, id);

        // 返回聊天管理方法

        return "forward:/chatmanage.action";

    }


    // 定义searchchat方法，处理搜索操作

    @RequestMapping(value = "searchchat")

    public String searchchat(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行ChatController.searchchat

        logger.debug("ChatController.searchchat ......");


        chatservice.searchchat(request, session, search); // 返回查询聊天页面

        return "searchchat";

    }


    // 定义ChatpinglunMapper

    @RequestMapping(value = "chatdetails")

    public String chatdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为ChatController.chatdetails

        logger.debug("ChatController.chatdetails ......");


        chatservice.chatdetails(request, session, id); // 返回聊天详情页面

        return "chatdetails";

    }


}

