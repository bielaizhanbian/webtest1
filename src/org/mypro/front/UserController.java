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
import org.mypro.service.UserServiceImp;
import org.mypro.entity.User;
import org.mypro.entity.UserExample;
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
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserServiceImp userservice;

    // 定义方法adduser,响应页面adduser请求
    @RequestMapping(value = "adduser")
    public String adduser(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // 输出日志，当前执行方法为adduser
        logger.debug("UserController.adduser ......");

        userservice.adduser(request, session);

        return "adduser";
    }

    // 定义adduseract方法,将用户信息插入到数据库的t_user表中
    @RequestMapping(value = "adduseract")
    public String adduseract(HttpServletRequest request, HttpSession session, HttpServletResponse response, User user) throws IOException {
        // 输出当前方法日志，表示正在执行UserController.adduseract方法
        logger.debug("UserController.adduseract ......");

        userservice.adduseract(request, session, user); // 返回用户管理方法，执行用户信息的查询

        return "forward:/usermanage.action";
    }

    // 定义usermanage方法响应页面请求
    @RequestMapping(value = "usermanage")
    public String usermanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        // 输出日志，表示当前正在执行UserController.usermanage
        logger.debug("UserController.usermanage ......");

        userservice.usermanage(request, session); // 返回到用户管理页面

        return "usermanage";
    }

    // 定义userview方法
    @RequestMapping(value = "userview")
    public String userview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        // 输出日志，表示当前正在执行UserController.userview方法
        logger.debug("UserController.userview ......");

        userservice.userview(request, session);

        // 返回用户查看页面
        return "userview";
    }

    // 定义updateuser方法
    @RequestMapping(value = "updateuser")
    public String updateuser(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {
        // 输出日志UserController.updateuser，表示正在执行该方法
        logger.debug("UserController.updateuser ......");

        userservice.updateuser(request, session, id); // 返回修改用户页面

        return "updateuser";
    }

    // 定义updateuseract处理用户修改
    @RequestMapping(value = "updateuseract")
    public String updateuseract(HttpServletRequest request, HttpServletResponse response, User user, HttpSession session) throws IOException {
        // 输出日志，表示正在执行当前方法UserController.updateuseract
        logger.debug("UserController.updateuseract ......");

        userservice.updateuseract(request, user, session);

        // 返回用户管理方法
        return "forward:/usermanage.action";
    }

    // 定义deleteuser,处理删除用户
    @RequestMapping(value = "deleteuser")
    public String deleteuser(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {
        // 输出日志，表示当前正在执行UserController.deleteuser方法
        logger.debug("UserController.deleteuser ......");

        userservice.deleteuser(request, session, id);

        // 返回用户管理方法
        return "forward:/usermanage.action";
    }

    // 定义searchuser方法，处理搜索操作
    @RequestMapping(value = "searchuser")
    public String searchuser(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {
        // 输出日志，表示当前正在执行UserController.searchuser
        logger.debug("UserController.searchuser ......");

        userservice.searchuser(request, session, search); // 返回查询用户页面

        return "searchuser";
    }

    // 定义UserpinglunMapper
    @RequestMapping(value = "userdetails")
    public String userdetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {
        // 输入日志信息，表名当前执行方法为UserController.userdetails
        logger.debug("UserController.userdetails ......");

        userservice.userdetails(request, session, id); // 返回用户详情页面

        return "userdetails";
    }
}
