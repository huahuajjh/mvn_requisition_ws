package com.tq.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tq.entity.IndexData;
import com.tq.utils.DbContext;

public class TestDbContext
{
  @Test
  public void dbContext()
  {
    SqlSession session = DbContext.dbContext().openSession();
    IndexData data = (IndexData)session.selectOne("getIndexData", "5744fb8f-e85d-4d61-aa33-cc4a3da355f2");
    System.out.println(data);
  }
}