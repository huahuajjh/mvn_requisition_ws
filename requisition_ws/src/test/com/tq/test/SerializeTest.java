package com.tq.test;

import com.google.gson.reflect.TypeToken;
import com.tq.entity.querymodel.OperationRecordQuerymodel;
import com.tq.utils.Serialization;
import java.io.PrintStream;
import java.util.List;
import org.junit.Test;

public class SerializeTest
{
  @Test
  public void serializetio()
  {
    System.out.println(Serialization.toObject("{'end':'2011/01/01 20:00','moudleId':'123','pageIndex':1,'pageSize':30}", OperationRecordQuerymodel.class));
  }

  @Test
  public void serialist() {
    String json = "[{'name':'n1','age':18},{'name':'n2','age':19}]";
    List<P> list = Serialization.toList(json, new TypeToken() {  } .getType());
    for (P p : list)
      System.out.println(p.getName());
  }
}