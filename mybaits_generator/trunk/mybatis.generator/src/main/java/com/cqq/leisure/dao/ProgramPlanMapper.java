package com.cqq.leisure.dao;

import com.cqq.leisure.entity.ProgramPlan;
import com.cqq.leisure.entity.ProgramPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProgramPlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int countByExample(ProgramPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int deleteByExample(ProgramPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int deleteByPrimaryKey(Integer programPlanId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int insert(ProgramPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int insertSelective(ProgramPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    List<ProgramPlan> selectByExample(ProgramPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    ProgramPlan selectByPrimaryKey(Integer programPlanId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProgramPlan record, @Param("example") ProgramPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByExample(@Param("record") ProgramPlan record, @Param("example") ProgramPlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByPrimaryKeySelective(ProgramPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table program_plan
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    int updateByPrimaryKey(ProgramPlan record);
}