package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.Chinese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ChineseRepository extends CrudRepository<Chinese, Long>,QueryByExampleExecutor<Chinese> {
}
