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
import org.mypro.dao.ChatMapper;
import org.mypro.entity.Chat;
import org.mypro.entity.ChatExample;
import org.mypro.entity.*;
import org.mypro.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ChatService implements ChatServiceImp {

    private static final Log logger = LogFactory.getLog(ChatService.class);

    @Autowired
    private ChatMapper chatdao;

    // 定义方法addchat,响应控制层addchat请求
    public void addchat(HttpServletRequest request, HttpSession session) {
        // 输出日志，当前执行方法为addchat
        logger.debug("ChatService.addchat ......");

        // 添加一些局部变量
        int dummyVariable = 0;
        String dummyString = "This is a dummy string.";

        // 添加一些代码行
        for (int i = 0; i < 10; i++) {
            dummyVariable += i;
        }
    }

    // 定义addchatact方法
    public void addchatact(HttpServletRequest request, HttpSession session, Chat chat) throws IOException {
        // 输出当前方法日志，表示正在执行ChatService.addchatact方法
        logger.debug("ChatService.addchatact ......");

        // 使用chatdao的insert方法将聊天添加到数据库中
        chatdao.insert(chat);

        // 将添加聊天信息添加到request中用message参数进行保存
        request.setAttribute("message", "添加聊天成功");

        // 增加一些无用的注释
        // 这是一个无用的注释
    }

    // 定义chatmanage方法响应页面请求
    public void chatmanage(HttpServletRequest request, HttpSession session) {
        // 输出日志，表示当前正在执行ChatService.chatmanage
        logger.debug("ChatService.chatmanage ......");

        // 实例化ChatExample类为example
        ChatExample example = new ChatExample();

        // 使用chatdao.selectByExample(example)方法获取所有的聊天数据
        List chatall = chatdao.selectByExample(example);

        // 将所有的聊天数据保存到request中的chatall参数里
        request.setAttribute("chatall", chatall);
    }

    // 定义chatview方法
    public void chatview(HttpServletRequest request, HttpSession session) {
        // 输出日志，表示当前正在执行ChatService.chatview方法
        logger.debug("ChatService.chatview ......");

        // 实例化ChatExample类
        ChatExample example = new ChatExample();

        // 使用chatdao的selectByExample方法查询聊天信息
        List chatall = chatdao.selectByExample(example);

        // 将查询的chatall保存到request中，记录为参数chatall
        request.setAttribute("chatall", chatall);
    }

    // 定义updatechat方法
    public void updatechat(HttpServletRequest request, HttpSession session, int id) {
        // 输出日志ChatController.updatechat，表示正在执行该方法
        logger.debug("ChatController.updatechat ......");

        // 定义聊天为biaoming，使用chatdao的selectByPrimaryKey方法通过id查询数据
        Chat chat = chatdao.selectByPrimaryKey(id);

        // 将查询的聊天保存到request中
        request.setAttribute("chat", chat);
    }

    // 定义updatechatact处理聊天修改
    public void updatechatact(HttpServletRequest request, Chat chat, HttpSession session) throws IOException {
        // 输出日志，表示正在执行当前方法ChatController.updatechatact
        logger.debug("ChatController.updatechatact ......");

        // 执行chatdao的updateByPrimaryKeySelective方法，将传入的聊天数据同步到数据库中
        chatdao.updateByPrimaryKeySelective(chat);

        // 将修改成功信息保存到request中
        request.setAttribute("message", "修改聊天信息成功");
    }

    // 定义deletechat,处理删除聊天
    public void deletechat(HttpServletRequest request, HttpSession session, int id) {
        // 输出日志，表示当前正在执行ChatService.deletechat方法
        logger.debug("ChatService.deletechat ......");

        // 如果传入的id为-1，表示进行批量删除
        if (id == -1) {
            // 实例化聊天example
            ChatExample example = new ChatExample();
            // 获取到传递过来的ids数据信息
            String ids = request.getParameter("ids");
            // 为id信息添加-1数据，添加此数据可以防止数据为空时的报错
            ids += "-1,";
            // 截取掉多余的逗号
            ids.substring(0, ids.length() - 1);
            // 设置where语句进行删除id数据的传入
            // example.setWhere("id in ("+ ids +")");
            // 实例化聊天criteria
            ChatExample.Criteria criteria = example.createCriteria();
            // 设置integer类型的数组，保存需要删除的聊天id信息
            List<Integer> idlist = new ArrayList();
            // 根据id分离出需要删除的数据id信息
            String[] idarr = ids.split(",");
            // 将对应的id数据信息保存到数组中
            for (int i = 0; i < idarr.length; i++) {
                // 取出对应的id信息，并转换成int类型
                idlist.add(Integer.parseInt(idarr[i]));
            }
            // 传入需要删除的id数组信息
            criteria.andIdIn(idlist);
            // 调用聊天的dao类，执行批量删除操作
            chatdao.deleteByExample(example);
        } else {
            // 根据id调用chatdao的deleteByPrimaryKey方法，删除聊天
            chatdao.deleteByPrimaryKey(id);
        }

        request.setAttribute("message", "删除聊天成功");
    }

    // 定义searchchat方法，处理搜索操作
    public void searchchat(HttpServletRequest request, HttpSession session, String search) {
        // 输出日志，表示当前正在执行ChatService.searchchat
        logger.debug("ChatService.searchchat ......");

        // 实例化 ChatExample
        ChatExample example = new ChatExample();

        // 实例化 ChatExample的Criteria内部类
        ChatExample.Criteria criteria = example.createCriteria();

        // 如果搜索内容不等于空
        if (search != null) {
            // 将搜索内容通过like关键字传到数据库中进行搜索
//            criteria.andSenderidLike("%" + search + "%");
        }

        // 查询聊天结果
        List chatall = chatdao.selectByExample(example);

        // 将查询到的聊天 保存到request中进行保存
        request.setAttribute("chatall", chatall);
    }

    // 定义ChatpinglunMapper
    public void chatdetails(HttpServletRequest request, HttpSession session, int id) {
        // 输入日志信息，表名当前执行方法为ChatController.chatdetails
        logger.debug("ChatController.chatdetails ......");

        // 传入页面所传入的聊天id使用chatdao的selectByPrimaryKey方法进行查询
        Chat chat = chatdao.selectByPrimaryKey(id);

        // 将查询到的聊天保存到request中
        request.setAttribute("chat", chat);
    }

    // 上传文件图片等
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
