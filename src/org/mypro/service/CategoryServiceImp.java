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

import org.mypro.dao.CategoryMapper;

import org.mypro.entity.Category;

import org.mypro.entity.CategoryExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

public interface CategoryServiceImp {


    //定义方法addcategory接口,响应控制层添加分组请求

    public void addcategory(HttpServletRequest request, HttpSession session);


    //定义addcategoryact接口

    public void addcategoryact(HttpServletRequest request, HttpSession session, Category category) throws IOException;


    //定义categorymanage方法响应页面请求

    public void categorymanage(HttpServletRequest request, HttpSession session);


    // 定义 categoryview方法

    public void categoryview(HttpServletRequest request, HttpSession session);


    // 定义 updatecategory方法

    public void updatecategory(HttpServletRequest request, HttpSession session, int id);


    // 定义updatecategoryact处理分组修改

    public void updatecategoryact(HttpServletRequest request, Category category, HttpSession session) throws IOException;


    // 定义deletecategory,处理删除分组

    public void deletecategory(HttpServletRequest request, HttpSession session, int id);


    // 定义searchcategory方法，处理搜索操作

    public void searchcategory(HttpServletRequest request, HttpSession session, String search);


    // 定义CategorypinglunMapper

    public void categorydetails(HttpServletRequest request, HttpSession session, int id);


}

