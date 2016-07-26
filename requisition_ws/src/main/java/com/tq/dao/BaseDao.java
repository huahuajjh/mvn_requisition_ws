package com.tq.dao;

import org.apache.ibatis.session.SqlSession;

import com.tq.utils.DbContext;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;
import com.tq.utils.Serialization;

public abstract class BaseDao
{
  protected SqlSession session()
  {
    return DbContext.dbContext().openSession();
  }

  private Formater formater(String msg, Object data, Formater.OperationResult type)
  {
    return Formater.obtain(msg, data, type);
  }

  protected String toJson(String msg, Object data, Formater.OperationResult type) {
    return toJson(formater(msg, data, type));
  }

  private String toJson(Object obj)
  {
    if (obj == null)
    {
      throw new NullPointerException("待序列化的对象为null");
    }
    return Serialization.toJson(obj);
  }

  protected String toJsonByPage(PageFormater page, String msg, Formater.OperationResult type) {
    return toJson(msg, page, type);
  }
}