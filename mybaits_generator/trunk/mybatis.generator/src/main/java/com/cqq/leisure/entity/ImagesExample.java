package com.cqq.leisure.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImagesExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public ImagesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andImagesIdIsNull() {
            addCriterion("IMAGES_ID is null");
            return (Criteria) this;
        }

        public Criteria andImagesIdIsNotNull() {
            addCriterion("IMAGES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andImagesIdEqualTo(Integer value) {
            addCriterion("IMAGES_ID =", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotEqualTo(Integer value) {
            addCriterion("IMAGES_ID <>", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdGreaterThan(Integer value) {
            addCriterion("IMAGES_ID >", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("IMAGES_ID >=", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdLessThan(Integer value) {
            addCriterion("IMAGES_ID <", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdLessThanOrEqualTo(Integer value) {
            addCriterion("IMAGES_ID <=", value, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdIn(List<Integer> values) {
            addCriterion("IMAGES_ID in", values, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotIn(List<Integer> values) {
            addCriterion("IMAGES_ID not in", values, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdBetween(Integer value1, Integer value2) {
            addCriterion("IMAGES_ID between", value1, value2, "imagesId");
            return (Criteria) this;
        }

        public Criteria andImagesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("IMAGES_ID not between", value1, value2, "imagesId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdIsNull() {
            addCriterion("HOLIDAY_PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdIsNotNull() {
            addCriterion("HOLIDAY_PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdEqualTo(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID =", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdNotEqualTo(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID <>", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdGreaterThan(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID >", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID >=", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdLessThan(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID <", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAY_PLAN_ID <=", value, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdIn(List<Integer> values) {
            addCriterion("HOLIDAY_PLAN_ID in", values, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdNotIn(List<Integer> values) {
            addCriterion("HOLIDAY_PLAN_ID not in", values, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAY_PLAN_ID between", value1, value2, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andHolidayPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAY_PLAN_ID not between", value1, value2, "holidayPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdIsNull() {
            addCriterion("PROGRAM_PLAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdIsNotNull() {
            addCriterion("PROGRAM_PLAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdEqualTo(Integer value) {
            addCriterion("PROGRAM_PLAN_ID =", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdNotEqualTo(Integer value) {
            addCriterion("PROGRAM_PLAN_ID <>", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdGreaterThan(Integer value) {
            addCriterion("PROGRAM_PLAN_ID >", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROGRAM_PLAN_ID >=", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdLessThan(Integer value) {
            addCriterion("PROGRAM_PLAN_ID <", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROGRAM_PLAN_ID <=", value, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdIn(List<Integer> values) {
            addCriterion("PROGRAM_PLAN_ID in", values, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdNotIn(List<Integer> values) {
            addCriterion("PROGRAM_PLAN_ID not in", values, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("PROGRAM_PLAN_ID between", value1, value2, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andProgramPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROGRAM_PLAN_ID not between", value1, value2, "programPlanId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNull() {
            addCriterion("ACTIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("ACTIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(Integer value) {
            addCriterion("ACTIVE_ID =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(Integer value) {
            addCriterion("ACTIVE_ID <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(Integer value) {
            addCriterion("ACTIVE_ID >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTIVE_ID >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(Integer value) {
            addCriterion("ACTIVE_ID <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("ACTIVE_ID <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<Integer> values) {
            addCriterion("ACTIVE_ID in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<Integer> values) {
            addCriterion("ACTIVE_ID not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("ACTIVE_ID between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTIVE_ID not between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andImagesDescIsNull() {
            addCriterion("IMAGES_DESC is null");
            return (Criteria) this;
        }

        public Criteria andImagesDescIsNotNull() {
            addCriterion("IMAGES_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andImagesDescEqualTo(String value) {
            addCriterion("IMAGES_DESC =", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescNotEqualTo(String value) {
            addCriterion("IMAGES_DESC <>", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescGreaterThan(String value) {
            addCriterion("IMAGES_DESC >", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGES_DESC >=", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescLessThan(String value) {
            addCriterion("IMAGES_DESC <", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescLessThanOrEqualTo(String value) {
            addCriterion("IMAGES_DESC <=", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescLike(String value) {
            addCriterion("IMAGES_DESC like", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescNotLike(String value) {
            addCriterion("IMAGES_DESC not like", value, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescIn(List<String> values) {
            addCriterion("IMAGES_DESC in", values, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescNotIn(List<String> values) {
            addCriterion("IMAGES_DESC not in", values, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescBetween(String value1, String value2) {
            addCriterion("IMAGES_DESC between", value1, value2, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesDescNotBetween(String value1, String value2) {
            addCriterion("IMAGES_DESC not between", value1, value2, "imagesDesc");
            return (Criteria) this;
        }

        public Criteria andImagesUrlIsNull() {
            addCriterion("IMAGES_URL is null");
            return (Criteria) this;
        }

        public Criteria andImagesUrlIsNotNull() {
            addCriterion("IMAGES_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImagesUrlEqualTo(String value) {
            addCriterion("IMAGES_URL =", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlNotEqualTo(String value) {
            addCriterion("IMAGES_URL <>", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlGreaterThan(String value) {
            addCriterion("IMAGES_URL >", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGES_URL >=", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlLessThan(String value) {
            addCriterion("IMAGES_URL <", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlLessThanOrEqualTo(String value) {
            addCriterion("IMAGES_URL <=", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlLike(String value) {
            addCriterion("IMAGES_URL like", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlNotLike(String value) {
            addCriterion("IMAGES_URL not like", value, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlIn(List<String> values) {
            addCriterion("IMAGES_URL in", values, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlNotIn(List<String> values) {
            addCriterion("IMAGES_URL not in", values, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlBetween(String value1, String value2) {
            addCriterion("IMAGES_URL between", value1, value2, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesUrlNotBetween(String value1, String value2) {
            addCriterion("IMAGES_URL not between", value1, value2, "imagesUrl");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentIsNull() {
            addCriterion("IMAGES_SUF_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentIsNotNull() {
            addCriterion("IMAGES_SUF_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentEqualTo(String value) {
            addCriterion("IMAGES_SUF_CONTENT =", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentNotEqualTo(String value) {
            addCriterion("IMAGES_SUF_CONTENT <>", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentGreaterThan(String value) {
            addCriterion("IMAGES_SUF_CONTENT >", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGES_SUF_CONTENT >=", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentLessThan(String value) {
            addCriterion("IMAGES_SUF_CONTENT <", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentLessThanOrEqualTo(String value) {
            addCriterion("IMAGES_SUF_CONTENT <=", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentLike(String value) {
            addCriterion("IMAGES_SUF_CONTENT like", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentNotLike(String value) {
            addCriterion("IMAGES_SUF_CONTENT not like", value, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentIn(List<String> values) {
            addCriterion("IMAGES_SUF_CONTENT in", values, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentNotIn(List<String> values) {
            addCriterion("IMAGES_SUF_CONTENT not in", values, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentBetween(String value1, String value2) {
            addCriterion("IMAGES_SUF_CONTENT between", value1, value2, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesSufContentNotBetween(String value1, String value2) {
            addCriterion("IMAGES_SUF_CONTENT not between", value1, value2, "imagesSufContent");
            return (Criteria) this;
        }

        public Criteria andImagesStateIsNull() {
            addCriterion("IMAGES_STATE is null");
            return (Criteria) this;
        }

        public Criteria andImagesStateIsNotNull() {
            addCriterion("IMAGES_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andImagesStateEqualTo(Integer value) {
            addCriterion("IMAGES_STATE =", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateNotEqualTo(Integer value) {
            addCriterion("IMAGES_STATE <>", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateGreaterThan(Integer value) {
            addCriterion("IMAGES_STATE >", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("IMAGES_STATE >=", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateLessThan(Integer value) {
            addCriterion("IMAGES_STATE <", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateLessThanOrEqualTo(Integer value) {
            addCriterion("IMAGES_STATE <=", value, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateIn(List<Integer> values) {
            addCriterion("IMAGES_STATE in", values, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateNotIn(List<Integer> values) {
            addCriterion("IMAGES_STATE not in", values, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateBetween(Integer value1, Integer value2) {
            addCriterion("IMAGES_STATE between", value1, value2, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesStateNotBetween(Integer value1, Integer value2) {
            addCriterion("IMAGES_STATE not between", value1, value2, "imagesState");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeIsNull() {
            addCriterion("IMAGES_CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeIsNotNull() {
            addCriterion("IMAGES_CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeEqualTo(Date value) {
            addCriterion("IMAGES_CREATE_TIME =", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeNotEqualTo(Date value) {
            addCriterion("IMAGES_CREATE_TIME <>", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeGreaterThan(Date value) {
            addCriterion("IMAGES_CREATE_TIME >", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("IMAGES_CREATE_TIME >=", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeLessThan(Date value) {
            addCriterion("IMAGES_CREATE_TIME <", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("IMAGES_CREATE_TIME <=", value, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeIn(List<Date> values) {
            addCriterion("IMAGES_CREATE_TIME in", values, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeNotIn(List<Date> values) {
            addCriterion("IMAGES_CREATE_TIME not in", values, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeBetween(Date value1, Date value2) {
            addCriterion("IMAGES_CREATE_TIME between", value1, value2, "imagesCreateTime");
            return (Criteria) this;
        }

        public Criteria andImagesCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("IMAGES_CREATE_TIME not between", value1, value2, "imagesCreateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table images
     *
     * @mbggenerated do_not_delete_during_merge Sun Mar 20 15:59:59 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table images
     *
     * @mbggenerated Sun Mar 20 15:59:59 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}