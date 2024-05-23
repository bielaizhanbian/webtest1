package org.mypro.front;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import org.mypro.dao.NoticeMapper;

import org.mypro.entity.NoticeExample;

import java.util.Calendar;

import java.util.Collections;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import java.util.Map;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping(value = "/")

public class IndexController {

    private static final Log logger = LogFactory.getLog(IndexController.class);

    @Autowired
    private NoticeMapper noticedao;

    @RequestMapping(value = "index")

    public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        logger.debug("IndexController.index ......");// 实例化NoticeExample
        NoticeExample example1 = new NoticeExample();

// 实例化NoticeExample内部类Criteria  
        NoticeExample.Criteria criteria1 = example1.createCriteria();

// 查询所有公告保存到noticeall1中  
        List noticeall1 = noticedao.selectByExample(example1);

// 定义最新公告list  
        List noticezuixin6 = null;

// 如果所有的公告数量大于了 6 
        if (noticeall1.size() > 6) {

// 截取noticeall1中的前6位保存到最新公告list中 
            noticezuixin6 = noticeall1.subList(noticeall1.size() - 7, noticeall1.size() - 1);

        } else {

// 将所有公告添加到最新公告list中 
            noticezuixin6 = noticeall1;

        }

// 将最新公告list保存到request中 
        request.setAttribute("noticezuixin6", noticezuixin6);

        return "index";

    }

    // 上传文件图片等

    public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {

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

