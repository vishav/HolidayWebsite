package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.HebrewSpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HebrewSpecialRepository extends CrudRepository<HebrewSpecial, Long> ,QueryByExampleExecutor<HebrewSpecial> {
}
