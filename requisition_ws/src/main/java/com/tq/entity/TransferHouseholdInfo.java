package com.tq.entity;

import java.util.Date;

public class TransferHouseholdInfo
{
  private String address;
  private Date transferDate;
  private String houseHoldTypeStr;
  private boolean isTransfer;

  public String getAddress()
  {
    return this.address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public Date getTransferDate() {
    return this.transferDate;
  }
  public void setTransferDate(Date transferDate) {
    this.transferDate = transferDate;
  }
  public String getHouseHoldTypeStr() {
    return this.houseHoldTypeStr;
  }
  public void setHouseHoldTypeStr(String houseHoldTypeStr) {
    this.houseHoldTypeStr = houseHoldTypeStr;
  }
  public boolean isTransfer() {
    return this.isTransfer;
  }
  public void setTransfer(boolean isTransfer) {
    this.isTransfer = isTransfer;
  }
}