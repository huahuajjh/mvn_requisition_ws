package com.tq.entity.querymodel;

import java.util.Date;

public class DateSection
{
  Date start;
  Date end;

  public DateSection()
  {
  }

  public DateSection(Date start, Date end)
  {
    this.start = start;
    this.end = end;
  }

  public Date getStart() {
    return this.start;
  }
  public void setStart(Date start) {
    this.start = start;
  }
  public Date getEnd() {
    return this.end;
  }
  public void setEnd(Date end) {
    this.end = end;
  }
}