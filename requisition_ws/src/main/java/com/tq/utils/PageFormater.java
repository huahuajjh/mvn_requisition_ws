package com.tq.utils;

public class PageFormater
{
  private Object datas;
  private int totalCount;

  private PageFormater(Object _datas, int _totalCount)
  {
    this.datas = _datas;
    this.totalCount = _totalCount;
  }

  public static PageFormater obtain(Object _datas, int _totalCount) {
    return new PageFormater(_datas, _totalCount);
  }

  public String toString()
  {
    return "PageFormater [datas=" + this.datas + ", totalCount=" + this.totalCount + 
      "]";
  }

  public Object getDatas() {
    return this.datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }

  public int getTotalCount() {
    return this.totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }
}