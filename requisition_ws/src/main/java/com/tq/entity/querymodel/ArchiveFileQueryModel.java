package com.tq.entity.querymodel;

public class ArchiveFileQueryModel
{
  private String title;
  private String typeIds;
  private int pageIndex;
  private int pageSize;
  private String createId;

  public String getCreateId()
  {
    return this.createId;
  }
  public void setCreateId(String createId) {
    this.createId = createId;
  }
  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getTypeIds() {
    return this.typeIds;
  }
  public void setTypeIds(String typeIds) {
    this.typeIds = typeIds;
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
}