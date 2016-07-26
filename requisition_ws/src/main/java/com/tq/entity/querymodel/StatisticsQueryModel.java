package com.tq.entity.querymodel;

import java.util.Date;

public class StatisticsQueryModel
{
  int start;
  int size;
  Date startDate;
  Date endDate;

  public int getStart()
  {
    return this.start;
  }
  public void setStart(int start) {
    this.start = start;
  }
  public int getSize() {
    return this.size;
  }
  public void setSize(int size) {
    this.size = size;
  }
  public Date getStartDate() {
    return this.startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return this.endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}