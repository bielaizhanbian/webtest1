package org.mypro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mypro.entity.Category;
import org.mypro.entity.CategoryExample;

/**
 * 类别数据访问接口
 */
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    /**
     * 插入类别
     *
     * @param record 类别实体
     * @return 影响的行数
     */
    int insert(Category record);

    /**
     * 选择性地插入类别
     *
     * @param record 类别实体
     * @return 影响的行数
     */
    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * 选择性地更新类别
     *
     * @param record 类别实体
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * 更新类别
     *
     * @param record 类别实体
     * @return 影响的行数
     */
    int updateByPrimaryKey(Category record);
}
