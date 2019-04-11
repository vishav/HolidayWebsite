package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.HinduLunarMoonphase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HinduLunarMoonphaseRepository extends CrudRepository<HinduLunarMoonphase, Long> ,QueryByExampleExecutor<HinduLunarMoonphase> {
}
