package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.ProCategory;
import com.tq.idao.IProCategoryDao;
import com.tq.utils.Formater;

public class ProCategoryDao extends BaseDao
  implements IProCategoryDao
{
  public String addCategory(ProCategory category)
  {
    if (category == null) {
      return toJson("新增分类失败，分类对象为空", null, Formater.OperationResult.FAIL);
    }
    SqlSession session = session();
    int r = ((Integer)session.selectOne("queryExitsByName", category.getName())).intValue();
    if (r >= 1)
      return toJson("新增分类失败，分类名称[" + category.getName() + "]已经存在", null, Formater.OperationResult.FAIL);
    try
    {
      session.insert("addProCategory", category);
      session.commit();
      return toJson("新增分类成功", category, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("新增分类失败，" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String editCategory(ProCategory category)
  {
    if (category == null) {
      return toJson("编辑项目分类信息失败，分类对象为空", null, Formater.OperationResult.FAIL);
    }
    SqlSession session = session();
    try {
      session.update("modifyProCategory", category);
      session.commit();
      return toJson("编辑项目分类信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("编辑项目分类信息失败-" + e.getMessage(), null, Formater.OperationResult.SUCCESS);
    } finally {
      session.close();
    }
  }

  public String delCategory(String id)
  {
    SqlSession session = session();
    try {
      session.delete("delProCategoryById", id);
      session.commit();
      return toJson("删除项目分类信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("删除项目分类信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String queryAll()
  {
    SqlSession session = session();
    try {
      List list = session.selectList("queryAllProCategory");
      return toJson("获取分类列表成功", list, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      return toJson("获取项目分类信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    }
    finally {
      session.close();
    }
  }
}