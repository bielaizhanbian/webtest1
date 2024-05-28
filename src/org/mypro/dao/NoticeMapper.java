package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Notice;
import org.mypro.entity.NoticeExample;

/**
 * 通知数据访问接口
 */
public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 添加通知
     *
     * @param record 通知实体
     * @return 影响的行数
     */
    int insert(Notice record);

    /**
     * 选择性地添加通知
     *
     * @param record 通知实体
     * @return 影响的行数
     */
    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    /**
     * 选择性地更新通知
     *
     * @param record 通知实体
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Notice record);

    /**
     * 更新通知
     *
     * @param record 通知实体
     * @return 影响的行数
     */
    int updateByPrimaryKey(Notice record);
}
