package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.EcclesiasticalGregorian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EcclesiasticalGregorianRepository extends CrudRepository<EcclesiasticalGregorian, Long>,QueryByExampleExecutor<EcclesiasticalGregorian> {
}
