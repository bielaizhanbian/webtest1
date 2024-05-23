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

import org.mypro.dao.NoticeMapper;

import org.mypro.entity.Notice;

import org.mypro.entity.NoticeExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface NoticeServiceImp {


    //定义方法addnotice接口,响应控制层添加公告请求

    public void addnotice(HttpServletRequest request, HttpSession session);


    //定义addnoticeact接口

    public void addnoticeact(HttpServletRequest request, HttpSession session, Notice notice, MultipartFile picfile) throws IOException;


    //定义noticemanage方法响应页面请求

    public void noticemanage(HttpServletRequest request, HttpSession session);


    // 定义 noticeview方法

    public void noticeview(HttpServletRequest request, HttpSession session);


    // 定义 updatenotice方法

    public void updatenotice(HttpServletRequest request, HttpSession session, int id);


    // 定义updatenoticeact处理公告修改

    public void updatenoticeact(HttpServletRequest request, Notice notice, HttpSession session, MultipartFile picfile) throws IOException;


    // 定义deletenotice,处理删除公告

    public void deletenotice(HttpServletRequest request, HttpSession session, int id);


    // 定义searchnotice方法，处理搜索操作

    public void searchnotice(HttpServletRequest request, HttpSession session, String search);


    // 定义NoticepinglunMapper

    public void noticedetails(HttpServletRequest request, HttpSession session, int id);


}

