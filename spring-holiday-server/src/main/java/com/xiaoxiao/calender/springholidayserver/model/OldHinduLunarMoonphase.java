package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="old_hindu_lunar_moonphase")
public class OldHinduLunarMoonphase {
  public OldHinduLunarMoonphase() {
  }

  public OldHinduLunarMoonphase(Long month, Long day, String moonphase, String location, Long offset, String leapmonth) {
    this.month = month;
    this.day = day;
    this.moonphase = moonphase;
    this.location = location;
    this.offset = offset;
    this.leapmonth=leapmonth;
  }


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long month;
  private Long day;
  private String moonphase;
  private String location;
  private Long offset;
  private String leapmonth;

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

  public String getLeapmonth() {
    return leapmonth;
  }

  public void setLeapmonth(String leapmonth) {
    this.leapmonth = leapmonth;
  }
}
