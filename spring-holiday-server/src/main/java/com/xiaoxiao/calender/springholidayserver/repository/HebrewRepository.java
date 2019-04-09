package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.Hebrew;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HebrewRepository extends CrudRepository<Hebrew, Long>,QueryByExampleExecutor<Hebrew> {
}
