package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.OldHinduLunarSpecial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface OldHinduLunarSpecialRepository extends CrudRepository<OldHinduLunarSpecial, Long> ,QueryByExampleExecutor<OldHinduLunarSpecial> {
}
