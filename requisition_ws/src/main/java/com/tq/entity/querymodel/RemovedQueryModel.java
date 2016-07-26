package com.tq.entity.querymodel;

public class RemovedQueryModel
{
  private String idNumber;
  private String name;
  private String streetId;
  private String communityId;
  private String groupId;
  private int pageIndex;
  private int pageSize;
  private String createId;
  private String address;

  public String getCreateId()
  {
    return this.createId;
  }
  public void setCreateId(String createId) {
    this.createId = createId;
  }
  public String getIdNumber() {
    return this.idNumber;
  }
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
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
  public String getGroupId() {
    return this.groupId;
  }
  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }
  public int getPageIndex() {
    return this.pageIndex;
  }
  public void setPageIndex(int pageIndex) {
    this.pageIndex = pageIndex;
  }
  public int getPageSize() {
    return this.pageSize;
  }
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
  public String getAddress() {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
}