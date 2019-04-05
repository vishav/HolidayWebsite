package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.HolidaysLocalesDetails;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface HolidaysLocalesDetailsRepository
        extends CrudRepository<HolidaysLocalesDetails, Long>, JpaSpecificationExecutor ,QueryByExampleExecutor<HolidaysLocalesDetails> {
}