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
import org.mypro.service.NoticeServiceImp;
import org.mypro.entity.Notice;
import org.mypro.entity.NoticeExample;
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
public class NoticeController {

    private static final Log logger = LogFactory.getLog(NoticeController.class);

    @Autowired
    private NoticeServiceImp noticeservice;

    // 定义方法addnotice,响应页面addnotice请求
    @RequestMapping(value = "addnotice")
    public String addnotice(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // 输出日志，当前执行方法为addnotice
        logger.debug("NoticeController.addnotice ......");

        noticeservice.addnotice(request, session);

        return "addnotice";
    }

    // 定义addnoticeact方法,将公告信息插入到数据库的t_notice表中
    @RequestMapping(value = "addnoticeact")
    public String addnoticeact(HttpServletRequest request, HttpSession session, HttpServletResponse response, Notice notice, MultipartFile picfile) throws IOException {
        // 输出当前方法日志，表示正在执行NoticeController.addnoticeact方法
        logger.debug("NoticeController.addnoticeact ......");

        noticeservice.addnoticeact(request, session, notice, picfile); // 返回公告管理方法，执行公告信息的查询

        return "forward:/noticemanage.action";
    }

    // 定义noticemanage方法响应页面请求
    @RequestMapping(value = "noticemanage")
    public String noticemanage(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        // 输出日志，表示当前正在执行NoticeController.noticemanage
        logger.debug("NoticeController.noticemanage ......");

        noticeservice.noticemanage(request, session); // 返回到公告管理页面

        return "noticemanage";
    }

    // 定义noticeview方法
    @RequestMapping(value = "noticeview")
    public String noticeview(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        // 输出日志，表示当前正在执行NoticeController.noticeview方法
        logger.debug("NoticeController.noticeview ......");

        noticeservice.noticeview(request, session);

        // 返回公告查看页面
        return "noticeview";
    }

    // 定义updatenotice方法
    @RequestMapping(value = "updatenotice")
    public String updatenotice(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {
        // 输出日志NoticeController.updatenotice，表示正在执行该方法
        logger.debug("NoticeController.updatenotice ......");

        noticeservice.updatenotice(request, session, id); // 返回修改公告页面

        return "updatenotice";
    }

    // 定义updatenoticeact处理公告修改
    @RequestMapping(value = "updatenoticeact")
    public String updatenoticeact(HttpServletRequest request, HttpServletResponse response, Notice notice, HttpSession session, MultipartFile picfile) throws IOException {
        // 输出日志，表示正在执行当前方法NoticeController.updatenoticeact
        logger.debug("NoticeController.updatenoticeact ......");

        noticeservice.updatenoticeact(request, notice, session, picfile);

        // 返回公告管理方法
        return "forward:/noticemanage.action";
    }

    // 定义deletenotice,处理删除公告
    @RequestMapping(value = "deletenotice")
    public String deletenotice(HttpServletRequest request, HttpServletResponse response, HttpSession session, int id) {
        // 输出日志，表示当前正在执行NoticeController.deletenotice方法
        logger.debug("NoticeController.deletenotice ......");

        noticeservice.deletenotice(request, session, id);

        // 返回公告管理方法
        return "forward:/noticemanage.action";
    }

    // 定义searchnotice方法，处理搜索操作
    @RequestMapping(value = "searchnotice")
    public String searchnotice(HttpServletRequest request, HttpServletResponse response, HttpSession session, String search) {
        // 输出日志，表示当前正在执行NoticeController.searchnotice
        logger.debug("NoticeController.searchnotice ......");

        noticeservice.searchnotice(request, session, search); // 返回查询公告页面

        return "searchnotice";
    }

    // 定义NoticepinglunMapper
    @RequestMapping(value = "noticedetails")
    public String noticedetails(HttpServletRequest request, HttpSession session, HttpServletResponse response, int id) {
        // 输入日志信息，表名当前执行方法为NoticeController.noticedetails
        logger.debug("NoticeController.noticedetails ......");

        noticeservice.noticedetails(request, session, id); // 返回公告详情页面

        return "noticedetails";
    }
}
