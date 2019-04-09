package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.HinduLunar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HinduLunarRepository extends CrudRepository<HinduLunar, Long>,QueryByExampleExecutor<HinduLunar> {
}
