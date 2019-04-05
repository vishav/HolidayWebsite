package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;
@Entity
@Table(name ="gregorian_nthkdayofmonth")
public class GregorianNthkdayofmonth {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long nth;
  private Long kday;
  private Long month;
  private Long offset;

  public GregorianNthkdayofmonth() {
  }

  public GregorianNthkdayofmonth(Long nth, Long kday, Long month, Long offset) {
    this.nth = nth;
    this.kday = kday;
    this.month = month;
    this.offset = offset;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNth() {
    return nth;
  }

  public void setNth(Long nth) {
    this.nth = nth;
  }

  public Long getKday() {
    return kday;
  }

  public void setKday(Long kday) {
    this.kday = kday;
  }

  public Long getMonth() {
    return month;
  }

  public void setMonth(Long month) {
    this.month = month;
  }

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }
}
