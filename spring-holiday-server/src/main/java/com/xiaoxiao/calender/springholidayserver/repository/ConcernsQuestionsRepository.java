package com.xiaoxiao.calender.springholidayserver.repository;

import com.xiaoxiao.calender.springholidayserver.model.ConcernsQuestions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ConcernsQuestionsRepository extends CrudRepository<ConcernsQuestions, Long> ,QueryByExampleExecutor<ConcernsQuestions> {
        List<ConcernsQuestions> findByConcernQuestion(String name);
}