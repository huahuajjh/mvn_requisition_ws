package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.SocialsecurityInfo;
import com.tq.entity.TransferHouseholdInfo;
import com.tq.utils.Formater;

public class FamilyItemDao extends BaseDao
{
  public String getFmlItems(String id)
  {
    SqlSession session = session();
    List list = session.selectList("selectByFmlId", id);
    session.close();
    return toJson("查询拆迁人员信息成功", list, Formater.OperationResult.SUCCESS);
  }

  public String getTransferInfoByItemId(String id) {
    SqlSession session = session();
    TransferHouseholdInfo info = (TransferHouseholdInfo)session.selectOne("selectTransferByItemId", id);
    session.close();
    return toJson("查询转户信息成功", info, Formater.OperationResult.SUCCESS);
  }

  public String getSocialsecurityInfoByItemId(String id) {
    SqlSession session = session();
    SocialsecurityInfo info = (SocialsecurityInfo)session.selectOne("selectSocialsecurityByItemId", id);
    session.close();
    return toJson("查询社保信息成功", info, Formater.OperationResult.SUCCESS);
  }

  public String getHptInfoByItemId(String id) {
    SqlSession session = session();
    List info = session.selectList("selectHptByItemId", id);
    session.close();
    return toJson("查询购房券信息成功", info, Formater.OperationResult.SUCCESS);
  }

  public String existsByIdNumber(String idNUmber) {
    SqlSession session = session();
    try {
      int r = ((Integer)session.selectOne("exitByIdNumber", idNUmber)).intValue();
      if (r == 0) {
        return toJson("", null, Formater.OperationResult.SUCCESS);
      }

      return toJson("身份证[" + idNUmber + "]已存在", null, Formater.OperationResult.FAIL);
    }
    catch (Exception e)
    {
      String str;
      return toJson(e.getMessage(), null, Formater.OperationResult.ERROR);
    }
    finally {
      session.close();
    }
  }
}