package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.EcclesiasticalOrthodox;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EcclesiasticalOrthodoxRepository extends CrudRepository<EcclesiasticalOrthodox, Long>,QueryByExampleExecutor<EcclesiasticalOrthodox> {
}
