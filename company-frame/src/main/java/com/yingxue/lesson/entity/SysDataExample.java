package com.yingxue.lesson.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典数据库操作参数实体
 *
 * @author Saber污妖王
 */
public class SysDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDataExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDataItemIsNull() {
            addCriterion("data_item is null");
            return (Criteria) this;
        }

        public Criteria andDataItemIsNotNull() {
            addCriterion("data_item is not null");
            return (Criteria) this;
        }

        public Criteria andDataItemEqualTo(String value) {
            addCriterion("data_item =", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemNotEqualTo(String value) {
            addCriterion("data_item <>", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemGreaterThan(String value) {
            addCriterion("data_item >", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemGreaterThanOrEqualTo(String value) {
            addCriterion("data_item >=", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemLessThan(String value) {
            addCriterion("data_item <", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemLessThanOrEqualTo(String value) {
            addCriterion("data_item <=", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemLike(String value) {
            addCriterion("data_item like", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemNotLike(String value) {
            addCriterion("data_item not like", value, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemIn(List<String> values) {
            addCriterion("data_item in", values, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemNotIn(List<String> values) {
            addCriterion("data_item not in", values, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemBetween(String value1, String value2) {
            addCriterion("data_item between", value1, value2, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataItemNotBetween(String value1, String value2) {
            addCriterion("data_item not between", value1, value2, "dataItem");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNull() {
            addCriterion("data_name is null");
            return (Criteria) this;
        }

        public Criteria andDataNameIsNotNull() {
            addCriterion("data_name is not null");
            return (Criteria) this;
        }

        public Criteria andDataNameEqualTo(String value) {
            addCriterion("data_name =", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotEqualTo(String value) {
            addCriterion("data_name <>", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThan(String value) {
            addCriterion("data_name >", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameGreaterThanOrEqualTo(String value) {
            addCriterion("data_name >=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThan(String value) {
            addCriterion("data_name <", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLessThanOrEqualTo(String value) {
            addCriterion("data_name <=", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameLike(String value) {
            addCriterion("data_name like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotLike(String value) {
            addCriterion("data_name not like", value, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameIn(List<String> values) {
            addCriterion("data_name in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotIn(List<String> values) {
            addCriterion("data_name not in", values, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameBetween(String value1, String value2) {
            addCriterion("data_name between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataNameNotBetween(String value1, String value2) {
            addCriterion("data_name not between", value1, value2, "dataName");
            return (Criteria) this;
        }

        public Criteria andDataTableIsNull() {
            addCriterion("data_table is null");
            return (Criteria) this;
        }

        public Criteria andDataTableIsNotNull() {
            addCriterion("data_table is not null");
            return (Criteria) this;
        }

        public Criteria andDataTableEqualTo(Integer value) {
            addCriterion("data_table =", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableNotEqualTo(Integer value) {
            addCriterion("data_table <>", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableGreaterThan(Integer value) {
            addCriterion("data_table >", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_table >=", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableLessThan(Integer value) {
            addCriterion("data_table <", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableLessThanOrEqualTo(Integer value) {
            addCriterion("data_table <=", value, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableIn(List<Integer> values) {
            addCriterion("data_table in", values, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableNotIn(List<Integer> values) {
            addCriterion("data_table not in", values, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableBetween(Integer value1, Integer value2) {
            addCriterion("data_table between", value1, value2, "dataTable");
            return (Criteria) this;
        }

        public Criteria andDataTableNotBetween(Integer value1, Integer value2) {
            addCriterion("data_table not between", value1, value2, "dataTable");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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