package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.Regions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface RegionsRepository extends CrudRepository<Regions, Long>,QueryByExampleExecutor<Regions> {
}
