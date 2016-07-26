package com.tq.dao;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.IndexData;
import com.tq.idao.IIndexDataDao;
import com.tq.utils.Formater;

public class IndexDataDao extends BaseDao
  implements IIndexDataDao
{
  public String getIndexData(String id)
  {
    SqlSession session = session();
    try {
      IndexData data = (IndexData)session.selectOne("getIndexData", id);
      return toJson("成功", data, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("error-" + e.getMessage(), null, Formater.OperationResult.ERROR);
    } finally {
      session.close();
    }
  }
}