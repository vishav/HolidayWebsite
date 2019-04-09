package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="EcclesiasticalGregorian")
public class EcclesiasticalGregorian {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private Long daysfromeaster;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getDaysfromeaster() {
    return daysfromeaster;
  }

  public void setDaysfromeaster(Long daysfromeaster) {
    this.daysfromeaster = daysfromeaster;
  }
}
