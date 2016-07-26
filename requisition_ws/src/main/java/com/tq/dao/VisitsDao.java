package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.Visits;
import com.tq.entity.querymodel.VisitsQueryModel;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;

public class VisitsDao extends BaseDao
{
  public String addVisits(Visits info)
  {
    if (info == null) {
      return toJson("新增的信访数据为空", null, Formater.OperationResult.FAIL);
    }

    String msg = info.validate();
    if (!msg.equals("SUCCESS")) {
      return toJson(msg, null, Formater.OperationResult.FAIL);
    }

    SqlSession session = null;
    try {
      session = session();
      session.insert("addVisits", info);
      session.commit();
      return toJson("新增信访信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str1;
      return toJson("新增信访信息失败-错误消息：" + e.getMessage(), null, Formater.OperationResult.FAIL);
    }
    finally {
      session.close();
    }
  }

  public String queryByModel(VisitsQueryModel queryModel)
  {
    if (queryModel == null) {
      return toJson("查询mdoel为空", null, Formater.OperationResult.FAIL);
    }

    SqlSession session = null;
    try {
      queryModel.prepare();
      session = session();
      int count = ((Integer)session.selectOne("selectCountByQueryModel", queryModel)).intValue();

      if (count == 0) {
        return toJson("查询信访数据成功,但是未查询到任何记录", null, Formater.OperationResult.SUCCESS);
      }

      List list = session.selectList("selectByQueryModel", queryModel);
      return toJson("查询信访数据成功", PageFormater.obtain(list, count), 
        Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("查询信访数据失败，失败消息：" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String modify(Visits info)
  {
    if (info == null)
    {
      return toJson("修改的信访数据为空", null, Formater.OperationResult.FAIL);
    }

    SqlSession session = session();
    try {
      session.update("updateVisitsById", info);
      session.commit();
      return toJson("修改信访数据成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("修改信访数据失败，失败消息：" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }
}