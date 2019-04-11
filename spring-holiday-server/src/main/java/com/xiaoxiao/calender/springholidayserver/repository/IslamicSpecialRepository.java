package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.IslamicSpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface IslamicSpecialRepository extends CrudRepository<IslamicSpecial, Long> ,QueryByExampleExecutor<IslamicSpecial> {
}
