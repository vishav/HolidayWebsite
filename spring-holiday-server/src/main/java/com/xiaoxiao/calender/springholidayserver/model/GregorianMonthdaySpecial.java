package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="gregorian_monthday_special")
public class GregorianMonthdaySpecial {
  public GregorianMonthdaySpecial() {
  }

  public GregorianMonthdaySpecial(Long month, Long day, Long offset, Long leapyearadjust, String description) {
    this.month = month;
    this.day = day;
    this.offset = offset;
    this.leapyearadjust = leapyearadjust;
    this.description = description;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long month;
  private Long day;
  private Long offset;
  private Long leapyearadjust;
  private String description;

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

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public Long getLeapyearadjust() {
    return leapyearadjust;
  }

  public void setLeapyearadjust(Long leapyearadjust) {
    this.leapyearadjust = leapyearadjust;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
