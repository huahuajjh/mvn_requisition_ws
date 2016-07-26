package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.OperationRecord;
import com.tq.entity.querymodel.OperationRecordQuerymodel;
import com.tq.utils.ConstValue;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;

public class OperationRecordDao extends BaseDao
{
  public String addRecord(OperationRecord record)
  {
    if (record == null) return toJson("新增的日志对象为空", null, Formater.OperationResult.FAIL);
    SqlSession session = session();
    try {
      session.insert(ConstValue.OperationRecord.ADD_RECORD, record);
      session.commit();
      return toJson("新增日志信息成功", null, Formater.OperationResult.SUCCESS);
    } finally {
      session.close();
    }
  }

  public String getByPage(OperationRecordQuerymodel querymodel)
  {
    SqlSession session = session();
    try {
      int count = ((Integer)session.selectOne(ConstValue.OperationRecord.QUERY_COUNT_BY_MODEL, querymodel)).intValue();
      if (count == 0) return toJson("获取日志记录成功,但是未查询到数据", null, Formater.OperationResult.SUCCESS);
      List list = session.selectList(ConstValue.OperationRecord.QUERY_BY_MODEL, querymodel);
      return toJsonByPage(PageFormater.obtain(list, count), "获取日志列表成功", Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJsonByPage(null, "获取日志列表失败-" + e.getMessage(), Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String getDataById(String id)
  {
    SqlSession session = session();
    try {
      String data = (String)session.selectOne("queryDataById", id);
      return toJson("获取操作数据成功", data, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str1;
      return toJson("获取操作数据失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }
}