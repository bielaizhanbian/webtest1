package org.mypro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TableMapper {

    List<Map> keshihuashuju(@Param("sql") String sql);


    Long shifouchongfu(@Param("table") String table, @Param("ziduan") String ziduan, @Param("neirong") String neirong);

    void executeadd(@Param("sql") String sql);

    List<Map> executequery(@Param("sql") String sql);

    Map queryone(@Param("sql") String sql);

}