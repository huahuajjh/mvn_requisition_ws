package com.tq.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.Statistics;
import com.tq.entity.querymodel.DateSection;
import com.tq.entity.querymodel.StatisticsQueryModel;
import com.tq.idao.IStatistics;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;

public class StatisticsDao extends BaseDao
  implements IStatistics
{
  public String getStatisticsData(StatisticsQueryModel model)
  {
    SqlSession session = session();
    DateSection s = new DateSection(model.getStartDate(), model.getEndDate());
    try {
      int count = ((Integer)session.selectOne("spStatisticsCount", s)).intValue();
      if (count == 0) {
        List list = new ArrayList();
        Statistics statistics = new Statistics();
        statistics.setHalfCount(0);
        statistics.setLandBureauAmount(0.0F);
        statistics.setMoneyUnit("");
        statistics.setnLandBureauAmount(0.0F);
        statistics.setNonLrbStd(0);
        statistics.setNrcdAmount(0.0F);
        statistics.setNrcdFmlCount(0);
        statistics.setNrcdFmlItems(0);
        statistics.setOnlyChildCount(0);
        statistics.setOtherMoneyUnit("");
        statistics.setPersonalSubsidyStd(0.0F);
        statistics.setProName("");
        statistics.setRcdAmount(0.0F);
        statistics.setRcdFmlCount(0);
        statistics.setRcdFmlItems(0);
        statistics.setTotalAmount(0.0F);
        statistics.setTotalFmlCount(0);
        statistics.setTotalFmlItems(0);
        statistics.setTotalPopu(0);

        list.add(statistics);
        return toJson("获取统计数据成功", list, Formater.OperationResult.SUCCESS);
      }

      List list = session.selectList("spStatistics", model);
      return toJson("获取统计数据成功", PageFormater.obtain(list, count), Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("获取统计数据失败", e.getMessage(), Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }
}