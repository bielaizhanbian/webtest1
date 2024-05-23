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

import org.mypro.dao.FriendsMapper;

import org.mypro.entity.Friends;

import org.mypro.entity.FriendsExample;

import org.mypro.entity.*;
import org.mypro.dao.*;
import org.mypro.entity.User;

import org.mypro.entity.UserExample;

import org.mypro.dao.UserMapper;

import org.mypro.entity.Category;

import org.mypro.entity.CategoryExample;

import org.mypro.dao.CategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

@Service

public class FriendsService implements FriendsServiceImp {


    private static final Log logger = LogFactory.getLog(FriendsService.class);

    @Autowired
    private FriendsMapper friendsdao;
// 定义userdao参数  


    @Autowired
    private UserMapper userdao;
// 定义categorydao参数  


    @Autowired
    private CategoryMapper categorydao;


    //定义方法addfriends,响应控制层addfriends请求

    public void addfriends(HttpServletRequest request, HttpSession session) {

        //输出日志，当前执行方法为addfriends

        logger.debug("FriendsService.addfriends ......");

// 定义 example1为 UserExample的实例

        UserExample example1 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有好友数据

        List userall = userdao.selectByExample(example1);

        // 将上面查询到的好友数据保存到request中，返回页面

        request.setAttribute("userall", userall);

// 定义 example2为 CategoryExample的实例

        CategoryExample example2 = new CategoryExample();

// 定义categoryall的List使用 categorydao的selectByExample方法查询所有好友数据

        List categoryall = categorydao.selectByExample(example2);

        // 将上面查询到的好友数据保存到request中，返回页面

        request.setAttribute("categoryall", categoryall);


    }


    //定义addfriendsact方法

    public void addfriendsact(HttpServletRequest request, HttpSession session, Friends friends) throws IOException {

        //输出当前方法日志，表示正在执行FriendsService.addfriendsact方法

        logger.debug("FriendsService.addfriendsact ......");

        //使用friendsdao的insert方法将好友添加到数据库中

        friendsdao.insert(friends);


        //将添加好友信息添加到request中用message参数进行保存

        request.setAttribute("message", "添加好友成功");

    }


    //定义friendsmanage方法响应页面请求

    public void friendsmanage(HttpServletRequest request, HttpSession session) {

        //输出日志，表示当前正在执行FriendsService.friendsmanage

        logger.debug("FriendsService.friendsmanage ......");


        //实例化FriendsExample类为example

        FriendsExample example = new FriendsExample();


        //使用  friendsdao.selectByExample(example)方法获取所有的好友数据

        List friendsall = friendsdao.selectByExample(example);


        //将所有的好友数据保存到request中的friendsall参数里

        request.setAttribute("friendsall", friendsall);


    }


    // 定义 friendsview方法

    public void friendsview(HttpServletRequest request, HttpSession session) {

        // 输出日志，表示当前正在执行FriendsService.friendsview方法

        logger.debug("FriendsService.friendsview ......");


        // 实例化FriendsExample类

        FriendsExample example = new FriendsExample();


        // 使用friendsdao的selectByExample方法查询好友信息

        List friendsall = friendsdao.selectByExample(example);


        // 将查询的friendsall保存到request中，记录为参数friendsall

        request.setAttribute("friendsall", friendsall);


    }


    // 定义 updatefriends方法

    public void updatefriends(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志FriendsController.updatefriends，表示正在执行该方法

        logger.debug("FriendsController.updatefriends ......");


        // 定义好友为biaoming，使用 friendsdao的selectByPrimaryKey方法通过id查询数据

        Friends friends = friendsdao.selectByPrimaryKey(id);


// 定义 example1为 UserExample的实例

        UserExample example1 = new UserExample();

// 定义userall的List使用 userdao的selectByExample方法查询所有好友数据

        List userall = userdao.selectByExample(example1);

        // 将上面查询到的好友数据保存到request中，返回页面

        request.setAttribute("userall", userall);

// 定义 example2为 CategoryExample的实例

        CategoryExample example2 = new CategoryExample();

// 定义categoryall的List使用 categorydao的selectByExample方法查询所有好友数据

        List categoryall = categorydao.selectByExample(example2);

        // 将上面查询到的好友数据保存到request中，返回页面

        request.setAttribute("categoryall", categoryall);


        // 将查询的好友保存到request中

        request.setAttribute("friends", friends);


    }


    // 定义updatefriendsact处理好友修改

    public void updatefriendsact(HttpServletRequest request, Friends friends, HttpSession session) throws IOException {

        // 输出日志，表示正在执行当前方法FriendsController.updatefriendsact

        logger.debug("FriendsController.updatefriendsact ......");

        // 执行friendsdao的updateByPrimaryKeySelective方法，将传入的好友数据同步到数据库中

        friendsdao.updateByPrimaryKeySelective(friends);


        // 将修改成功信息保存到request中

        request.setAttribute("message", "修改好友信息成功");


    }


    // 定义deletefriends,处理删除好友

    public void deletefriends(HttpServletRequest request, HttpSession session, int id) {

        // 输出日志，表示当前正在执行FriendsService.deletefriends方法

        logger.debug("FriendsService.deletefriends ......");

        //如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            //实例化好友example
            FriendsExample example = new FriendsExample();
            //获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            //为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            //截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            //设置where语句进行删除id数据的传入
            //example.setWhere("id in ("+ ids +")");
            //实例化好友criteria
            FriendsExample.Criteria criteria = example.createCriteria();
            //设置integer类型的数组，保存需要删除的好友id信息
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
            //调用好友的dao类，执行批量删除操作
            friendsdao.deleteByExample(example);
        } else {
            // 根据id调用friendsdao的deleteByPrimaryKey方法，删除好友


            friendsdao.deleteByPrimaryKey(id);

        }


        request.setAttribute("message", "删除好友成功");


    }


    // 定义searchfriends方法，处理搜索操作

    public void searchfriends(HttpServletRequest request, HttpSession session, String search) {

        // 输出日志，表示当前正在执行FriendsService.searchfriends

        logger.debug("FriendsService.searchfriends ......");


        // 实例化 FriendsExample

        FriendsExample example = new FriendsExample();

        // 实例化 FriendsExample的Criteria内部类

        FriendsExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空

        if (search != null) {

            // 将搜索内容通过like关键字传到数据库中进行搜索

            criteria.andUserLike("%" + search + "%");

        }

        // 查询好友结果

        List friendsall = friendsdao.selectByExample(example);

        // 将查询到的好友 保存到request中进行保存

        request.setAttribute("friendsall", friendsall);

    }


    // 定义FriendspinglunMapper

    public void friendsdetails(HttpServletRequest request, HttpSession session, int id) {

        // 输入日志信息，表名当前执行方法为FriendsController.friendsdetails

        logger.debug("FriendsController.friendsdetails ......");


        // 传入页面所传入的好友id使用friendsdao的selectByPrimaryKey方法进行查询

        Friends friends = friendsdao.selectByPrimaryKey(id);

        // 将查询到的好友保存到request中

        request.setAttribute("friends", friends);


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

