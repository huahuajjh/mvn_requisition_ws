package com.tq.entity;

import java.util.Date;

public class RemovedInfo
{
  private String id;
  private String name;
  private String idNumber;
  private Date birthday;
  private String address;
  private String streetId;
  private String communityId;
  private Date removeDate;
  private boolean del;
  private String fitPolicy;
  private Date createDate;
  private String createId;

  public Date getCreateDate()
  {
    return this.createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public String getCreateId() {
    return this.createId;
  }
  public void setCreateId(String createId) {
    this.createId = createId;
  }
  public String getId() {
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
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getStreetId() {
    return this.streetId;
  }
  public void setStreetId(String streetId) {
    this.streetId = streetId;
  }
  public String getCommunityId() {
    return this.communityId;
  }
  public void setCommunityId(String communityId) {
    this.communityId = communityId;
  }
  public Date getRemoveDate() {
    return this.removeDate;
  }
  public void setRemoveDate(Date removeDate) {
    this.removeDate = removeDate;
  }
  public boolean isDel() {
    return this.del;
  }
  public void setDel(boolean del) {
    this.del = del;
  }
  public String getFitPolicy() {
    return this.fitPolicy;
  }
  public void setFitPolicy(String fitPolicy) {
    this.fitPolicy = fitPolicy;
  }
}