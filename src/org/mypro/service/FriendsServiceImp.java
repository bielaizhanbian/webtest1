package org.mypro.service;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.HashMap;

import java.util.Map;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.mypro.dao.FriendsMapper;

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

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface FriendsServiceImp {


    //定义方法addfriends接口,响应控制层添加好友请求

    public void addfriends(HttpServletRequest request, HttpSession session);


    //定义addfriendsact接口

    public void addfriendsact(HttpServletRequest request, HttpSession session, Friends friends) throws IOException;


    //定义friendsmanage方法响应页面请求

    public void friendsmanage(HttpServletRequest request, HttpSession session);


    // 定义 friendsview方法

    public void friendsview(HttpServletRequest request, HttpSession session);


    // 定义 updatefriends方法

    public void updatefriends(HttpServletRequest request, HttpSession session, int id);


    // 定义updatefriendsact处理好友修改

    public void updatefriendsact(HttpServletRequest request, Friends friends, HttpSession session) throws IOException;


    // 定义deletefriends,处理删除好友

    public void deletefriends(HttpServletRequest request, HttpSession session, int id);


    // 定义searchfriends方法，处理搜索操作

    public void searchfriends(HttpServletRequest request, HttpSession session, String search);


    // 定义FriendspinglunMapper

    public void friendsdetails(HttpServletRequest request, HttpSession session, int id);


}

