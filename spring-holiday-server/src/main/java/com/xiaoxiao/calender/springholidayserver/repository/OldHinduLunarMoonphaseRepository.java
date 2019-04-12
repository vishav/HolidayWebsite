package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunarMoonphase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface OldHinduLunarMoonphaseRepository extends CrudRepository<OldHinduLunarMoonphase, Long> ,QueryByExampleExecutor<OldHinduLunarMoonphase> {
}
