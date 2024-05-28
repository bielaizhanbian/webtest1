package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Admin;
import org.mypro.entity.AdminExample;

/**
 * 管理员数据访问接口
 */
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 插入管理员
     *
     * @param record 管理员实体
     * @return 影响的行数
     */
    int insert(Admin record);

    /**
     * 选择性地插入管理员
     *
     * @param record 管理员实体
     * @return 影响的行数
     */
    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * 选择性地更新管理员
     *
     * @param record 管理员实体
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * 更新管理员
     *
     * @param record 管理员实体
     * @return 影响的行数
     */
    int updateByPrimaryKey(Admin record);
}
