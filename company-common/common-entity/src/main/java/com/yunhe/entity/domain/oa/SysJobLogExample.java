package com.yunhe.entity.domain.oa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysJobLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysJobLogExample() {
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
        Criteria criteria = new Criteria();
        return criteria;
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

        public Criteria andJobLogIdIsNull() {
            addCriterion("job_log_id is null");
            return (Criteria) this;
        }

        public Criteria andJobLogIdIsNotNull() {
            addCriterion("job_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobLogIdEqualTo(Long value) {
            addCriterion("job_log_id =", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotEqualTo(Long value) {
            addCriterion("job_log_id <>", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdGreaterThan(Long value) {
            addCriterion("job_log_id >", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("job_log_id >=", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdLessThan(Long value) {
            addCriterion("job_log_id <", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdLessThanOrEqualTo(Long value) {
            addCriterion("job_log_id <=", value, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdIn(List<Long> values) {
            addCriterion("job_log_id in", values, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotIn(List<Long> values) {
            addCriterion("job_log_id not in", values, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdBetween(Long value1, Long value2) {
            addCriterion("job_log_id between", value1, value2, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobLogIdNotBetween(Long value1, Long value2) {
            addCriterion("job_log_id not between", value1, value2, "jobLogId");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetIsNull() {
            addCriterion("invoke_target is null");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetIsNotNull() {
            addCriterion("invoke_target is not null");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetEqualTo(String value) {
            addCriterion("invoke_target =", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetNotEqualTo(String value) {
            addCriterion("invoke_target <>", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetGreaterThan(String value) {
            addCriterion("invoke_target >", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetGreaterThanOrEqualTo(String value) {
            addCriterion("invoke_target >=", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetLessThan(String value) {
            addCriterion("invoke_target <", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetLessThanOrEqualTo(String value) {
            addCriterion("invoke_target <=", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetLike(String value) {
            addCriterion("invoke_target like", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetNotLike(String value) {
            addCriterion("invoke_target not like", value, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetIn(List<String> values) {
            addCriterion("invoke_target in", values, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetNotIn(List<String> values) {
            addCriterion("invoke_target not in", values, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetBetween(String value1, String value2) {
            addCriterion("invoke_target between", value1, value2, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andInvokeTargetNotBetween(String value1, String value2) {
            addCriterion("invoke_target not between", value1, value2, "invokeTarget");
            return (Criteria) this;
        }

        public Criteria andJobMessageIsNull() {
            addCriterion("job_message is null");
            return (Criteria) this;
        }

        public Criteria andJobMessageIsNotNull() {
            addCriterion("job_message is not null");
            return (Criteria) this;
        }

        public Criteria andJobMessageEqualTo(String value) {
            addCriterion("job_message =", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageNotEqualTo(String value) {
            addCriterion("job_message <>", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageGreaterThan(String value) {
            addCriterion("job_message >", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageGreaterThanOrEqualTo(String value) {
            addCriterion("job_message >=", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageLessThan(String value) {
            addCriterion("job_message <", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageLessThanOrEqualTo(String value) {
            addCriterion("job_message <=", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageLike(String value) {
            addCriterion("job_message like", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageNotLike(String value) {
            addCriterion("job_message not like", value, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageIn(List<String> values) {
            addCriterion("job_message in", values, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageNotIn(List<String> values) {
            addCriterion("job_message not in", values, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageBetween(String value1, String value2) {
            addCriterion("job_message between", value1, value2, "jobMessage");
            return (Criteria) this;
        }

        public Criteria andJobMessageNotBetween(String value1, String value2) {
            addCriterion("job_message not between", value1, value2, "jobMessage");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoIsNull() {
            addCriterion("exception_info is null");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoIsNotNull() {
            addCriterion("exception_info is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoEqualTo(String value) {
            addCriterion("exception_info =", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoNotEqualTo(String value) {
            addCriterion("exception_info <>", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoGreaterThan(String value) {
            addCriterion("exception_info >", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("exception_info >=", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoLessThan(String value) {
            addCriterion("exception_info <", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoLessThanOrEqualTo(String value) {
            addCriterion("exception_info <=", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoLike(String value) {
            addCriterion("exception_info like", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoNotLike(String value) {
            addCriterion("exception_info not like", value, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoIn(List<String> values) {
            addCriterion("exception_info in", values, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoNotIn(List<String> values) {
            addCriterion("exception_info not in", values, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoBetween(String value1, String value2) {
            addCriterion("exception_info between", value1, value2, "exceptionInfo");
            return (Criteria) this;
        }

        public Criteria andExceptionInfoNotBetween(String value1, String value2) {
            addCriterion("exception_info not between", value1, value2, "exceptionInfo");
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
