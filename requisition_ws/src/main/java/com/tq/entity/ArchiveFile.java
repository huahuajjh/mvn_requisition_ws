package com.tq.entity;

import java.util.Date;

public class ArchiveFile
{
  private String id;
  private String filePath;
  private String fileTypeId;
  private String title;
  private String article;
  private Date createDate;
  private String typeStr;
  private String img;
  private String createId;

  public String getCreateId()
  {
    return this.createId;
  }
  public void setCreateId(String createId) {
    this.createId = createId;
  }
  public String getImg() {
    return this.img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public String getFilePath() {
    return this.filePath;
  }
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
  public String getFileTypeId() {
    return this.fileTypeId;
  }
  public void setFileTypeId(String fileTypeId) {
    this.fileTypeId = fileTypeId;
  }
  public String getTitle() {
    return this.title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getArticle() {
    return this.article;
  }
  public void setArticle(String article) {
    this.article = article;
  }
  public Date getCreateDate() {
    return this.createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public String getTypeStr() {
    return this.typeStr;
  }
  public void setTypeStr(String typeStr) {
    this.typeStr = typeStr;
  }
}