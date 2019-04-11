package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.HinduSolarSpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HinduSolarSpecialRepository extends CrudRepository<HinduSolarSpecial, Long> ,QueryByExampleExecutor<HinduSolarSpecial> {
}
