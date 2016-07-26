package com.tq.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.tq.dao.OneKeyQueryDao;
import com.tq.entity.OneKeyFuzzy;
import com.tq.utils.DbContext;

public class OneKeyQueryTest
{
  @Test
  public void onekeyQuery()
  {
    String json = new OneKeyQueryDao().getOnekeyQuery("d149e270-27bc-4e96-a93a-43e6edfc9f22");
    System.out.println(json);
  }

  @Test
  public void queryFuzzy() {
    SqlSession session = DbContext.dbContext().openSession();
    List<OneKeyFuzzy> info = session.selectList("onekeyQueryFuzzy", "%%");
    for (OneKeyFuzzy oneKeyFuzzy : info)
      System.out.println(oneKeyFuzzy.getId());
  }

  @Test
  public void fuzzy()
  {
    String json = new OneKeyQueryDao().getFuzzy("1");
    System.out.println(json);
  }

  @Test
  public void query() {
    String json = new OneKeyQueryDao().getOnekeyQuery("472bfeca-e7f0-42d3-b049-c6c22da3307c");
    System.out.println(json);
  }
}