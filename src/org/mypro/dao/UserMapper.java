package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.User;
import org.mypro.entity.UserExample;

/**
 * 用户数据访问接口
 */
public interface UserMapper {
    /**
     * 根据条件统计用户数量
     *
     * @param example 用户示例
     * @return 用户数量
     */
    long countByExample(UserExample example);

    /**
     * 根据条件删除用户
     *
     * @param example 用户示例
     * @return 受影响的行数
     */
    int deleteByExample(UserExample example);

    /**
     * 根据用户ID删除用户
     *
     * @param id 用户ID
     * @return 受影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户信息
     *
     * @param record 用户信息
     * @return 受影响的行数
     */
    int insert(User record);

    /**
     * 选择性地插入用户信息
     *
     * @param record 用户信息
     * @return 受影响的行数
     */
    int insertSelective(User record);

    /**
     * 根据条件查询用户
     *
     * @param example 用户示例
     * @return 用户列表
     */
    List<User> selectByExample(UserExample example);

    /**
     * 根据用户ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据条件选择性地更新用户信息
     *
     * @param record  用户信息
     * @param example 用户示例
     * @return 受影响的行数
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * 根据条件更新用户信息
     *
     * @param record  用户信息
     * @param example 用户示例
     * @return 受影响的行数
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * 根据用户ID选择性地更新用户信息
     *
     * @param record 用户信息
     * @return 受影响的行数
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据用户ID更新用户信息
     *
     * @param record 用户信息
     * @return 受影响的行数
     */
    int updateByPrimaryKey(User record);
}
