package com.tq.entity;

import java.util.Date;

import com.tq.exception.DomainException;

public class Visits
{
  private String id;
  private String visitorName;
  private String visitorTel;
  private String visitorAddr;
  private String otherMsg;
  private String visitProId;
  private String visitReason;
  private Date visitTime;
  private String visitMaterialPath;
  private boolean del;
  private String proName;
  private String img;
  private String visitsWay;
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
  public String getVisitorName() {
    return this.visitorName;
  }
  public void setVisitorName(String visitorName) {
    this.visitorName = visitorName;
  }
  public String getVisitorTel() {
    return this.visitorTel;
  }
  public void setVisitorTel(String visitorTel) {
    this.visitorTel = visitorTel;
  }
  public String getVisitorAddr() {
    return this.visitorAddr;
  }
  public void setVisitorAddr(String visitorAddr) {
    this.visitorAddr = visitorAddr;
  }
  public String getOtherMsg() {
    return this.otherMsg;
  }
  public void setOtherMsg(String otherMsg) {
    this.otherMsg = otherMsg;
  }
  public String getVisitProId() {
    return this.visitProId;
  }
  public void setVisitProId(String visitProId) {
    this.visitProId = visitProId;
  }
  public String getVisitReason() {
    return this.visitReason;
  }
  public void setVisitReason(String visitReason) {
    this.visitReason = visitReason;
  }
  public Date getVisitTime() {
    return this.visitTime;
  }
  public void setVisitTime(Date visitTime) {
    this.visitTime = visitTime;
  }
  public String getVisitMaterialPath() {
    return this.visitMaterialPath;
  }
  public void setVisitMaterialPath(String visitMaterialPath) {
    this.visitMaterialPath = visitMaterialPath;
  }
  public boolean isDel() {
    return this.del;
  }
  public void setDel(boolean del) {
    this.del = del;
  }
  public String getProName() {
    return this.proName;
  }
  public void setProName(String proName) {
    this.proName = proName;
  }

  public String getImg() {
    return this.img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public String getVisitsWay() {
    return this.visitsWay;
  }
  public void setVisitsWay(String visitsWay) {
    this.visitsWay = visitsWay;
  }

  public Visits() {
    this.visitTime = new Date();
    this.del = false;
  }

  private void notNullOrEmptyValidate(Object obj, String msg) throws DomainException
  {
    if ((obj == null) || (obj.toString().trim().equals("")))
      throw new DomainException(msg);
  }

  public String validate()
  {
    try {
      notNullOrEmptyValidate(this.visitorName, "信访者姓名不能为空");
      notNullOrEmptyValidate(this.proName, "访问项目不能为空");
      return "SUCCESS";
    } catch (DomainException e) {
      return e.getMessage();
    }
  }

  public void modify(Visits info) {
    this.visitorTel = info.getVisitorTel();
    this.visitorAddr = info.getVisitorAddr();
    this.visitorName = info.getVisitorName();
  }
}