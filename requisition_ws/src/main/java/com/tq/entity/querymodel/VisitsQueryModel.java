package com.tq.entity.querymodel;

import com.tq.exception.DomainException;

public class VisitsQueryModel
{
  private String proName;
  private String name;
  private String tel;
  private int indexPage;
  private int indexSize;
  private String createId;

  public String getProId()
  {
    return this.proName;
  }
  public String getCreateId() {
    return this.createId;
  }
  public void setCreateId(String createId) {
    this.createId = createId;
  }
  public void setProName(String proName) {
    this.proName = proName;
  }
  public String getNameString() {
    return this.name;
  }
  public void setNameString(String nameString) {
    this.name = nameString;
  }
  public String getTel() {
    return this.tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public int getIndexPage() {
    return this.indexPage;
  }
  public void setIndexPage(int indexPage) {
    this.indexPage = indexPage;
  }
  public int getIndexSize() {
    return this.indexSize;
  }
  public void setIndexSize(int indexSize) {
    this.indexSize = indexSize;
  }

  public void prepare() throws DomainException {
    if (this.indexPage <= 0) throw new DomainException("起始页必须大于等于1");
    this.indexPage = ((this.indexPage - 1) * this.indexSize);

    if ((this.name != null) && (!this.name.trim().equals("")))
    {
      this.name = ("%" + this.name + "%");
    }
    else
      this.name = null;
  }
}