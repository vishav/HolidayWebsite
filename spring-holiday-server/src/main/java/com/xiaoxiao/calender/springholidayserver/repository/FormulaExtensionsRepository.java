package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.FormulaExtensions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface FormulaExtensionsRepository extends CrudRepository<FormulaExtensions, Long>,QueryByExampleExecutor<FormulaExtensions> {
}
