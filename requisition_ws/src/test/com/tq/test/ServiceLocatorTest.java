package com.tq.test;

import com.tq.dao.ResDao;
import com.tq.utils.IServiceLocator;
import com.tq.utils.ServiceLocator;
import java.io.PrintStream;
import org.junit.Test;

public class ServiceLocatorTest
{
  @Test
  public void sevicelocator()
  {
    ResDao dao = (ResDao)ServiceLocator.instance().getService("resDao", ResDao.class);
    System.out.println(dao.getAllRes());
  }
}