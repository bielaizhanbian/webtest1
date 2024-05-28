package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Chat;
import org.mypro.entity.ChatExample;

/**
 * 聊天记录数据访问接口
 */
public interface ChatMapper {
    long countByExample(ChatExample example);

    int deleteByExample(ChatExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 插入聊天记录
     *
     * @param record 聊天记录实体
     * @return 影响的行数
     */
    int insert(Chat record);

    /**
     * 选择性地插入聊天记录
     *
     * @param record 聊天记录实体
     * @return 影响的行数
     */
    int insertSelective(Chat record);

    List<Chat> selectByExample(ChatExample example);

    Chat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Chat record, @Param("example") ChatExample example);

    int updateByExample(@Param("record") Chat record, @Param("example") ChatExample example);

    /**
     * 选择性地更新聊天记录
     *
     * @param record 聊天记录实体
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Chat record);

    /**
     * 更新聊天记录
     *
     * @param record 聊天记录实体
     * @return 影响的行数
     */
    int updateByPrimaryKey(Chat record);
}
