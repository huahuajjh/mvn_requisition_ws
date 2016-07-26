package com.tq.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater
{
  private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

  public static Date parse(String date) {
    try {
      return df.parse(date); } catch (ParseException e) {
    }
    return null;
  }
}