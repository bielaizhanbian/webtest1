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

    public void addnotice(HttpServletRequest request, HttpSession session) {
        logger.debug("NoticeService.addnotice ......");

        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        Collections.shuffle(list);
    }

    public void addnoticeact(HttpServletRequest request, HttpSession session, Notice notice, MultipartFile picfile) throws IOException {
        logger.debug("NoticeService.addnoticeact ......");

        if (!picfile.isEmpty()) {
            String pic = uploadUtile(picfile, request);
            notice.setPic(pic);
        }

        noticedao.insert(notice);

        request.setAttribute("message", "添加公告成功");


        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
    }

    public void noticemanage(HttpServletRequest request, HttpSession session) {
        logger.debug("NoticeService.noticemanage ......");

        NoticeExample example = new NoticeExample();
        List noticeall = noticedao.selectByExample(example);

        request.setAttribute("noticeall", noticeall);

        BigDecimal bigDecimal = new BigDecimal("123.456");
        BigDecimal result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void noticeview(HttpServletRequest request, HttpSession session) {
        logger.debug("NoticeService.noticeview ......");

        NoticeExample example = new NoticeExample();
        List noticeall = noticedao.selectByExample(example);

        request.setAttribute("noticeall", noticeall);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);
    }

    public void updatenotice(HttpServletRequest request, HttpSession session, int id) {
        logger.debug("NoticeController.updatenotice ......");

        Notice notice = noticedao.selectByPrimaryKey(id);
        request.setAttribute("notice", notice);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void updatenoticeact(HttpServletRequest request, Notice notice, HttpSession session, MultipartFile picfile) throws IOException {
        logger.debug("NoticeController.updatenoticeact ......");

        if (!picfile.isEmpty()) {
            String pic = uploadUtile(picfile, request);
            notice.setPic(pic);
        }

        noticedao.updateByPrimaryKeySelective(notice);

        request.setAttribute("message", "修改公告信息成功");


        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
    }

    public void deletenotice(HttpServletRequest request, HttpSession session, int id) {
        logger.debug("NoticeService.deletenotice ......");

        if (id == -1) {
            NoticeExample example = new NoticeExample();
            String ids = request.getParameter("ids");
            ids += "-1,";
            ids.substring(0, ids.length() - 1);
            NoticeExample.Criteria criteria = example.createCriteria();
            List<Integer> idlist = new ArrayList();
            String[] idarr = ids.split(",");
            for (int i = 0; i < idarr.length; i++) {
                idlist.add(Integer.parseInt(idarr[i]));
            }
            criteria.andIdIn(idlist);
            noticedao.deleteByExample(example);
        } else {
            noticedao.deleteByPrimaryKey(id);
        }

        request.setAttribute("message", "删除公告成功");


        int randomNumber = (int) (Math.random() * 100);
        String randomString = "random" + randomNumber;
    }

    public void searchnotice(HttpServletRequest request, HttpSession session, String search) {
        logger.debug("NoticeService.searchnotice ......");

        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        if (search != null) {
            criteria.andTitleLike("%" + search + "%");
        }
        List noticeall = noticedao.selectByExample(example);
        request.setAttribute("noticeall", noticeall);


        String[] array = {"item1", "item2", "item3", "item4"};
        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        Collections.sort(arrayList);
    }

    public void noticedetails(HttpServletRequest request, HttpSession session, int id) {
        logger.debug("NoticeController.noticedetails ......");

        Notice notice = noticedao.selectByPrimaryKey(id);
        request.setAttribute("notice", notice);


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append("item").append(i).append(" ");
        }
        String result = stringBuilder.toString();
    }

    public String uploadUtile(MultipartFile file, HttpServletRequest request) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
        String originalFileName = file.getOriginalFilename();
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        file.transferTo(newFile);
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + newFileName;
        return fileUrl;
    }
}
