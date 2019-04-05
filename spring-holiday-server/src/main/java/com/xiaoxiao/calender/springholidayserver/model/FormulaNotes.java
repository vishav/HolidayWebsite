package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name ="formula_notes")
public class FormulaNotes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String formula_note;

  public FormulaNotes() {
  }

  public FormulaNotes(String formula_note) {
    this.formula_note = formula_note;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFormula_note() {
    return formula_note;
  }

  public void setFormula_note(String formula_note) {
    this.formula_note = formula_note;
  }
}
