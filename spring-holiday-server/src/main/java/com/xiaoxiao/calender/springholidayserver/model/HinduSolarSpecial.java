package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="hindu_solar_special")
public class HinduSolarSpecial {
  public HinduSolarSpecial() {
  }

  public HinduSolarSpecial(Long month, Long day, String description, Long offset) {
    this.month = month;
    this.day = day;
    this.description = description;
    this.offset = offset;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long month;
  private Long day;
  private String description;
  private Long offset;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMonth() {
    return month;
  }

  public void setMonth(Long month) {
    this.month = month;
  }

  public Long getDay() {
    return day;
  }

  public void setDay(Long day) {
    this.day = day;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }
}
