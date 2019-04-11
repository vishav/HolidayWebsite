package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.Islamic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface IslamicRepository extends CrudRepository<Islamic, Long>,QueryByExampleExecutor<Islamic> {
}
