package org.mypro.entity;

/**
 * 好友实体类
 */
public class Friends {
    private Integer id; // 好友ID

    private String user; // 用户

    private Integer userid; // 用户ID

    private String mingzi; // 名字

    private String category; // 类别

    private Integer categoryid; // 类别ID

    private String state; // 状态

    /**
     * 获取好友ID
     *
     * @return 好友ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置好友ID
     *
     * @param id 好友ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMingzi() {
        return mingzi;
    }

    public void setMingzi(String mingzi) {
        this.mingzi = mingzi == null ? null : mingzi.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}