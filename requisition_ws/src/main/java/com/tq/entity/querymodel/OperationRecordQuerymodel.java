package com.tq.entity.querymodel;

import java.sql.Date;

public class OperationRecordQuerymodel
{
  private Date from;
  private Date end;
  private String moudleId;
  private int pageIndex;
  private int pageSize;

  public Date getFrom()
  {
    return this.from;
  }
  public void setFrom(Date from) {
    this.from = from;
  }
  public Date getEnd() {
    return this.end;
  }
  public void setEnd(Date end) {
    this.end = end;
  }
  public String getMoudleId() {
    return this.moudleId;
  }
  public void setMoudleId(String moudleId) {
    this.moudleId = moudleId;
  }
  public int getPageIndex() {
    return (this.pageIndex - 1) * this.pageSize;
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
}