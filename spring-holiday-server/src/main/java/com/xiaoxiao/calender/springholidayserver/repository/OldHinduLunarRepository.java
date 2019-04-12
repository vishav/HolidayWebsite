package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface OldHinduLunarRepository extends CrudRepository<OldHinduLunar, Long>,QueryByExampleExecutor<OldHinduLunar> {
}
