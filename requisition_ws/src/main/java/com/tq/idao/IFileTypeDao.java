package com.tq.idao;

import com.tq.entity.FileType;
import com.tq.entity.querymodel.FileTypeQueryModel;

public abstract interface IFileTypeDao
{
  public abstract String addFileType(FileType paramFileType);

  public abstract String modifyFileType(FileType paramFileType);

  public abstract String queryByPid(FileTypeQueryModel paramFileTypeQueryModel);

  public abstract String delByIds(String paramString);

  public abstract String getAllType();
}