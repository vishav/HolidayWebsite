package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.GregorianKdayafteretcMonthday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GregorianKdayafteretcMonthdayRepository extends CrudRepository<GregorianKdayafteretcMonthday, Long>,QueryByExampleExecutor<GregorianKdayafteretcMonthday> {
}
