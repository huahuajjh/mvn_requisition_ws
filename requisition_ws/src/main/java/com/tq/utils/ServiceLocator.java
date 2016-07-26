package com.tq.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ServiceLocator
  implements IServiceLocator
{
  private static final ServiceLocator instance = new ServiceLocator();
  private static ApplicationContext springContext = new ClassPathXmlApplicationContext("spring.xml");

  public static IServiceLocator instance()
  {
    return instance;
  }

  public <TService> TService getService(Class<TService> serviceType)
  {
    return springContext.getBean(serviceType);
  }

  public <TService> TService getService(String springId, Class<TService> serviceType)
  {
    return springContext.getBean(springId, serviceType);
  }
}