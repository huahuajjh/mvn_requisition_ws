package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.RemovedInfo;
import com.tq.entity.querymodel.RemovedQueryModel;
import com.tq.idao.IRemovedInfoDao;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;

public class RemovedInfoDao extends BaseDao
  implements IRemovedInfoDao
{
  public String addRemovedInfo(RemovedInfo info)
  {
    SqlSession session = session();
    try {
      int count = ((Integer)session.selectOne("existsByIdNumber", info.getIdNumber())).intValue();
      if (count > 0) {
        return toJson("身份证[" + info.getIdNumber() + "]已存在", null, Formater.OperationResult.FAIL);
      }
      session.insert("addRemovedInfo", info);
      session.commit();
      return toJson("新增已迁户信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("新增已迁户信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String editRemovedInfo(RemovedInfo info) {
    SqlSession session = session();
    try {
      session.update("updateRemovedInfo", info);
      session.commit();
      return toJson("编辑已迁户信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("编辑已迁户信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL); } finally {
      session.close();
    }
  }

  public String delRemovedInfo(String id) {
    SqlSession session = session();
    try {
      session.delete("delRemovedInfoByid", id);
      session.commit();
      return toJson("删除已迁户信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("删除已迁户信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String queryByModel(RemovedQueryModel queryModel) {
    queryModel.setPageIndex((queryModel.getPageIndex() - 1) * queryModel.getPageSize());
    SqlSession session = session();
    try {
      int count = ((Integer)session.selectOne("selectRemovedInfoCount", queryModel)).intValue();
      if (count == 0) {
        return toJson("未查询到数据", null, Formater.OperationResult.FAIL);
      }
      List list = session.selectList("selectRemovedInfoByModel", queryModel);
      return toJsonByPage(PageFormater.obtain(list, count), "查询已迁户列表成功", Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("查询已迁户列表失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    } finally {
      session.close();
    }
  }

  public String addBatch(List<RemovedInfo> list)
  {
    SqlSession session = session();
    try {
      for (RemovedInfo removedInfo : list) {
        int count = ((Integer)session.selectOne("existsByIdNumber", removedInfo.getIdNumber())).intValue();
        if (count > 0) {
          return toJson("身份证[" + removedInfo.getIdNumber() + "]已存在", null, Formater.OperationResult.FAIL);
        }
        session.insert("addRemovedInfo", removedInfo);
      }
      session.commit();
      return toJson("新增已迁户信息成功", null, Formater.OperationResult.SUCCESS);
    }
    catch (Exception e)
    {
      String str;
      session.rollback();
      return toJson("新增已迁户信息失败-" + e.getMessage(), null, Formater.OperationResult.FAIL);
    }
    finally {
      session.close();
    }
  }
}