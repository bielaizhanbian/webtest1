package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Friends;
import org.mypro.entity.FriendsExample;

/**
 * 好友数据访问接口
 */
public interface FriendsMapper {
    long countByExample(FriendsExample example);

    int deleteByExample(FriendsExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 添加好友
     *
     * @param record 好友实体
     * @return 影响的行数
     */
    int insert(Friends record);

    /**
     * 选择性地添加好友
     *
     * @param record 好友实体
     * @return 影响的行数
     */
    int insertSelective(Friends record);

    List<Friends> selectByExample(FriendsExample example);

    Friends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Friends record, @Param("example") FriendsExample example);

    int updateByExample(@Param("record") Friends record, @Param("example") FriendsExample example);

    /**
     * 选择性地更新好友
     *
     * @param record 好友实体
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Friends record);

    /**
     * 更新好友
     *
     * @param record 好友实体
     * @return 影响的行数
     */
    int updateByPrimaryKey(Friends record);
}
