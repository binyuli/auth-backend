package bz.sunlight.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table role
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table role
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table role
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  private Integer limit;

  private Integer offset;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public RoleExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public Criteria or() {
    Criteria criteria = createCriteriaInternal();
    oredCriteria.add(criteria);
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
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
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table role
   *
   * @mbggenerated
   */
  public void clear() {
    oredCriteria.clear();
    orderByClause = null;
    distinct = false;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getOffset() {
    return offset;
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table role
   *
   * @mbggenerated
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

    public Criteria andIdIsNull() {
      addCriterion("id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("id like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("id not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("name is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("name is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("name =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("name <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("name >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("name >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("name <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("name <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("name like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("name not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("name in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("name not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("name between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("name not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andCreatorIdIsNull() {
      addCriterion("creator_id is null");
      return (Criteria) this;
    }

    public Criteria andCreatorIdIsNotNull() {
      addCriterion("creator_id is not null");
      return (Criteria) this;
    }

    public Criteria andCreatorIdEqualTo(String value) {
      addCriterion("creator_id =", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdNotEqualTo(String value) {
      addCriterion("creator_id <>", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdGreaterThan(String value) {
      addCriterion("creator_id >", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdGreaterThanOrEqualTo(String value) {
      addCriterion("creator_id >=", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdLessThan(String value) {
      addCriterion("creator_id <", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdLessThanOrEqualTo(String value) {
      addCriterion("creator_id <=", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdLike(String value) {
      addCriterion("creator_id like", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdNotLike(String value) {
      addCriterion("creator_id not like", value, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdIn(List<String> values) {
      addCriterion("creator_id in", values, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdNotIn(List<String> values) {
      addCriterion("creator_id not in", values, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdBetween(String value1, String value2) {
      addCriterion("creator_id between", value1, value2, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorIdNotBetween(String value1, String value2) {
      addCriterion("creator_id not between", value1, value2, "creatorId");
      return (Criteria) this;
    }

    public Criteria andCreatorNameIsNull() {
      addCriterion("creator_name is null");
      return (Criteria) this;
    }

    public Criteria andCreatorNameIsNotNull() {
      addCriterion("creator_name is not null");
      return (Criteria) this;
    }

    public Criteria andCreatorNameEqualTo(String value) {
      addCriterion("creator_name =", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameNotEqualTo(String value) {
      addCriterion("creator_name <>", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameGreaterThan(String value) {
      addCriterion("creator_name >", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameGreaterThanOrEqualTo(String value) {
      addCriterion("creator_name >=", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameLessThan(String value) {
      addCriterion("creator_name <", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameLessThanOrEqualTo(String value) {
      addCriterion("creator_name <=", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameLike(String value) {
      addCriterion("creator_name like", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameNotLike(String value) {
      addCriterion("creator_name not like", value, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameIn(List<String> values) {
      addCriterion("creator_name in", values, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameNotIn(List<String> values) {
      addCriterion("creator_name not in", values, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameBetween(String value1, String value2) {
      addCriterion("creator_name between", value1, value2, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreatorNameNotBetween(String value1, String value2) {
      addCriterion("creator_name not between", value1, value2, "creatorName");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNull() {
      addCriterion("create_time is null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIsNotNull() {
      addCriterion("create_time is not null");
      return (Criteria) this;
    }

    public Criteria andCreateTimeEqualTo(Date value) {
      addCriterion("create_time =", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotEqualTo(Date value) {
      addCriterion("create_time <>", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThan(Date value) {
      addCriterion("create_time >", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("create_time >=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThan(Date value) {
      addCriterion("create_time <", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
      addCriterion("create_time <=", value, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeIn(List<Date> values) {
      addCriterion("create_time in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotIn(List<Date> values) {
      addCriterion("create_time not in", values, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeBetween(Date value1, Date value2) {
      addCriterion("create_time between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
      addCriterion("create_time not between", value1, value2, "createTime");
      return (Criteria) this;
    }

    public Criteria andModifierIdIsNull() {
      addCriterion("modifier_id is null");
      return (Criteria) this;
    }

    public Criteria andModifierIdIsNotNull() {
      addCriterion("modifier_id is not null");
      return (Criteria) this;
    }

    public Criteria andModifierIdEqualTo(String value) {
      addCriterion("modifier_id =", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdNotEqualTo(String value) {
      addCriterion("modifier_id <>", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdGreaterThan(String value) {
      addCriterion("modifier_id >", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdGreaterThanOrEqualTo(String value) {
      addCriterion("modifier_id >=", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdLessThan(String value) {
      addCriterion("modifier_id <", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdLessThanOrEqualTo(String value) {
      addCriterion("modifier_id <=", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdLike(String value) {
      addCriterion("modifier_id like", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdNotLike(String value) {
      addCriterion("modifier_id not like", value, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdIn(List<String> values) {
      addCriterion("modifier_id in", values, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdNotIn(List<String> values) {
      addCriterion("modifier_id not in", values, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdBetween(String value1, String value2) {
      addCriterion("modifier_id between", value1, value2, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierIdNotBetween(String value1, String value2) {
      addCriterion("modifier_id not between", value1, value2, "modifierId");
      return (Criteria) this;
    }

    public Criteria andModifierNameIsNull() {
      addCriterion("modifier_name is null");
      return (Criteria) this;
    }

    public Criteria andModifierNameIsNotNull() {
      addCriterion("modifier_name is not null");
      return (Criteria) this;
    }

    public Criteria andModifierNameEqualTo(String value) {
      addCriterion("modifier_name =", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameNotEqualTo(String value) {
      addCriterion("modifier_name <>", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameGreaterThan(String value) {
      addCriterion("modifier_name >", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameGreaterThanOrEqualTo(String value) {
      addCriterion("modifier_name >=", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameLessThan(String value) {
      addCriterion("modifier_name <", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameLessThanOrEqualTo(String value) {
      addCriterion("modifier_name <=", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameLike(String value) {
      addCriterion("modifier_name like", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameNotLike(String value) {
      addCriterion("modifier_name not like", value, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameIn(List<String> values) {
      addCriterion("modifier_name in", values, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameNotIn(List<String> values) {
      addCriterion("modifier_name not in", values, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameBetween(String value1, String value2) {
      addCriterion("modifier_name between", value1, value2, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifierNameNotBetween(String value1, String value2) {
      addCriterion("modifier_name not between", value1, value2, "modifierName");
      return (Criteria) this;
    }

    public Criteria andModifyTimeIsNull() {
      addCriterion("modify_time is null");
      return (Criteria) this;
    }

    public Criteria andModifyTimeIsNotNull() {
      addCriterion("modify_time is not null");
      return (Criteria) this;
    }

    public Criteria andModifyTimeEqualTo(Date value) {
      addCriterion("modify_time =", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeNotEqualTo(Date value) {
      addCriterion("modify_time <>", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeGreaterThan(Date value) {
      addCriterion("modify_time >", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("modify_time >=", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeLessThan(Date value) {
      addCriterion("modify_time <", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
      addCriterion("modify_time <=", value, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeIn(List<Date> values) {
      addCriterion("modify_time in", values, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeNotIn(List<Date> values) {
      addCriterion("modify_time not in", values, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeBetween(Date value1, Date value2) {
      addCriterion("modify_time between", value1, value2, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
      addCriterion("modify_time not between", value1, value2, "modifyTime");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIsNull() {
      addCriterion("enterprise_id is null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIsNotNull() {
      addCriterion("enterprise_id is not null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdEqualTo(String value) {
      addCriterion("enterprise_id =", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotEqualTo(String value) {
      addCriterion("enterprise_id <>", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdGreaterThan(String value) {
      addCriterion("enterprise_id >", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
      addCriterion("enterprise_id >=", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLessThan(String value) {
      addCriterion("enterprise_id <", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
      addCriterion("enterprise_id <=", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLike(String value) {
      addCriterion("enterprise_id like", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotLike(String value) {
      addCriterion("enterprise_id not like", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIn(List<String> values) {
      addCriterion("enterprise_id in", values, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotIn(List<String> values) {
      addCriterion("enterprise_id not in", values, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdBetween(String value1, String value2) {
      addCriterion("enterprise_id between", value1, value2, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
      addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andStatusIsNull() {
      addCriterion("status is null");
      return (Criteria) this;
    }

    public Criteria andStatusIsNotNull() {
      addCriterion("status is not null");
      return (Criteria) this;
    }

    public Criteria andStatusEqualTo(Integer value) {
      addCriterion("status =", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotEqualTo(Integer value) {
      addCriterion("status <>", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThan(Integer value) {
      addCriterion("status >", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
      addCriterion("status >=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThan(Integer value) {
      addCriterion("status <", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThanOrEqualTo(Integer value) {
      addCriterion("status <=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusIn(List<Integer> values) {
      addCriterion("status in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotIn(List<Integer> values) {
      addCriterion("status not in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusBetween(Integer value1, Integer value2) {
      addCriterion("status between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotBetween(Integer value1, Integer value2) {
      addCriterion("status not between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andReadOnlyIsNull() {
      addCriterion("read_only is null");
      return (Criteria) this;
    }

    public Criteria andReadOnlyIsNotNull() {
      addCriterion("read_only is not null");
      return (Criteria) this;
    }

    public Criteria andReadOnlyEqualTo(Boolean value) {
      addCriterion("read_only =", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyNotEqualTo(Boolean value) {
      addCriterion("read_only <>", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyGreaterThan(Boolean value) {
      addCriterion("read_only >", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyGreaterThanOrEqualTo(Boolean value) {
      addCriterion("read_only >=", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyLessThan(Boolean value) {
      addCriterion("read_only <", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyLessThanOrEqualTo(Boolean value) {
      addCriterion("read_only <=", value, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyIn(List<Boolean> values) {
      addCriterion("read_only in", values, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyNotIn(List<Boolean> values) {
      addCriterion("read_only not in", values, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyBetween(Boolean value1, Boolean value2) {
      addCriterion("read_only between", value1, value2, "readOnly");
      return (Criteria) this;
    }

    public Criteria andReadOnlyNotBetween(Boolean value1, Boolean value2) {
      addCriterion("read_only not between", value1, value2, "readOnly");
      return (Criteria) this;
    }

    public Criteria andRowVersionIsNull() {
      addCriterion("row_version is null");
      return (Criteria) this;
    }

    public Criteria andRowVersionIsNotNull() {
      addCriterion("row_version is not null");
      return (Criteria) this;
    }

    public Criteria andRowVersionEqualTo(Timestamp value) {
      addCriterion("row_version =", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionNotEqualTo(Timestamp value) {
      addCriterion("row_version <>", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionGreaterThan(Timestamp value) {
      addCriterion("row_version >", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionGreaterThanOrEqualTo(Timestamp value) {
      addCriterion("row_version >=", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionLessThan(Timestamp value) {
      addCriterion("row_version <", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionLessThanOrEqualTo(Timestamp value) {
      addCriterion("row_version <=", value, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionIn(List<Timestamp> values) {
      addCriterion("row_version in", values, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionNotIn(List<Timestamp> values) {
      addCriterion("row_version not in", values, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionBetween(Timestamp value1, Timestamp value2) {
      addCriterion("row_version between", value1, value2, "rowVersion");
      return (Criteria) this;
    }

    public Criteria andRowVersionNotBetween(Timestamp value1, Timestamp value2) {
      addCriterion("row_version not between", value1, value2, "rowVersion");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table role
   *
   * @mbggenerated do_not_delete_during_merge
   */
  public static class Criteria extends GeneratedCriteria {

    protected Criteria() {
      super();
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table role
   *
   * @mbggenerated
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