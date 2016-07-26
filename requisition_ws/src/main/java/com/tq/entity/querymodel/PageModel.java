package com.tq.entity.querymodel;

public abstract class PageModel
{
  private int pageIndex;
  private int pageSize;

  public int getPageIndex()
  {
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

  protected int getIndex(int pageIndex, int pageSize) {
    return (pageIndex - 1) * pageSize;
  }
}