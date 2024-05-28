package org.mypro.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * 表操作数据访问接口
 */
public interface TableMapper {

    /**
     * 执行SQL查询返回数据列表
     *
     * @param sql SQL查询语句
     * @return 数据列表
     */
    List<Map> keshihuashuju(@Param("sql") String sql);

    /**
     * 判断表中是否存在重复记录
     *
     * @param table   表名
     * @param ziduan  字段名
     * @param neirong 字段内容
     * @return 重复记录的数量
     */
    Long shifouchongfu(@Param("table") String table, @Param("ziduan") String ziduan, @Param("neirong") String neirong);

    /**
     * 执行SQL添加操作
     *
     * @param sql SQL添加语句
     */
    void executeadd(@Param("sql") String sql);

    /**
     * 执行SQL查询操作返回数据列表
     *
     * @param sql SQL查询语句
     * @return 数据列表
     */
    List<Map> executequery(@Param("sql") String sql);

    /**
     * 执行SQL查询操作返回单条数据
     *
     * @param sql SQL查询语句
     * @return 单条数据
     */
    Map queryone(@Param("sql") String sql);
}
