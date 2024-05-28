package org.mypro.entity;

/**
 * 类别实体类
 */
public class Category {
    private Integer id; // 类别ID

    private String name; // 类别名称

    /**
     * 获取类别ID
     *
     * @return 类别ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类别ID
     *
     * @param id 类别ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类别名称
     *
     * @return 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类别名称
     *
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
