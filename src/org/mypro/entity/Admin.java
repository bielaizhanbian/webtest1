package org.mypro.entity;

// 管理员实体类
public class Admin {
    // 管理员ID
    private Integer id;

    // 管理员用户名
    private String username;

    // 管理员密码
    private String password;

    // 获取管理员ID
    public Integer getId() {
        return id;
    }

    // 设置管理员ID
    public void setId(Integer id) {
        this.id = id;
    }

    // 获取管理员用户名
    public String getUsername() {
        return username;
    }

    // 设置管理员用户名，去除首尾空格
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    // 获取管理员密码
    public String getPassword() {
        return password;
    }

    // 设置管理员密码，去除首尾空格
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
