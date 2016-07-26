package com.tq.entity;

import java.util.Date;
import java.util.UUID;

public class OperationRecord
{
  private String id;
  private String ip;
  private Date time;
  private String moudle;
  private String action;
  private String content;
  private String mac;
  private String accountId;
  private String name;
  private String moudleId;
  private String data;

  public OperationRecord()
  {
    this.id = UUID.randomUUID().toString();
    this.time = new Date();
  }

  public String getData()
  {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getId() {
    return this.id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getIp() {
    return this.ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public Date getTime() {
    return this.time;
  }
  public void setTime(Date time) {
    this.time = time;
  }
  public String getMoudle() {
    return this.moudle;
  }
  public void setMoudle(String moudle) {
    this.moudle = moudle;
  }
  public String getAction() {
    return this.action;
  }
  public void setAction(String action) {
    this.action = action;
  }
  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getMac() {
    return this.mac;
  }
  public void setMac(String mac) {
    this.mac = mac;
  }
  public String getAccountId() {
    return this.accountId;
  }
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getMoudleId() {
    return this.moudleId;
  }
  public void setMoudleId(String moudleId) {
    this.moudleId = moudleId;
  }
}