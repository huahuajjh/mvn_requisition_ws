package com.tq.test;

import org.junit.Test;

import com.tq.entity.querymodel.StatisticsQueryModel;
import com.tq.idao.IStatistics;
import com.tq.utils.DateFormater;
import com.tq.utils.ServiceLocator;

public class Statistics
{
  @Test
  public void queryData()
  {
    IStatistics dao = (IStatistics)ServiceLocator.instance().getService("statistics", IStatistics.class);
    StatisticsQueryModel model = new StatisticsQueryModel();
    model.setStartDate(DateFormater.parse("2016-04-01"));
    model.setEndDate(DateFormater.parse("2016-05-17"));
    model.setStart(0);
    model.setSize(1);
    String json = dao.getStatisticsData(model);
    System.out.println(json);
  }
}