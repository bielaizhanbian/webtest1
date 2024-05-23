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

import org.mypro.dao.AdminMapper;

import org.mypro.entity.Admin;

import org.mypro.entity.AdminExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface AdminServiceImp {


    //定义方法addadmin接口,响应控制层添加管理员请求

    public void addadmin(HttpServletRequest request, HttpSession session);


    //定义addadminact接口

    public void addadminact(HttpServletRequest request, HttpSession session, Admin admin) throws IOException;


    //定义adminmanage方法响应页面请求

    public void adminmanage(HttpServletRequest request, HttpSession session);


    // 定义 adminview方法

    public void adminview(HttpServletRequest request, HttpSession session);


    // 定义 updateadmin方法

    public void updateadmin(HttpServletRequest request, HttpSession session, int id);


    // 定义updateadminact处理管理员修改

    public void updateadminact(HttpServletRequest request, Admin admin, HttpSession session) throws IOException;


    // 定义deleteadmin,处理删除管理员

    public void deleteadmin(HttpServletRequest request, HttpSession session, int id);


    // 定义searchadmin方法，处理搜索操作

    public void searchadmin(HttpServletRequest request, HttpSession session, String search);


    // 定义AdminpinglunMapper

    public void admindetails(HttpServletRequest request, HttpSession session, int id);


}

