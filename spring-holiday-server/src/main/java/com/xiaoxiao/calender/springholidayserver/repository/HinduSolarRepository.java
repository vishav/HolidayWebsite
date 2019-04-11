package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.HinduSolar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HinduSolarRepository extends CrudRepository<HinduSolar, Long>,QueryByExampleExecutor<HinduSolar> {
}
