package com.cqq.leisure.dao;

import com.cqq.leisure.entity.Images;
import com.cqq.leisure.entity.ImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int countByExample(ImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int deleteByExample(ImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int deleteByPrimaryKey(Integer imagesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int insert(Images record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int insertSelective(Images record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    List<Images> selectByExample(ImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    Images selectByPrimaryKey(Integer imagesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByExample(@Param("record") Images record, @Param("example") ImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByPrimaryKeySelective(Images record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByPrimaryKey(Images record);
}