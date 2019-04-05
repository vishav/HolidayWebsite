package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.*;

@Entity
@Table(name ="cities")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String name;
  private Long state;
  private Long country;

  public City() {
  }

  public City(String name) {
    this.name = name;
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

  public Long getState() {
    return state;
  }

  public void setState(Long state) {
    this.state = state;
  }

  public Long getCountry() {
    return country;
  }

  public void setCountry(Long country) {
    this.country = country;
  }
}
