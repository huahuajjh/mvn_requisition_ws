package com.tq.test;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.tq.dao.VisitsDao;
import com.tq.entity.Visits;
import com.tq.entity.querymodel.VisitsQueryModel;
import com.tq.utils.DbContext;

public class VisitsTest
{
  SqlSession session;

  @Before
  public void init()
  {
    this.session = DbContext.dbContext().openSession();
  }

  @Test
  public void add() {
    Visits info = new Visits();
    info.setId(UUID.randomUUID().toString());
    info.setOtherMsg("other message");
    info.setProName("pro name");
    info.setVisitMaterialPath("evidence path");
    info.setVisitorAddr("address");
    info.setVisitorName("zhang san");
    info.setVisitorTel("18888888888");
    info.setCreateDate(new Date());
    info.setCreateId(UUID.randomUUID().toString());
    info.setVisitProId(UUID.randomUUID().toString());
    info.setVisitReason("suggest deal");
    info.setVisitsWay("信访途径");
    String str = new VisitsDao().addVisits(info);
    System.out.println(str);
  }

  @Test
  public void queryByModel() {
    VisitsQueryModel queryModel = new VisitsQueryModel();

    queryModel.setCreateId("c12e6fce-4e41-47bd-85b0-68e8fe441d22");
    queryModel.setIndexPage(1);
    queryModel.setIndexSize(2);
    String json = new VisitsDao().queryByModel(queryModel);
    System.out.println(json);
  }

  @Test
  public void modify() {
    Visits info = new Visits();
    info.setId("1f8ea879-3e16-437a-ac5e-ac81ef6531ef");
    info.setVisitorAddr("address1");
    info.setVisitorName("lisi");
    info.setOtherMsg("o");
    info.setVisitorTel("19999999999");
    info.setProName("p");
    info.setVisitReason("r");
    info.setVisitsWay("iii");
    String str = new VisitsDao().modify(info);
    System.out.println(str);
  }
}