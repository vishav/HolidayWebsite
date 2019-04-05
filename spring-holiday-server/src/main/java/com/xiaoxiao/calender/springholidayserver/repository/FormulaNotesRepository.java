package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.FormulaNotes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FormulaNotesRepository extends CrudRepository<FormulaNotes, Long>,QueryByExampleExecutor<FormulaNotes> {
}
