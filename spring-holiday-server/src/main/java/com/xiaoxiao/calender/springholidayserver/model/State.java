package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.*;

@Entity
@Table(name ="states")
public class State {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "country")
  private Long country;

  public State(){}

  public State(String name, Long country){
    this.name = name;
    this.country = country;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCountry() {
    return country;
  }

  public void setCountry(Long country) {
    this.country = country;
  }
}
