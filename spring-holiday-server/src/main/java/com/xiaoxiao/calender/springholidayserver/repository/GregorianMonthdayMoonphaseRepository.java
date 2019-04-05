package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthdayMoonphase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GregorianMonthdayMoonphaseRepository extends CrudRepository<GregorianMonthdayMoonphase, Long> ,QueryByExampleExecutor<GregorianMonthdayMoonphase> {
}
