package com.tq.idao;

import java.util.List;

import com.tq.entity.RemovedInfo;
import com.tq.entity.querymodel.RemovedQueryModel;

public abstract interface IRemovedInfoDao
{
  public abstract String addRemovedInfo(RemovedInfo paramRemovedInfo);

  public abstract String addBatch(List<RemovedInfo> paramList);

  public abstract String editRemovedInfo(RemovedInfo paramRemovedInfo);

  public abstract String delRemovedInfo(String paramString);

  public abstract String queryByModel(RemovedQueryModel paramRemovedQueryModel);
}