package com.tq.idao;

import com.tq.entity.ArchiveFile;
import com.tq.entity.querymodel.ArchiveFileQueryModel;

public abstract interface IArchiveFileDao
{
  public abstract String addFile(ArchiveFile paramArchiveFile);

  public abstract String modifyFile(ArchiveFile paramArchiveFile);

  public abstract String delFileById(String paramString);

  public abstract String queryByFuzzy(ArchiveFileQueryModel paramArchiveFileQueryModel);

  public abstract String queryByTypeId(String paramString, int paramInt1, int paramInt2);

  public abstract String queryByKeywords(String paramString, int paramInt1, int paramInt2);
}