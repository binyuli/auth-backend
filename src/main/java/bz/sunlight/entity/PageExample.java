package bz.sunlight.entity;

import java.util.ArrayList;
import java.util.List;

public class PageExample {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table page
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table page
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table page
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  private Integer limit;

  private Integer offset;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public PageExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
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
   * This method corresponds to the database table page
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
   * This method corresponds to the database table page
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table page
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
   * This class corresponds to the database table page
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
      addCriterion("Id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("Id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(String value) {
      addCriterion("Id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(String value) {
      addCriterion("Id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(String value) {
      addCriterion("Id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(String value) {
      addCriterion("Id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(String value) {
      addCriterion("Id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(String value) {
      addCriterion("Id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLike(String value) {
      addCriterion("Id like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotLike(String value) {
      addCriterion("Id not like", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<String> values) {
      addCriterion("Id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<String> values) {
      addCriterion("Id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(String value1, String value2) {
      addCriterion("Id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(String value1, String value2) {
      addCriterion("Id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andNameIsNull() {
      addCriterion("Name is null");
      return (Criteria) this;
    }

    public Criteria andNameIsNotNull() {
      addCriterion("Name is not null");
      return (Criteria) this;
    }

    public Criteria andNameEqualTo(String value) {
      addCriterion("Name =", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotEqualTo(String value) {
      addCriterion("Name <>", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThan(String value) {
      addCriterion("Name >", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameGreaterThanOrEqualTo(String value) {
      addCriterion("Name >=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThan(String value) {
      addCriterion("Name <", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLessThanOrEqualTo(String value) {
      addCriterion("Name <=", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameLike(String value) {
      addCriterion("Name like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotLike(String value) {
      addCriterion("Name not like", value, "name");
      return (Criteria) this;
    }

    public Criteria andNameIn(List<String> values) {
      addCriterion("Name in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotIn(List<String> values) {
      addCriterion("Name not in", values, "name");
      return (Criteria) this;
    }

    public Criteria andNameBetween(String value1, String value2) {
      addCriterion("Name between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andNameNotBetween(String value1, String value2) {
      addCriterion("Name not between", value1, value2, "name");
      return (Criteria) this;
    }

    public Criteria andUrlIsNull() {
      addCriterion("Url is null");
      return (Criteria) this;
    }

    public Criteria andUrlIsNotNull() {
      addCriterion("Url is not null");
      return (Criteria) this;
    }

    public Criteria andUrlEqualTo(String value) {
      addCriterion("Url =", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotEqualTo(String value) {
      addCriterion("Url <>", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThan(String value) {
      addCriterion("Url >", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlGreaterThanOrEqualTo(String value) {
      addCriterion("Url >=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThan(String value) {
      addCriterion("Url <", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLessThanOrEqualTo(String value) {
      addCriterion("Url <=", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlLike(String value) {
      addCriterion("Url like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotLike(String value) {
      addCriterion("Url not like", value, "url");
      return (Criteria) this;
    }

    public Criteria andUrlIn(List<String> values) {
      addCriterion("Url in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotIn(List<String> values) {
      addCriterion("Url not in", values, "url");
      return (Criteria) this;
    }

    public Criteria andUrlBetween(String value1, String value2) {
      addCriterion("Url between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andUrlNotBetween(String value1, String value2) {
      addCriterion("Url not between", value1, value2, "url");
      return (Criteria) this;
    }

    public Criteria andIconIsNull() {
      addCriterion("Icon is null");
      return (Criteria) this;
    }

    public Criteria andIconIsNotNull() {
      addCriterion("Icon is not null");
      return (Criteria) this;
    }

    public Criteria andIconEqualTo(String value) {
      addCriterion("Icon =", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotEqualTo(String value) {
      addCriterion("Icon <>", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconGreaterThan(String value) {
      addCriterion("Icon >", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconGreaterThanOrEqualTo(String value) {
      addCriterion("Icon >=", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLessThan(String value) {
      addCriterion("Icon <", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLessThanOrEqualTo(String value) {
      addCriterion("Icon <=", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconLike(String value) {
      addCriterion("Icon like", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotLike(String value) {
      addCriterion("Icon not like", value, "icon");
      return (Criteria) this;
    }

    public Criteria andIconIn(List<String> values) {
      addCriterion("Icon in", values, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotIn(List<String> values) {
      addCriterion("Icon not in", values, "icon");
      return (Criteria) this;
    }

    public Criteria andIconBetween(String value1, String value2) {
      addCriterion("Icon between", value1, value2, "icon");
      return (Criteria) this;
    }

    public Criteria andIconNotBetween(String value1, String value2) {
      addCriterion("Icon not between", value1, value2, "icon");
      return (Criteria) this;
    }

    public Criteria andWeightIsNull() {
      addCriterion("Weight is null");
      return (Criteria) this;
    }

    public Criteria andWeightIsNotNull() {
      addCriterion("Weight is not null");
      return (Criteria) this;
    }

    public Criteria andWeightEqualTo(Integer value) {
      addCriterion("Weight =", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightNotEqualTo(Integer value) {
      addCriterion("Weight <>", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightGreaterThan(Integer value) {
      addCriterion("Weight >", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
      addCriterion("Weight >=", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightLessThan(Integer value) {
      addCriterion("Weight <", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightLessThanOrEqualTo(Integer value) {
      addCriterion("Weight <=", value, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightIn(List<Integer> values) {
      addCriterion("Weight in", values, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightNotIn(List<Integer> values) {
      addCriterion("Weight not in", values, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightBetween(Integer value1, Integer value2) {
      addCriterion("Weight between", value1, value2, "weight");
      return (Criteria) this;
    }

    public Criteria andWeightNotBetween(Integer value1, Integer value2) {
      addCriterion("Weight not between", value1, value2, "weight");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNull() {
      addCriterion("parent_Id is null");
      return (Criteria) this;
    }

    public Criteria andParentIdIsNotNull() {
      addCriterion("parent_Id is not null");
      return (Criteria) this;
    }

    public Criteria andParentIdEqualTo(String value) {
      addCriterion("parent_Id =", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotEqualTo(String value) {
      addCriterion("parent_Id <>", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThan(String value) {
      addCriterion("parent_Id >", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdGreaterThanOrEqualTo(String value) {
      addCriterion("parent_Id >=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThan(String value) {
      addCriterion("parent_Id <", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLessThanOrEqualTo(String value) {
      addCriterion("parent_Id <=", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdLike(String value) {
      addCriterion("parent_Id like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotLike(String value) {
      addCriterion("parent_Id not like", value, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdIn(List<String> values) {
      addCriterion("parent_Id in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotIn(List<String> values) {
      addCriterion("parent_Id not in", values, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdBetween(String value1, String value2) {
      addCriterion("parent_Id between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andParentIdNotBetween(String value1, String value2) {
      addCriterion("parent_Id not between", value1, value2, "parentId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIsNull() {
      addCriterion("Enterprise_Id is null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIsNotNull() {
      addCriterion("Enterprise_Id is not null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdEqualTo(String value) {
      addCriterion("Enterprise_Id =", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotEqualTo(String value) {
      addCriterion("Enterprise_Id <>", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdGreaterThan(String value) {
      addCriterion("Enterprise_Id >", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdGreaterThanOrEqualTo(String value) {
      addCriterion("Enterprise_Id >=", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLessThan(String value) {
      addCriterion("Enterprise_Id <", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLessThanOrEqualTo(String value) {
      addCriterion("Enterprise_Id <=", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdLike(String value) {
      addCriterion("Enterprise_Id like", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotLike(String value) {
      addCriterion("Enterprise_Id not like", value, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdIn(List<String> values) {
      addCriterion("Enterprise_Id in", values, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotIn(List<String> values) {
      addCriterion("Enterprise_Id not in", values, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdBetween(String value1, String value2) {
      addCriterion("Enterprise_Id between", value1, value2, "enterpriseId");
      return (Criteria) this;
    }

    public Criteria andEnterpriseIdNotBetween(String value1, String value2) {
      addCriterion("Enterprise_Id not between", value1, value2, "enterpriseId");
      return (Criteria) this;
    }
  }

  /**
   * This class was generated by MyBatis Generator.
   * This class corresponds to the database table page
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
   * This class corresponds to the database table page
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