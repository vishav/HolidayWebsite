package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="gregorian_kdayafteretc_monthday")
public class GregorianKdayafteretcMonthday {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long kday;
  private String afteretc;
  private Long month;
  private Long day;
  private Long offset;

  public GregorianKdayafteretcMonthday() {
  }

  public GregorianKdayafteretcMonthday(Long kday, String afteretc, Long month, Long day, Long offset) {
    this.kday = kday;
    this.afteretc = afteretc;
    this.month = month;
    this.day = day;
    this.offset = offset;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getKday() {
    return kday;
  }

  public void setKday(Long kday) {
    this.kday = kday;
  }

  public String getAfteretc() {
    return afteretc;
  }

  public void setAfteretc(String afteretc) {
    this.afteretc = afteretc;
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
}
