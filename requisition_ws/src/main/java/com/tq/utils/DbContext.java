package com.tq.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbContext
{
  private static final String RESOURCE = "configuration.xml";
  private static SqlSessionFactory factory = null;

  static {
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream("configuration.xml");
      factory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
      try
      {
        inputStream.close();
      } catch (IOException ex) {
    	  ex.printStackTrace();
      }
    }
    finally
    {
      try
      {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static SqlSessionFactory dbContext() {
    return factory;
  }
}