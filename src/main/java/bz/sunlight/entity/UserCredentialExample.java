package bz.sunlight.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserCredentialExample {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  protected String orderByClause;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  protected boolean distinct;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  protected List<Criteria> oredCriteria;

  private Integer limit;

  private Integer offset;

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public UserCredentialExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public boolean isDistinct() {
    return distinct;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public List<Criteria> getOredCriteria() {
    return oredCriteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  public void or(Criteria criteria) {
    oredCriteria.add(criteria);
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
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
   * This method corresponds to the database table user_credential
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
   * This method corresponds to the database table user_credential
   *
   * @mbggenerated
   */
  protected Criteria createCriteriaInternal() {
    Criteria criteria = new Criteria();
    return criteria;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table user_credential
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
   * This class corresponds to the database table user_credential
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

    public Criteria andUserIdIsNull() {
      addCriterion("user_id is null");
      return (Criteria) this;
    }

    public Criteria andUserIdIsNotNull() {
      addCriterion("user_id is not null");
      return (Criteria) this;
    }

    public Criteria andUserIdEqualTo(String value) {
      addCriterion("user_id =", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotEqualTo(String value) {
      addCriterion("user_id <>", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdGreaterThan(String value) {
      addCriterion("user_id >", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdGreaterThanOrEqualTo(String value) {
      addCriterion("user_id >=", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdLessThan(String value) {
      addCriterion("user_id <", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdLessThanOrEqualTo(String value) {
      addCriterion("user_id <=", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdLike(String value) {
      addCriterion("user_id like", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotLike(String value) {
      addCriterion("user_id not like", value, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdIn(List<String> values) {
      addCriterion("user_id in", values, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotIn(List<String> values) {
      addCriterion("user_id not in", values, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdBetween(String value1, String value2) {
      addCriterion("user_id between", value1, value2, "userId");
      return (Criteria) this;
    }

    public Criteria andUserIdNotBetween(String value1, String value2) {
      addCriterion("user_id not between", value1, value2, "userId");
      return (Criteria) this;
    }

    public Criteria andUsernameIsNull() {
      addCriterion("username is null");
      return (Criteria) this;
    }

    public Criteria andUsernameIsNotNull() {
      addCriterion("username is not null");
      return (Criteria) this;
    }

    public Criteria andUsernameEqualTo(String value) {
      addCriterion("username =", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameNotEqualTo(String value) {
      addCriterion("username <>", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameGreaterThan(String value) {
      addCriterion("username >", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameGreaterThanOrEqualTo(String value) {
      addCriterion("username >=", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameLessThan(String value) {
      addCriterion("username <", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameLessThanOrEqualTo(String value) {
      addCriterion("username <=", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameLike(String value) {
      addCriterion("username like", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameNotLike(String value) {
      addCriterion("username not like", value, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameIn(List<String> values) {
      addCriterion("username in", values, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameNotIn(List<String> values) {
      addCriterion("username not in", values, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameBetween(String value1, String value2) {
      addCriterion("username between", value1, value2, "username");
      return (Criteria) this;
    }

    public Criteria andUsernameNotBetween(String value1, String value2) {
      addCriterion("username not between", value1, value2, "username");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNull() {
      addCriterion("password is null");
      return (Criteria) this;
    }

    public Criteria andPasswordIsNotNull() {
      addCriterion("password is not null");
      return (Criteria) this;
    }

    public Criteria andPasswordEqualTo(String value) {
      addCriterion("password =", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotEqualTo(String value) {
      addCriterion("password <>", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThan(String value) {
      addCriterion("password >", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordGreaterThanOrEqualTo(String value) {
      addCriterion("password >=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThan(String value) {
      addCriterion("password <", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLessThanOrEqualTo(String value) {
      addCriterion("password <=", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordLike(String value) {
      addCriterion("password like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotLike(String value) {
      addCriterion("password not like", value, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordIn(List<String> values) {
      addCriterion("password in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotIn(List<String> values) {
      addCriterion("password not in", values, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordBetween(String value1, String value2) {
      addCriterion("password between", value1, value2, "password");
      return (Criteria) this;
    }

    public Criteria andPasswordNotBetween(String value1, String value2) {
      addCriterion("password not between", value1, value2, "password");
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

    public Criteria andEnterpriseCodeIsNull() {
      addCriterion("enterprise_code is null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeIsNotNull() {
      addCriterion("enterprise_code is not null");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeEqualTo(String value) {
      addCriterion("enterprise_code =", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeNotEqualTo(String value) {
      addCriterion("enterprise_code <>", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeGreaterThan(String value) {
      addCriterion("enterprise_code >", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeGreaterThanOrEqualTo(String value) {
      addCriterion("enterprise_code >=", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeLessThan(String value) {
      addCriterion("enterprise_code <", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeLessThanOrEqualTo(String value) {
      addCriterion("enterprise_code <=", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeLike(String value) {
      addCriterion("enterprise_code like", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeNotLike(String value) {
      addCriterion("enterprise_code not like", value, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeIn(List<String> values) {
      addCriterion("enterprise_code in", values, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeNotIn(List<String> values) {
      addCriterion("enterprise_code not in", values, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeBetween(String value1, String value2) {
      addCriterion("enterprise_code between", value1, value2, "enterpriseCode");
      return (Criteria) this;
    }

    public Criteria andEnterpriseCodeNotBetween(String value1, String value2) {
      addCriterion("enterprise_code not between", value1, value2, "enterpriseCode");
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
   * This class corresponds to the database table user_credential
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
   * This class corresponds to the database table user_credential
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