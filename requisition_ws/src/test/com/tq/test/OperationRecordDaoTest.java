package com.tq.test;

import com.tq.dao.OperationRecordDao;
import com.tq.entity.querymodel.OperationRecordQuerymodel;
import com.tq.utils.IServiceLocator;
import com.tq.utils.ServiceLocator;
import java.io.PrintStream;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class OperationRecordDaoTest
{
  private OperationRecordDao dao;

  @Before
  public void init()
  {
    this.dao = ((OperationRecordDao)ServiceLocator.instance().getService("recordDao", OperationRecordDao.class));
  }

  @Test
  public void queryByModel() {
    OperationRecordQuerymodel query = new OperationRecordQuerymodel();
    query.setEnd(Date.valueOf("2016-03-22"));
    query.setFrom(Date.valueOf("2016-03-18"));

    query.setPageIndex(1);
    query.setPageSize(2);
    String json = this.dao.getByPage(query);
    System.out.println(json);
  }
}