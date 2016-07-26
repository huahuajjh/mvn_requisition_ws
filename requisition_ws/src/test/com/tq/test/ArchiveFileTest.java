package com.tq.test;

import com.tq.dao.ArchiveFileDao;
import com.tq.entity.ArchiveFile;
import com.tq.entity.querymodel.ArchiveFileQueryModel;
import java.io.PrintStream;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;

public class ArchiveFileTest
{
  @Test
  public void addFile()
  {
    ArchiveFile file = new ArchiveFile();
    file.setFilePath("path");
    file.setFileTypeId("1c2d81f0-310d-4ee0-895b-021da6272ba9");
    file.setId(UUID.randomUUID().toString());
    file.setTitle("长沙1号文件");
    file.setImg("img");
    file.setArticle("article");
    file.setCreateId(UUID.randomUUID().toString());
    file.setCreateDate(new Date());
    file.setCreateDate(new Date());
    String str = new ArchiveFileDao().addFile(file);
    System.out.println(str);
  }

  @Test
  public void queryBuFuzzy() {
    ArchiveFileQueryModel model = new ArchiveFileQueryModel();
    model.setPageIndex(1);
    model.setPageSize(30);

    model.setPageIndex((model.getPageIndex() - 1) * model.getPageSize());
    model.setCreateId("91b075a7-f6c3-4992-bb87-87a03464e93e");

    String str = new ArchiveFileDao().queryByFuzzy(model);
    System.out.println(str);
  }

  @Test
  public void modify() {
    ArchiveFile file = new ArchiveFile();
    file.setFilePath("path3");
    file.setFileTypeId("1c2d81f0-310d-4ee0-895b-021da6272ba9");
    file.setId("048ce83e-b76d-4694-ac1b-fd51ffeaab81");
    file.setTitle("长沙13号文件");
    file.setImg("iii");
    String str = new ArchiveFileDao().modifyFile(file);
    System.out.println(str);
  }

  @Test
  public void queryByTypeIds() {
    String str = new ArchiveFileDao().queryByTypeId("1c2d81f0-310d-4ee0-895b-021da6272ba9", 1, 1);
    System.out.println(str);
  }

  @Test
  public void delById() {
    String str = new ArchiveFileDao().delFileById("1dea59fe-abe7-481e-98d9-daaf3876fbfb");
    System.out.println(str);
  }
}