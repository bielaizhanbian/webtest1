package org.mypro.service;

import java.io.File;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

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

@Service

public class NoticeService implements NoticeServiceImp {


    private static final Log logger = LogFactory.getLog(NoticeService.class);

    @Autowired
    private NoticeMapper noticedao;


    //定义方法addnotice,响应控制层addnotice请求

    public void addnotice(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addnotice

        logger.debug("NoticeService.addnotice ......");


    }


    //定义addnoticeact方法

    public void addnoticeact(HttpServletRequest request, HttpSession session, Notice notice, MultipartFile picfile) throws IOException {

        //输出当前方法日志，表示正在执行NoticeService.addnoticeact方法

        logger.debug("NoticeService.addnoticeact ......");

// 判断封面文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的封面文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将notice的封面设置为pic的值  

            notice.setPic(pic);

        }


        //使用noticedao的insert方法将公告添加到数据库中

        noticedao.insert(notice);


        //将添加公告信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加公告成功");

    }


    //定义noticemanage方法响应页面请求

    public void noticemanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行NoticeService.noticemanage

        logger.debug("NoticeService.noticemanage ......");


        //实例化NoticeExample类为example

        NoticeExample example = new NoticeExample();


        //使用  noticedao.selectByExample(example)方法获取所有的公告数据

        List noticeall = noticedao.selectByExample(example);


        //将所有的公告数据保存到request中的noticeall参数里

        request.setAttribute("noticeall", noticeall);


    }


    // 定义 noticeview方法

    public void noticeview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行NoticeService.noticeview方法

        logger.debug("NoticeService.noticeview ......");


        // 实例化NoticeExample类

        NoticeExample example = new NoticeExample();


        // 使用noticedao的selectByExample方法查询公告信息

        List noticeall = noticedao.selectByExample(example);


        // 将查询的noticeall保存到request中，记录为参数noticeall

        request.setAttribute("noticeall", noticeall);


    }


    // 定义 updatenotice方法

    public void updatenotice(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志NoticeController.updatenotice，表示正在执行该方法

        logger.debug("NoticeController.updatenotice ......");


        // 定义公告为biaoming，使用 noticedao的selectByPrimaryKey方法通过id查询数据

        Notice notice = noticedao.selectByPrimaryKey(id);


        // 将查询的公告保存到request中

        request.setAttribute("notice", notice);


    }


    // 定义updatenoticeact处理公告修改

    public void updatenoticeact(HttpServletRequest request, Notice notice, HttpSession session, MultipartFile picfile) throws IOException {

        // 输出日志，表示正在执行当前方法NoticeController.updatenoticeact

        logger.debug("NoticeController.updatenoticeact ......");

// 判断封面文件是否为空  

        if (!picfile.isEmpty()) {

// 调用uploadUtile方法将页面传入的封面文件上传到服务器，将返回的文件名保存到pic参数中  

            String pic = uploadUtile(picfile, request);

// 将notice的封面设置为pic的值  

            notice.setPic(pic);

        }


        // 执行noticedao的updateByPrimaryKeySelective方法，将传入的公告数据同步到数据库中

        noticedao.updateByPrimaryKeySelective(notice);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改公告信息成功");


    }


    // 定义deletenotice,处理删除公告

    public void deletenotice(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行NoticeService.deletenotice方法

        logger.debug("NoticeService.deletenotice ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化公告example
            NoticeExample example = new NoticeExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化公告criteria
            NoticeExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的公告id信息
            List<Integer> idlist = new ArrayList();
            //根据id分离出需要删除的数据id信息
            String[] idarr = ids.split(",");
            //将对应的id数据信息保存到数组中
            for (int i = 0; i < idarr.length; i++) {
                //取出对应的id信息，并转换成int类型
                idlist.add(Integer.parseInt(idarr[i]));
            }
            //传入需要删除的id数组信息
            criteria.andIdIn(idlist);
            //调用公告的dao类，执行批量删除操作
            noticedao.deleteByExample(example);
        } else {
            // 根据id调用noticedao的deleteByPrimaryKey方法，删除公告


            noticedao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除公告成功");


    }


    // 定义searchnotice方法，处理搜索操作

    public void searchnotice(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行NoticeService.searchnotice

        logger.debug("NoticeService.searchnotice ......");


        // 实例化 NoticeExample

        NoticeExample example = new NoticeExample();

        // 实例化 NoticeExample的Criteria内部类

        NoticeExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andTitleLike("%" + search + "%");

        }

        // 查询公告结果

        List noticeall = noticedao.selectByExample(example);

        // 将查询到的公告 保存到request中进行保存

        request.setAttribute("noticeall", noticeall);

    }


    // 定义NoticepinglunMapper

    public void noticedetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为NoticeController.noticedetails

        logger.debug("NoticeController.noticedetails ......");


        // 传入页面所传入的公告id使用noticedao的selectByPrimaryKey方法进行查询

        Notice notice = noticedao.selectByPrimaryKey(id);

        // 将查询到的公告保存到request中

        request.setAttribute("notice", notice);


    }


//	上传文件图片等

    public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {

        // 根据当前时间生成时间字符串

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

        String res = sdf.format(new Date());

        // uploads文件夹位置

        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");

        // 原始名称

        String originalFileName = file.getOriginalFilename();

        // 新文件名

        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));

        // 创建年月文件夹

        Calendar date = Calendar.getInstance();

        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));

        // 新文件

        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);

        // 判断目标文件所在目录是否存在

        if (!newFile.getParentFile().exists()) {

            // 如果目标文件所在的目录不存在，则创建父目录

            newFile.getParentFile().mkdirs();

        }

        System.out.println(newFile);

        // 将内存中的数据写入磁盘

        file.transferTo(newFile);

        // 完整的url

        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + newFileName;

        return fileUrl;

    }
}

