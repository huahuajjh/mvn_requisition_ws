package com.tq.test;

import com.tq.dao.FileTypeDao;
import com.tq.entity.FileType;
import com.tq.entity.querymodel.FileTypeQueryModel;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.Test;

public class FileTypeDaoTest
{
  @Test
  public void queryByPid()
  {
    FileTypeQueryModel model = new FileTypeQueryModel();
    model.setPid(" ");
    String str = new FileTypeDao().queryByPid(model);
    System.out.println(str);
  }

  @Test
  public void add() {
    FileType type = new FileType();
    type.setId(UUID.randomUUID().toString());
    type.setPid("1e3262b9-c6d1-4166-b337-ba933bfd3097");
    type.setTitle("省1号政策");
    String str = new FileTypeDao().addFileType(type);
    System.out.println(str);
  }

  @Test
  public void modify() {
    FileType type = new FileType();
    type.setId(UUID.fromString("b1774e5a-968b-4dc6-b844-5b814b45dc70").toString());
    type.setTitle("县3号文件");
    String str = new FileTypeDao().modifyFileType(type);
    System.out.println(str);
  }

  @Test
  public void del() {
    String str = new FileTypeDao().delByIds("6db35205-8600-4453-9c5b-0bd045a41f45,f3eb31e3-5831-4183-9352-ec9d76e0519c,6d3e1dc8-ab8c-4d0c-8556-7707d28990b1");
    System.out.println(str);
  }

  @Test
  public void getAll() {
    String str = new FileTypeDao().getAllType();
    System.out.println(str);
  }
}