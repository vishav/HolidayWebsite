package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> ,QueryByExampleExecutor<Country> {
    List<Country> findByName(String name);
}