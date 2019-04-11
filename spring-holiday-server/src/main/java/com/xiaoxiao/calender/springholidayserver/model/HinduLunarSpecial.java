package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="hindu_lunar_special")
public class HinduLunarSpecial {
  public HinduLunarSpecial() {
  }

  public HinduLunarSpecial(Long month, Long day, String description, Long offset, String leapmonth, String leapday) {
    this.month = month;
    this.day = day;
    this.description = description;
    this.offset = offset;
    this.leapmonth=leapmonth;
    this.leapday=leapday;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long month;
  private Long day;
  private String description;
  private Long offset;
  private String leapmonth;
  private String leapday;

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

  public String getLeapmonth() {
    return leapmonth;
  }

  public void setLeapmonth(String leapmonth) {
    this.leapmonth = leapmonth;
  }

  public String getLeapday() {
    return leapday;
  }

  public void setLeapday(String leapday) {
    this.leapday = leapday;
  }
}
