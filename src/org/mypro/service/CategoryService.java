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

@Service

public class CategoryService implements CategoryServiceImp {


    private static final Log logger = LogFactory.getLog(CategoryService.class);

    @Autowired
    private CategoryMapper categorydao;


    //定义方法addcategory,响应控制层addcategory请求

    public void addcategory(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addcategory

        logger.debug("CategoryService.addcategory ......");


    }


    //定义addcategoryact方法

    public void addcategoryact(HttpServletRequest request, HttpSession session, Category category) throws IOException {

        //输出当前方法日志，表示正在执行CategoryService.addcategoryact方法

        logger.debug("CategoryService.addcategoryact ......");

        //使用categorydao的insert方法将分组添加到数据库中

        categorydao.insert(category);


        //将添加分组信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加分组成功");

    }


    //定义categorymanage方法响应页面请求

    public void categorymanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行CategoryService.categorymanage

        logger.debug("CategoryService.categorymanage ......");


        //实例化CategoryExample类为example

        CategoryExample example = new CategoryExample();


        //使用  categorydao.selectByExample(example)方法获取所有的分组数据

        List categoryall = categorydao.selectByExample(example);


        //将所有的分组数据保存到request中的categoryall参数里

        request.setAttribute("categoryall", categoryall);


    }


    // 定义 categoryview方法

    public void categoryview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行CategoryService.categoryview方法

        logger.debug("CategoryService.categoryview ......");


        // 实例化CategoryExample类

        CategoryExample example = new CategoryExample();


        // 使用categorydao的selectByExample方法查询分组信息

        List categoryall = categorydao.selectByExample(example);


        // 将查询的categoryall保存到request中，记录为参数categoryall

        request.setAttribute("categoryall", categoryall);


    }


    // 定义 updatecategory方法

    public void updatecategory(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志CategoryController.updatecategory，表示正在执行该方法

        logger.debug("CategoryController.updatecategory ......");


        // 定义分组为biaoming，使用 categorydao的selectByPrimaryKey方法通过id查询数据

        Category category = categorydao.selectByPrimaryKey(id);


        // 将查询的分组保存到request中

        request.setAttribute("category", category);


    }


    // 定义updatecategoryact处理分组修改

    public void updatecategoryact(HttpServletRequest request, Category category, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法CategoryController.updatecategoryact

        logger.debug("CategoryController.updatecategoryact ......");

        // 执行categorydao的updateByPrimaryKeySelective方法，将传入的分组数据同步到数据库中

        categorydao.updateByPrimaryKeySelective(category);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改分组信息成功");


    }


    // 定义deletecategory,处理删除分组

    public void deletecategory(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行CategoryService.deletecategory方法

        logger.debug("CategoryService.deletecategory ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化分组example
            CategoryExample example = new CategoryExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化分组criteria
            CategoryExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的分组id信息
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
            //调用分组的dao类，执行批量删除操作
            categorydao.deleteByExample(example);
        } else {
            // 根据id调用categorydao的deleteByPrimaryKey方法，删除分组


            categorydao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除分组成功");


    }


    // 定义searchcategory方法，处理搜索操作

    public void searchcategory(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行CategoryService.searchcategory

        logger.debug("CategoryService.searchcategory ......");


        // 实例化 CategoryExample

        CategoryExample example = new CategoryExample();

        // 实例化 CategoryExample的Criteria内部类

        CategoryExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andNameLike("%" + search + "%");

        }

        // 查询分组结果

        List categoryall = categorydao.selectByExample(example);

        // 将查询到的分组 保存到request中进行保存

        request.setAttribute("categoryall", categoryall);

    }


    // 定义CategorypinglunMapper

    public void categorydetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为CategoryController.categorydetails

        logger.debug("CategoryController.categorydetails ......");


        // 传入页面所传入的分组id使用categorydao的selectByPrimaryKey方法进行查询

        Category category = categorydao.selectByPrimaryKey(id);

        // 将查询到的分组保存到request中

        request.setAttribute("category", category);


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

