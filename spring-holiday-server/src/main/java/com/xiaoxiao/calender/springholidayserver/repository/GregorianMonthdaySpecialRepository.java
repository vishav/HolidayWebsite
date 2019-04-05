package com.xiaoxiao.calender.springholidayserver.repository;


import com.xiaoxiao.calender.springholidayserver.model.GregorianMonthdaySpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface GregorianMonthdaySpecialRepository extends CrudRepository<GregorianMonthdaySpecial, Long> ,QueryByExampleExecutor<GregorianMonthdaySpecial> {
}
