package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.FileType;
import com.tq.entity.querymodel.FileTypeQueryModel;
import com.tq.idao.IFileTypeDao;
import com.tq.utils.Formater;

public class FileTypeDao extends BaseDao
  implements IFileTypeDao
{
  public String addFileType(FileType type)
  {
    SqlSession session = session();
    try {
      session.insert("addFileType", type);
      session.commit();
      return toJson("新增文件类型成功", type, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("新增文件类型失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    }
    finally {
      session.close();
    }
  }

  public String modifyFileType(FileType type)
  {
    SqlSession session = session();
    try {
      session.update("updateTypeFile", type);
      session.commit();
      return toJson("修改文档类型成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("修改文档类型失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String queryByPid(FileTypeQueryModel pid)
  {
    if ((pid.getPid() == null) || (pid.getPid().trim().equals(""))) pid.setPid(null);
    SqlSession session = session();
    try {
      List list = session.selectList("selectByPid", pid);
      return toJson("查询文档类型成功", list, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("查询文档类型失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String delByIds(String ids)
  {
    SqlSession session = session();
    try {
      for (String id : ids.split(",")) {
        session.delete("delByPid", id);
      }

      session.commit();
      return toJson("删除文档类型成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str1;
      session.rollback();
      return toJson("删除文档类型失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String getAllType()
  {
    SqlSession session = session();
    try {
      List list = session.selectList("selectAll");
      return toJson("获取档案类型数据成功", list, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("获取档案类型数据失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    }
    finally {
      session.close();
    }
  }
}