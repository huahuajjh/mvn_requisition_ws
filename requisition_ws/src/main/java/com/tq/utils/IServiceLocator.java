package com.tq.utils;

public abstract interface IServiceLocator
{
  public abstract <TService> TService getService(Class<TService> paramClass);

  public abstract <TService> TService getService(String paramString, Class<TService> paramClass);
}