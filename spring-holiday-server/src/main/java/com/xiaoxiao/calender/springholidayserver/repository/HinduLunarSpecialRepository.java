package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.HinduLunarSpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HinduLunarSpecialRepository extends CrudRepository<HinduLunarSpecial, Long> ,QueryByExampleExecutor<HinduLunarSpecial> {
}
