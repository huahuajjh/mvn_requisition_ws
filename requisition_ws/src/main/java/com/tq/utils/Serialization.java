package com.tq.utils;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class Serialization
{
  private static GsonBuilder builder = new GsonBuilder();

  private static Gson gson = builder.create();

  static
  {
    builder.setDateFormat("yyyy/MM/dd");
  }

  public static String toJson(Object obj)
  {
    return gson.toJson(obj);
  }

  public static <T> T toObject(String jsonString, Class<T> clazz)
  {
    return gson.fromJson(jsonString, clazz);
  }

  public static <T> List<T> toList(String jsonString, Type type)
  {
    return (List)gson.fromJson(jsonString, type);
  }
}