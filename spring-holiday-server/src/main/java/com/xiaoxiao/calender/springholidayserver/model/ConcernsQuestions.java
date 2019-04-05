package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.*;

@Entity
@Table(name ="concerns_questions")
public class ConcernsQuestions {
  public ConcernsQuestions() {
  }

  public ConcernsQuestions(String concernQuestion){
    this.concernQuestion = concernQuestion;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  @Column(name = "concern_question")
  private String concernQuestion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getConcernQuestion() {
    return concernQuestion;
  }

  public void setConcernQuestion(String concernQuestion) {
    this.concernQuestion = concernQuestion;
  }
}
