package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name ="holidays")
public class Holiday {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  @Column(name = "name")
  private String name;

  public Holiday(){}

  public Holiday(String name){
    this.name = name;
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

  public static List<String> fieldsList(){
    return Arrays.stream(Holiday.class.getDeclaredFields())
            .map(field -> field.getName())
            .collect(Collectors.toList());
  }
}
