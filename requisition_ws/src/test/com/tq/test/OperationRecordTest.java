package com.tq.test;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tq.entity.OperationRecord;
import com.tq.entity.querymodel.OperationRecordQuerymodel;
import com.tq.utils.DbContext;

public class OperationRecordTest
{
  @Test
  public void selectById()
  {
    SqlSession session = DbContext.dbContext().openSession();
    OperationRecord opr = (OperationRecord)session.selectOne(
      "com.tq.mapping.OperationRecord.selectById", 
      "dc5a2fa6-0de4-4189-99b7-cd9e873108a3");
    session.close();
    System.out.println(opr.getTime());
  }

  @Test
  public void queryByModel() {
    OperationRecordQuerymodel query = new OperationRecordQuerymodel();

    query.setPageIndex(1);
    query.setPageSize(3);
    SqlSession session = DbContext.dbContext().openSession();
    List<OperationRecord> list = session.selectList("selectByQuerymodel", query);
    for (OperationRecord operationRecord : list)
      System.out.println(operationRecord.getData());
  }

  @Test
  public void queryCount()
  {
    System.out.println(DbContext.dbContext().openSession().selectOne("selectCountByQuerymodel"));
  }

  @Test
  public void insert() {
    SqlSession session = null;
    OperationRecord opr = new OperationRecord();
    opr.setAccountId(UUID.randomUUID().toString());
    opr.setAction("action");
    opr.setContent("content");
    opr.setId(UUID.randomUUID().toString());
    opr.setIp("192.168.1.7");
    opr.setMac("DF-1A-5F-AB-7E-C6");
    opr.setMoudle("moudle");
    opr.setTime(Date.valueOf(""));

    session = DbContext.dbContext().openSession();
    session.insert("com.tq.mapping.OperationRecord.insert", opr);
    session.commit();
    session.close();
  }
}