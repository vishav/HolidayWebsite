package com.xiaoxiao.calender.springholidayserver.model;
import javax.persistence.*;

@Entity
@Table(name ="holiday_notes")
public class HolidayNotes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String holiday_note;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHoliday_note() {
    return holiday_note;
  }

  public void setHoliday_note(String holiday_note) {
    this.holiday_note = holiday_note;
  }
}
