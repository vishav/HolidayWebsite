package com.xiaoxiao.calender.springholidayserver.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name ="formula_extensions")
public class FormulaExtensions {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;
  @Column(name = "IfDay1a")
  private String ifDay1a;
  @Column(name = "IfDay1b")
  private String ifDay1b;
  @Column(name = "IfDay1c")  
  private String ifDay1c;
  @Column(name = "Add_ReplaceWith1")
  private String add_replaceWith1;
  @Column(name = "Following_Preceding1")
  private String following_preceding1;
  @Column(name = "OnDay1")
  private String onDay1;
  @Column(name = "IfDay2a")
  private String ifDay2a;
  @Column(name = "IfDay2b")
  private String ifDay2b;
  @Column(name = "IfDay2c")  
  private String ifDay2c;
  @Column(name = "Add_ReplaceWith2")
  private String add_replaceWith2;
  @Column(name = "Following_Preceding2")
  private String following_preceding2;
  @Column(name = "OnDay2")
  private String onDay2;
  @Column(name = "IfDay3a")
  private String ifDay3a;
  @Column(name = "IfDay3b")
  private String ifDay3b;
  @Column(name = "IfDay3c")  
  private String ifDay3c;
  @Column(name = "Add_ReplaceWith3")
  private String add_replaceWith3;
  @Column(name = "Following_Preceding3")
  private String following_preceding3;
  @Column(name = "OnDay3")
  private String onDay3;


 // Getter Methods 

  public Long getId() {
    return id;
  }

  public String getIfDay1a() {
    return ifDay1a;
  }

  public String getIfDay1b() {
    return ifDay1b;
  }

  public String getIfDay1c() {
    return ifDay1c;
  }

  public String getAdd_replaceWith1() {
    return add_replaceWith1;
  }

  public String getFollowing_preceding1() {
    return following_preceding1;
  }

  public String getOnDay1() {
    return onDay1;
  }

  public String getIfDay2a() {
    return ifDay2a;
  }

  public String getIfDay2b() {
    return ifDay2b;
  }

  public String getIfDay2c() {
    return ifDay2c;
  }

  public String getAdd_replaceWith2() {
    return add_replaceWith2;
  }

  public String getFollowing_preceding2() {
    return following_preceding2;
  }

  public String getOnDay2() {
    return onDay2;
  }

  public String getIfDay3a() {
    return ifDay3a;
  }

  public String getIfDay3b() {
    return ifDay3b;
  }

  public String getIfDay3c() {
    return ifDay3c;
  }

  public String getAdd_replaceWith3() {
    return add_replaceWith3;
  }

  public String getFollowing_preceding3() {
    return following_preceding3;
  }

  public String getOnDay3() {
    return onDay3;
  }

 // Setter Methods 

  public void setId( Long id ) {
    this.id = id;
  }

  public void setIfDay1a( String ifDay1a ) {
    this.ifDay1a = ifDay1a;
  }

  public void setIfDay1b( String ifDay1b ) {
    this.ifDay1b = ifDay1b;
  }

  public void setIfDay1c( String ifDay1c ) {
    this.ifDay1c = ifDay1c;
  }

  public void setAdd_replaceWith1( String add_replaceWith1 ) {
    this.add_replaceWith1 = add_replaceWith1;
  }

  public void setFollowing_preceding1( String following_preceding1 ) {
    this.following_preceding1 = following_preceding1;
  }

  public void setOnDay1( String onDay1 ) {
    this.onDay1 = onDay1;
  }

  public void setIfDay2a( String ifDay2a ) {
    this.ifDay2a = ifDay2a;
  }

  public void setIfDay2b( String ifDay2b ) {
    this.ifDay2b = ifDay2b;
  }

  public void setIfDay2c( String ifDay2c ) {
    this.ifDay2c = ifDay2c;
  }

  public void setAdd_replaceWith2( String add_replaceWith2 ) {
    this.add_replaceWith2 = add_replaceWith2;
  }

  public void setFollowing_preceding2( String following_preceding2 ) {
    this.following_preceding2 = following_preceding2;
  }

  public void setOnDay2( String onDay2 ) {
    this.onDay2 = onDay2;
  }

  public void setIfDay3a( String ifDay3a ) {
    this.ifDay3a = ifDay3a;
  }

  public void setIfDay3b( String ifDay3b ) {
    this.ifDay3b = ifDay3b;
  }

  public void setIfDay3c( String ifDay3c ) {
    this.ifDay3c = ifDay3c;
  }

  public void setAdd_replaceWith3( String add_replaceWith3 ) {
    this.add_replaceWith3 = add_replaceWith3;
  }

  public void setFollowing_preceding3( String following_preceding3 ) {
    this.following_preceding3 = following_preceding3;
  }

  public void setOnDay3( String onDay3 ) {
    this.onDay3 = onDay3;
  }
}
