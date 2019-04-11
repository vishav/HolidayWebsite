package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.*;

@Entity
@Table(name ="regions")
public class Regions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  private String name;
  private Long world;

  public Regions(){}

  public Regions(String name, Long world){
    this.name = name;
    this.world = world;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getWorld() {
    return world;
  }

  public void setWorld(Long world) {
    this.world = world;
  }
}