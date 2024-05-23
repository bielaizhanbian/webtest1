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

import org.mypro.dao.ChatMapper;

import org.mypro.entity.Chat;

import org.mypro.entity.ChatExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface ChatServiceImp {


    //定义方法addchat接口,响应控制层添加聊天请求

    public void addchat(HttpServletRequest request, HttpSession session);


    //定义addchatact接口

    public void addchatact(HttpServletRequest request, HttpSession session, Chat chat) throws IOException;


    //定义chatmanage方法响应页面请求

    public void chatmanage(HttpServletRequest request, HttpSession session);


    // 定义 chatview方法

    public void chatview(HttpServletRequest request, HttpSession session);


    // 定义 updatechat方法

    public void updatechat(HttpServletRequest request, HttpSession session, int id);


    // 定义updatechatact处理聊天修改

    public void updatechatact(HttpServletRequest request, Chat chat, HttpSession session) throws IOException;


    // 定义deletechat,处理删除聊天

    public void deletechat(HttpServletRequest request, HttpSession session, int id);


    // 定义searchchat方法，处理搜索操作

    public void searchchat(HttpServletRequest request, HttpSession session, String search);


    // 定义ChatpinglunMapper

    public void chatdetails(HttpServletRequest request, HttpSession session, int id);


}

