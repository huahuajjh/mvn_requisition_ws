package com.tq.idao;

import com.tq.entity.querymodel.StatisticsQueryModel;

public abstract interface IStatistics
{
  public abstract String getStatisticsData(StatisticsQueryModel paramStatisticsQueryModel);
}