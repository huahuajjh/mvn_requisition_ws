package com.tq.entity;

import java.util.Date;
import java.util.UUID;

public class HousePuraseTicket
{
  private float bonus;
  private Date makeDate;
  private String ticketNumber;
  private UUID fmlItemId;
  private String name;
  private String evidence;
  private String useType;
  private String explain;
  private Date gettingDate;
  private Date useDate;
  private String useToWhere;
  private String ticketState;
  private String idNumber;
  private String evidencePath;

  public float getBonus()
  {
    return this.bonus;
  }
  public void setBonus(float bonus) {
    this.bonus = bonus;
  }
  public Date getMakeDate() {
    return this.makeDate;
  }
  public void setMakeDate(Date makeDate) {
    this.makeDate = makeDate;
  }
  public String getTicketNumber() {
    return this.ticketNumber;
  }
  public void setTicketNumber(String ticketNumber) {
    this.ticketNumber = ticketNumber;
  }
  public UUID getFmlItemId() {
    return this.fmlItemId;
  }
  public void setFmlItemId(UUID fmlItemId) {
    this.fmlItemId = fmlItemId;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUseEvidence() {
    return this.evidence;
  }
  public void setUseEvidence(String useEvidence) {
    this.evidence = useEvidence;
  }
  public String getUseType() {
    return this.useType;
  }
  public void setUseType(String useType) {
    this.useType = useType;
  }
  public String getExplain() {
    return this.explain;
  }
  public void setExplain(String explain) {
    this.explain = explain;
  }
  public Date getGettingDate() {
    return this.gettingDate;
  }
  public void setGettingDate(Date gettingDate) {
    this.gettingDate = gettingDate;
  }
  public String getEvidence() {
    return this.evidence;
  }
  public void setEvidence(String evidence) {
    this.evidence = evidence;
  }
  public Date getUseDate() {
    return this.useDate;
  }
  public void setUseDate(Date useDate) {
    this.useDate = useDate;
  }
  public String getUseToWhere() {
    return this.useToWhere;
  }
  public void setUseToWhere(String useToWhere) {
    this.useToWhere = useToWhere;
  }
  public String getIdNumber() {
    return this.idNumber;
  }
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }
  public String getTicketState() {
    return this.ticketState;
  }
  public void setTicketState(String ticketState) {
    this.ticketState = ticketState;
  }
  public String getEvidencePath() {
    return this.evidencePath;
  }
  public void setEvidencePath(String evidencePath) {
    this.evidencePath = evidencePath;
  }
}