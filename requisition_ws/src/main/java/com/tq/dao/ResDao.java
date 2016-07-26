package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.utils.Formater;

public class ResDao extends BaseDao
{
  public String getAllRes()
  {
    SqlSession session = session();
    List list = session.selectList("com.tq.mapping.Res.selectList");
    session.close();
    return toJson("获取模块列表成功", list, Formater.OperationResult.SUCCESS);
  }
}