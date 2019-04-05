package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="gregorian_monthday_moonphase")
public class GregorianMonthdayMoonphase {
  public GregorianMonthdayMoonphase() {
  }

  public GregorianMonthdayMoonphase(Long month, Long day, String moonphase, String location, Long offset) {
    this.month = month;
    this.day = day;
    this.moonphase = moonphase;
    this.location = location;
    this.offset = offset;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long month;
  private Long day;
  private String moonphase;
  private String location;
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

  public String getMoonphase() {
    return moonphase;
  }

  public void setMoonphase(String moonphase) {
    this.moonphase = moonphase;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }
}
