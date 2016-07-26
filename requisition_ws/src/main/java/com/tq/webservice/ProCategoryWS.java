package com.tq.webservice;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.entity.ProCategory;
import com.tq.idao.IProCategoryDao;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/procategory")
public class ProCategoryWS extends BaseWS
{
  private IProCategoryDao dao;

  public ProCategoryWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
    this.dao = ((IProCategoryDao)getService("proCategoryDao", IProCategoryDao.class));
  }
  @Path("/add")
  @POST
  public String addCategory(@FormParam("entity") String category) {
    ProCategory proC = (ProCategory)Serialization.toObject(category, ProCategory.class);
    if (proC == null) {
      return toJson("序列化失败", null, Formater.OperationResult.FAIL);
    }
    proC.setId(UUID.randomUUID().toString());
    return this.dao.addCategory(proC);
  }
  @Path("/edit")
  @POST
  public String editCategory(@FormParam("entity") String category) {
    ProCategory proC = (ProCategory)Serialization.toObject(category, ProCategory.class);
    if (proC == null) {
      return toJson("序列化编辑对象失败", null, Formater.OperationResult.FAIL);
    }
    return this.dao.editCategory(proC);
  }
  @Path("/del")
  @GET
  public String delCategory(@QueryParam("id") String id) {
    return this.dao.delCategory(id);
  }
  @Path("/queryAll")
  @GET
  public String queryAll() {
    return this.dao.queryAll();
  }
}