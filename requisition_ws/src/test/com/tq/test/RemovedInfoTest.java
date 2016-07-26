package com.tq.test;

import com.tq.dao.RemovedInfoDao;
import com.tq.entity.RemovedInfo;
import com.tq.entity.querymodel.RemovedQueryModel;
import java.io.PrintStream;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

public class RemovedInfoTest
{
  @Test
  public void add()
  {
    RemovedInfo info = new RemovedInfo();
    info.setId(UUID.randomUUID().toString());
    info.setAddress("address");
    info.setBirthday(new Date());
    info.setDel(false);
    info.setIdNumber("121112121212121214");
    info.setRemoveDate(new Date());
    info.setCreateDate(new Date());
    info.setCreateId(UUID.randomUUID().toString());
    info.setFitPolicy("适用政策");
    info.setName("name");
    String str = new RemovedInfoDao().addRemovedInfo(info);
    System.out.println(str);
  }

  @Test
  public void edit() {
    RemovedInfo info = new RemovedInfo();
    info.setId("07478d8e-281f-4a3f-955a-833ef8f8eed9");
    info.setAddress("address1");
    info.setBirthday(new Date());
    info.setIdNumber("121112121212121216");
    info.setFitPolicy("iii");

    info.setRemoveDate(new Date());
    info.setName("jjh");
    String str = new RemovedInfoDao().editRemovedInfo(info);
    System.out.println(str);
  }

  @Test
  public void query() {
    RemovedQueryModel queryModel = new RemovedQueryModel();

    queryModel.setPageIndex(1);
    queryModel.setIdNumber("430121194505288114");

    queryModel.setPageSize(27);
    String str = new RemovedInfoDao().queryByModel(queryModel);
    System.out.println(str);
  }
}