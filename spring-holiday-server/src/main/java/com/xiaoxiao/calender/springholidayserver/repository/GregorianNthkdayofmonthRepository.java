package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.GregorianNthkdayofmonth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GregorianNthkdayofmonthRepository extends CrudRepository<GregorianNthkdayofmonth, Long>,QueryByExampleExecutor<GregorianNthkdayofmonth> {
}
