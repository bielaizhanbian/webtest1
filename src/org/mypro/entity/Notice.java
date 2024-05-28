package org.mypro.entity;

/**
 * 公告实体类
 */
public class Notice {
    private Integer id; // 公告ID

    private String title; // 标题

    private String pic; // 图片

    private String comtent; // 内容

    private String addtime; // 添加时间

    private String publisher; // 发布者

    /**
     * 获取公告ID
     *
     * @return 公告ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置公告ID
     *
     * @param id 公告ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getComtent() {
        return comtent;
    }

    public void setComtent(String comtent) {
        this.comtent = comtent == null ? null : comtent.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }
}