package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.HolidayNotes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HolidayNotesRepository extends CrudRepository<HolidayNotes, Long> ,QueryByExampleExecutor<HolidayNotes> {
}
