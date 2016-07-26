package com.tq.test;

import com.tq.entity.Res;
import com.tq.utils.DbContext;
import java.io.PrintStream;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class ResTest
{
  @Test
  public void getAll()
  {
    SqlSession session = DbContext.dbContext().openSession();
    List<Res> list = session.selectList("com.tq.mapping.Res.selectList");
    for (Res res : list)
      System.out.println(res.getId() + "----------" + res.getTitle());
  }
}