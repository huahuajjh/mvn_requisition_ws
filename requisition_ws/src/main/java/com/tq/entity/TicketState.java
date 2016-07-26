package com.tq.entity;

public enum TicketState
{
  LOSSOFREPORT(
    1, "挂失"), 
  EXCHANGEED(
    2, "已换券"), 
  MENDED(
    3, "已补券"), 
  USED(
    4, "已兑换"), 
  RECEIVED(
    5, "已领取"), 
  CASHED(
    6, "已兑现"), 
  NORMAL(
    7, "正常");

  private String strV;
  private int v;

  private TicketState(int v, String strV)
  {
    this.v = v;
    this.strV = strV;
  }

  public int toValue() {
    return this.v;
  }

  public TicketState obtainByInt(int v)
  {
    switch (v) {
    case 1:
      return LOSSOFREPORT;
    case 2:
      return EXCHANGEED;
    case 3:
      return MENDED;
    case 4:
      return USED;
    case 5:
      return RECEIVED;
    case 6:
      return CASHED;
    case 7:
      return NORMAL;
    }
    throw new IllegalArgumentException("枚举int参数错误，超出枚举限定,最小值为1，最大值为7");
  }

  public String toStr()
  {
    return this.strV;
  }
}