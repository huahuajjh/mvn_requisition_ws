package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.OneKeyQuery;
import com.tq.utils.Formater;

public class OneKeyQueryDao extends BaseDao
{
  public String getOnekeyQuery(String id)
  {
    SqlSession session = session();
    try {
      OneKeyQuery info = (OneKeyQuery)session.selectOne("onekeyqueryById", id);
      return toJson("获取数据成功", info, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      e.printStackTrace();
      return toJson("错误-", e.getMessage(), Formater.OperationResult.ERROR);
    }
    finally {
      session.close();
    }
  }

  public String getFuzzy(String fuzzy)
  {
    SqlSession session = session();
    try {
      List list = session.selectList("onekeyQueryFuzzy", "%" + fuzzy + "%");
      return toJson("获取数据成功", list, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      e.printStackTrace();
      return toJson("错误-", e.getMessage(), Formater.OperationResult.ERROR);
    }
    finally {
      session.close();
    }
  }
}