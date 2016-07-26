package com.tq.test;

import org.junit.Test;

import com.tq.dao.AddrProvider;

public class AddrProviderTest
{
  @Test
  public void testAddrProvider()
  {
    String str = new AddrProvider().getAddr("唐", 1);
    System.out.println(str);
  }
}