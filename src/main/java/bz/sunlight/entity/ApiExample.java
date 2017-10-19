package bz.sunlight.entity;

import java.util.ArrayList;
import java.util.List;

public class ApiExample {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table api
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table api
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table api
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  private Integer limit;

  private Integer offset;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public ApiExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
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
   * This method corresponds to the database table api
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
   * This method corresponds to the database table api
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table api
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
   * This class corresponds to the database table api
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

    public Criteria andHttpMethodIsNull() {
      addCriterion("Http_Method is null");
      return (Criteria) this;
    }

    public Criteria andHttpMethodIsNotNull() {
      addCriterion("Http_Method is not null");
      return (Criteria) this;
    }

    public Criteria andHttpMethodEqualTo(String value) {
      addCriterion("Http_Method =", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodNotEqualTo(String value) {
      addCriterion("Http_Method <>", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodGreaterThan(String value) {
      addCriterion("Http_Method >", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodGreaterThanOrEqualTo(String value) {
      addCriterion("Http_Method >=", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodLessThan(String value) {
      addCriterion("Http_Method <", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodLessThanOrEqualTo(String value) {
      addCriterion("Http_Method <=", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodLike(String value) {
      addCriterion("Http_Method like", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodNotLike(String value) {
      addCriterion("Http_Method not like", value, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodIn(List<String> values) {
      addCriterion("Http_Method in", values, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodNotIn(List<String> values) {
      addCriterion("Http_Method not in", values, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodBetween(String value1, String value2) {
      addCriterion("Http_Method between", value1, value2, "httpMethod");
      return (Criteria) this;
    }

    public Criteria andHttpMethodNotBetween(String value1, String value2) {
      addCriterion("Http_Method not between", value1, value2, "httpMethod");
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
   * This class corresponds to the database table api
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
   * This class corresponds to the database table api
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