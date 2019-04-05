package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GregorianMonthdayRepository extends CrudRepository<GregorianMonthday, Long>,QueryByExampleExecutor<GregorianMonthday> {
}
