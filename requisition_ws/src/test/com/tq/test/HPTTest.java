package com.tq.test;

import org.junit.Test;

import com.tq.dao.FamilyItemDao;

public class HPTTest
{
  @Test
  public void query()
  {
    System.out.println(new FamilyItemDao().getHptInfoByItemId("1e63bb16-3168-4b28-a676-7604842a2910"));
  }
}