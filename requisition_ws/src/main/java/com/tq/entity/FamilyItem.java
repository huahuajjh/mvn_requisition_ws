package com.tq.entity;

import java.util.Date;

public class FamilyItem
{
  private String id;
  private String name;
  private String idNumber;
  private Date birthday;
  private int gender;
  private String onlyChildNumber;
  private boolean half;
  private String relationshipStr;
  private String householdStr;
  private String socialsecurityStr;
  private String educationLevel;
  private String currentEducationSituation;
  private String farmingTime;
  private String serveArmySituation;
  private String otherRelationship;

  public String getId()
  {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getIdNumber() {
    return this.idNumber;
  }
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }
  public Date getBirthday() {
    return this.birthday;
  }
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  public int getGender() {
    return this.gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public String getOnlyChildNumber() {
    return this.onlyChildNumber;
  }
  public void setOnlyChildNumber(String onlyChildNumber) {
    this.onlyChildNumber = onlyChildNumber;
  }
  public boolean isHalf() {
    return this.half;
  }
  public void setHalf(boolean half) {
    this.half = half;
  }
  public String getRelationshipStr() {
    return this.relationshipStr;
  }
  public void setRelationshipStr(String relationshipStr) {
    this.relationshipStr = relationshipStr;
  }
  public String getHouseholdStr() {
    return this.householdStr;
  }
  public void setHouseholdStr(String householdStr) {
    this.householdStr = householdStr;
  }
  public String getSocialsecurityStr() {
    return this.socialsecurityStr;
  }
  public void setSocialsecurityStr(String socialsecurityStr) {
    this.socialsecurityStr = socialsecurityStr;
  }
  public String getEducationLevel() {
    return this.educationLevel;
  }
  public void setEducationLevel(String educationLevel) {
    this.educationLevel = educationLevel;
  }
  public String getCurrentEducationSituation() {
    return this.currentEducationSituation;
  }
  public void setCurrentEducationSituation(String currentEducationSituation) {
    this.currentEducationSituation = currentEducationSituation;
  }
  public String getFarmingTime() {
    return this.farmingTime;
  }
  public void setFarmingTime(String farmingTime) {
    this.farmingTime = farmingTime;
  }
  public String getServeArmySituation() {
    return this.serveArmySituation;
  }
  public void setServeArmySituation(String serveArmySituation) {
    this.serveArmySituation = serveArmySituation;
  }
}