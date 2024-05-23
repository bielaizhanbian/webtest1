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

import org.mypro.service.FriendsServiceImp;

import org.mypro.entity.Friends;

import org.mypro.entity.FriendsExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.entity.User;

import org.mypro.entity.UserExample;

import org.mypro.dao.UserMapper;

import org.mypro.entity.Category;

import org.mypro.entity.CategoryExample;

import org.mypro.dao.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class FriendsController {


    private static final Log logger = LogFactory.getLog(FriendsController.class);

    @Autowired
    private FriendsServiceImp friendsservice;


    //定义方法addfriends,响应页面addfriends请求

    @RequestMapping(value = "addfriends")

    public String addfriends(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addfriends

        logger.debug("FriendsController.addfriends ......");

        friendsservice.addfriends(request, session);

        return "addfriends";

    }


    //定义addfriendsact方法,将好友信息插入到数据库的t_friends表中

    @RequestMapping(value = "addfriendsact")

    public String addfriendsact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Friends friends) throws IOException {

        //输出当前方法日志，表示正在执行FriendsController.addfriendsact方法

        logger.debug("FriendsController.addfriendsact ......");

        friendsservice.addfriendsact(request, session, friends); //返回好友管理方法，执行好友信息的查询

        return "forward:/friendsmanage.action";

    }


    //定义friendsmanage方法响应页面请求

    @RequestMapping(value = "friendsmanage")

    public String friendsmanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行FriendsController.friendsmanage

        logger.debug("FriendsController.friendsmanage ......");


        friendsservice.friendsmanage(request, session); //返回到好友管理页面

        return "friendsmanage";

    }


    // 定义 friendsview方法

    @RequestMapping(value = "friendsview")

    public String friendsview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行FriendsController.friendsview方法

        logger.debug("FriendsController.friendsview ......");


        friendsservice.friendsview(request, session);

        // 返回好友查看页面

        return "friendsview";

    }


    // 定义 updatefriends方法

    @RequestMapping(value = "updatefriends")

    public String updatefriends(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志FriendsController.updatefriends，表示正在执行该方法

        logger.debug("FriendsController.updatefriends ......");


        friendsservice.updatefriends(request, session, id); // 返回修改好友页面

        return "updatefriends";

    }


    // 定义updatefriendsact处理好友修改

    @RequestMapping(value = "updatefriendsact")

    public String updatefriendsact(HttpServletRequest request, HttpServletResponse response, Friends friends, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法FriendsController.updatefriendsact

        logger.debug("FriendsController.updatefriendsact ......");

        friendsservice.updatefriendsact(request, friends, session);

        // 返回好友管理方法

        return "forward:/friendsmanage.action";

    }


    // 定义deletefriends,处理删除好友

    @RequestMapping(value = "deletefriends")

    public String deletefriends(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行FriendsController.deletefriends方法

        logger.debug("FriendsController.deletefriends ......");

        friendsservice.deletefriends(request, session, id);

        // 返回好友管理方法

        return "forward:/friendsmanage.action";

    }


    // 定义searchfriends方法，处理搜索操作

    @RequestMapping(value = "searchfriends")

    public String searchfriends(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行FriendsController.searchfriends

        logger.debug("FriendsController.searchfriends ......");


        friendsservice.searchfriends(request, session, search); // 返回查询好友页面

        return "searchfriends";

    }


    // 定义FriendspinglunMapper

    @RequestMapping(value = "friendsdetails")

    public String friendsdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为FriendsController.friendsdetails

        logger.debug("FriendsController.friendsdetails ......");


        friendsservice.friendsdetails(request, session, id); // 返回好友详情页面

        return "friendsdetails";

    }


}

