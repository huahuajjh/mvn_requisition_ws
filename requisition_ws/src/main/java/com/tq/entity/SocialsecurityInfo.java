package com.tq.entity;

import java.util.Date;

public class SocialsecurityInfo
{
  private Date socialsecurityDate;
  private Integer serveArmyTime;
  private Integer endowmentInsuranceYear;
  private Integer medicalInsuranceMonth;
  private String joinWhichMedicalInsurance;
  private String community;
  private Integer prisonTime;
  private String farmTime;
  private Boolean isSocialsecurity;
  private String typeStr;
  private String ageRange;
  private String tel;

  public Date getSocialsecurityDate()
  {
    return this.socialsecurityDate;
  }
  public void setSocialsecurityDate(Date socialsecurityDate) {
    this.socialsecurityDate = socialsecurityDate;
  }
  public Integer getServeArmyTime() {
    return this.serveArmyTime;
  }
  public void setServeArmyTime(Integer serveArmyTime) {
    this.serveArmyTime = serveArmyTime;
  }
  public Integer getEndowmentInsuranceYear() {
    return this.endowmentInsuranceYear;
  }
  public void setEndowmentInsuranceYear(Integer endowmentInsuranceYear) {
    this.endowmentInsuranceYear = endowmentInsuranceYear;
  }
  public Integer getMedicalInsuranceMonth() {
    return this.medicalInsuranceMonth;
  }
  public void setMedicalInsuranceMonth(Integer medicalInsuranceMonth) {
    this.medicalInsuranceMonth = medicalInsuranceMonth;
  }
  public String getJoinWhichMedicalInsurance() {
    return this.joinWhichMedicalInsurance;
  }
  public void setJoinWhichMedicalInsurance(String joinWhichMedicalInsurance) {
    this.joinWhichMedicalInsurance = joinWhichMedicalInsurance;
  }
  public String getCommunity() {
    return this.community;
  }
  public void setCommunity(String community) {
    this.community = community;
  }
  public Integer getPrisonTime() {
    return this.prisonTime;
  }
  public void setPrisonTime(Integer prisonTime) {
    this.prisonTime = prisonTime;
  }
  public Boolean getIsSocialsecurity() {
    return this.isSocialsecurity;
  }
  public void setIsSocialsecurity(Boolean isSocialsecurity) {
    this.isSocialsecurity = isSocialsecurity;
  }
  public String getTypeStr() {
    return this.typeStr;
  }
  public void setTypeStr(String typeStr) {
    this.typeStr = typeStr;
  }
  public String getAgeRange() {
    return this.ageRange;
  }
  public void setAgeRange(String ageRange) {
    this.ageRange = ageRange;
  }
  public String getFarmTime() {
    return this.farmTime;
  }
  public void setFarmTime(String farmTime) {
    this.farmTime = farmTime;
  }
  public String getTel() {
    return this.tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }

  public String toString() {
    return "SocialsecurityInfo [socialsecurityDate=" + this.socialsecurityDate + 
      ", serveArmyTime=" + this.serveArmyTime + 
      ", endowmentInsuranceYear=" + this.endowmentInsuranceYear + 
      ", medicalInsuranceMonth=" + this.medicalInsuranceMonth + 
      ", joinWhichMedicalInsurance=" + this.joinWhichMedicalInsurance + 
      ", community=" + this.community + ", prisonTime=" + this.prisonTime + 
      ", farmTime=" + this.farmTime + ", isSocialsecurity=" + 
      this.isSocialsecurity + ", typeStr=" + this.typeStr + ", ageRange=" + 
      this.ageRange + ", tel=" + this.tel + "]";
  }
}