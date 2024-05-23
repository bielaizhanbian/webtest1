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

import org.mypro.service.CategoryServiceImp;

import org.mypro.entity.Category;

import org.mypro.entity.CategoryExample;

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

public class CategoryController {


    private static final Log logger = LogFactory.getLog(CategoryController.class);

    @Autowired
    private CategoryServiceImp categoryservice;


    //定义方法addcategory,响应页面addcategory请求

    @RequestMapping(value = "addcategory")

    public String addcategory(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //输出日志，当前执行方法为addcategory

        logger.debug("CategoryController.addcategory ......");

        categoryservice.addcategory(request, session);

        return "addcategory";

    }


    //定义addcategoryact方法,将分组信息插入到数据库的t_category表中

    @RequestMapping(value = "addcategoryact")

    public String addcategoryact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Category category) throws IOException {

        //输出当前方法日志，表示正在执行CategoryController.addcategoryact方法

        logger.debug("CategoryController.addcategoryact ......");

        categoryservice.addcategoryact(request, session, category); //返回分组管理方法，执行分组信息的查询

        return "forward:/categorymanage.action";

    }


    //定义categorymanage方法响应页面请求

    @RequestMapping(value = "categorymanage")

    public String categorymanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //输出日志，表示当前正在执行CategoryController.categorymanage

        logger.debug("CategoryController.categorymanage ......");


        categoryservice.categorymanage(request, session); //返回到分组管理页面

        return "categorymanage";

    }


    // 定义 categoryview方法

    @RequestMapping(value = "categoryview")

    public String categoryview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        // 输出日志，表示当前正在执行CategoryController.categoryview方法

        logger.debug("CategoryController.categoryview ......");


        categoryservice.categoryview(request, session);

        // 返回分组查看页面

        return "categoryview";

    }


    // 定义 updatecategory方法

    @RequestMapping(value = "updatecategory")

    public String updatecategory(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志CategoryController.updatecategory，表示正在执行该方法

        logger.debug("CategoryController.updatecategory ......");


        categoryservice.updatecategory(request, session, id); // 返回修改分组页面

        return "updatecategory";

    }


    // 定义updatecategoryact处理分组修改

    @RequestMapping(value = "updatecategoryact")

    public String updatecategoryact(HttpServletRequest request, HttpServletResponse response, Category category, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法CategoryController.updatecategoryact

        logger.debug("CategoryController.updatecategoryact ......");

        categoryservice.updatecategoryact(request, category, session);

        // 返回分组管理方法

        return "forward:/categorymanage.action";

    }


    // 定义deletecategory,处理删除分组

    @RequestMapping(value = "deletecategory")

    public String deletecategory(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CategoryController.deletecategory方法

        logger.debug("CategoryController.deletecategory ......");

        categoryservice.deletecategory(request, session, id);

        // 返回分组管理方法

        return "forward:/categorymanage.action";

    }


    // 定义searchcategory方法，处理搜索操作

    @RequestMapping(value = "searchcategory")

    public String searchcategory(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {

        // 输出日志，表示当前正在执行CategoryController.searchcategory

        logger.debug("CategoryController.searchcategory ......");


        categoryservice.searchcategory(request, session, search); // 返回查询分组页面

        return "searchcategory";

    }


    // 定义CategorypinglunMapper

    @RequestMapping(value = "categorydetails")

    public String categorydetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {

        // 输入日志信息，表名当前执行方法为CategoryController.categorydetails

        logger.debug("CategoryController.categorydetails ......");


        categoryservice.categorydetails(request, session, id); // 返回分组详情页面

        return "categorydetails";

    }


}

