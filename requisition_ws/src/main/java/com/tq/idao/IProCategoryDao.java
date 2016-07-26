package com.tq.idao;

import com.tq.entity.ProCategory;

public abstract interface IProCategoryDao
{
  public abstract String addCategory(ProCategory paramProCategory);

  public abstract String editCategory(ProCategory paramProCategory);

  public abstract String delCategory(String paramString);

  public abstract String queryAll();
}