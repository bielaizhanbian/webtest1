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

import org.mypro.dao.UserMapper;

import org.mypro.entity.User;

import org.mypro.entity.UserExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface UserServiceImp {


    //定义方法adduser接口,响应控制层添加用户请求

    public void adduser(HttpServletRequest request, HttpSession session);


    //定义adduseract接口

    public void adduseract(HttpServletRequest request, HttpSession session, User user) throws IOException;


    //定义usermanage方法响应页面请求

    public void usermanage(HttpServletRequest request, HttpSession session);


    // 定义 userview方法

    public void userview(HttpServletRequest request, HttpSession session);


    // 定义 updateuser方法

    public void updateuser(HttpServletRequest request, HttpSession session, int id);


    // 定义updateuseract处理用户修改

    public void updateuseract(HttpServletRequest request, User user, HttpSession session) throws IOException;


    // 定义deleteuser,处理删除用户

    public void deleteuser(HttpServletRequest request, HttpSession session, int id);


    // 定义searchuser方法，处理搜索操作

    public void searchuser(HttpServletRequest request, HttpSession session, String search);


    // 定义UserpinglunMapper

    public void userdetails(HttpServletRequest request, HttpSession session, int id);


}

