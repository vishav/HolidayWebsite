package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name ="holidays_locales_details")
public class HolidaysLocalesDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long holiday;
  private Long city;
  private Long state;
  private Long country;
  private String formulatablename;
  private Long formulaid;
  private Long observanceruleid;
  private Long numberofdays;
  private Long formulanoteid;
  private Long holidaynoteid;
  private Long concernquestionid;
  private String businessesclosed;
  private String banksclosed;
  private String religiousholiday;
  private String dis;
  private String holidaytype;
  private String religion;
  private String metroarea;
  private String checkmanually;

  public HolidaysLocalesDetails(){
  }

  public HolidaysLocalesDetails(Long holiday, Long city, Long state, Long country, String formulatablename, Long formulaid, Long observanceruleid, Long numberofdays, Long formulanoteid, Long holidaynoteid, Long concernquestionid, String businessesclosed, String banksclosed, String religiousholiday, String dis, String holidaytype, String religion, String metroarea, String checkmanually) {
    this.holiday = holiday;
    this.city = city;
    this.state = state;
    this.country = country;
    this.formulatablename = formulatablename;
    this.formulaid = formulaid;
    this.observanceruleid = observanceruleid;
    this.numberofdays = numberofdays;
    this.formulanoteid = formulanoteid;
    this.holidaynoteid = holidaynoteid;
    this.concernquestionid = concernquestionid;
    this.businessesclosed = businessesclosed;
    this.banksclosed = banksclosed;
    this.religiousholiday = religiousholiday;
    this.dis = dis;
    this.holidaytype = holidaytype;
    this.religion = religion;
    this.metroarea = metroarea;
    this.checkmanually = checkmanually;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getHoliday() {
    return holiday;
  }

  public void setHoliday(Long holiday) {
    this.holiday = holiday;
  }

  public Long getCity() {
    return city;
  }

  public void setCity(Long city) {
    this.city = city;
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

  public String getFormulatablename() {
    return formulatablename;
  }

  public void setFormulatablename(String formulatablename) {
    this.formulatablename = formulatablename;
  }

  public Long getFormulaid() {
    return formulaid;
  }

  public void setFormulaid(Long formulaid) {
    this.formulaid = formulaid;
  }

  public Long getObservanceruleid() {
    return observanceruleid;
  }

  public void setObservanceruleid(Long observanceruleid) {
    this.observanceruleid = observanceruleid;
  }

  public Long getNumberofdays() {
    return numberofdays;
  }

  public void setNumberofdays(Long numberofdays) {
    this.numberofdays = numberofdays;
  }

  public Long getFormulanoteid() {
    return formulanoteid;
  }

  public void setFormulanoteid(Long formulanoteid) {
    this.formulanoteid = formulanoteid;
  }

  public Long getHolidaynoteid() {
    return holidaynoteid;
  }

  public void setHolidaynoteid(Long holidaynoteid) {
    this.holidaynoteid = holidaynoteid;
  }

  public Long getConcernquestionid() {
    return concernquestionid;
  }

  public void setConcernquestionid(Long concernquestionid) {
    this.concernquestionid = concernquestionid;
  }

  public String getBusinessesclosed() {
    return businessesclosed;
  }

  public void setBusinessesclosed(String businessesclosed) {
    this.businessesclosed = businessesclosed;
  }

  public String getBanksclosed() {
    return banksclosed;
  }

  public void setBanksclosed(String banksclosed) {
    this.banksclosed = banksclosed;
  }

  public String getReligiousholiday() {
    return religiousholiday;
  }

  public void setReligiousholiday(String religiousholiday) {
    this.religiousholiday = religiousholiday;
  }

  public String getDis() {
    return dis;
  }

  public void setDis(String dis) {
    this.dis = dis;
  }

  public String getHolidaytype() {
    return holidaytype;
  }

  public void setHolidaytype(String holidaytype) {
    this.holidaytype = holidaytype;
  }

  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }

  public String getMetroarea() {
    return metroarea;
  }

  public void setMetroarea(String metroarea) {
    this.metroarea = metroarea;
  }

  public String getCheckmanually() {
    return checkmanually;
  }

  public void setCheckmanually(String checkmanually) {
    this.checkmanually = checkmanually;
  }

  public static String[] getFields(){
    return Arrays.stream(HolidaysLocalesDetails.class.getDeclaredFields())
            .map(field -> field.getName())
            .toArray(String[]::new);
  }
}
