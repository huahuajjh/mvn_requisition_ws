package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.idao.IIndexDataDao;
import com.tq.utils.Formater;

@Path("/indexData")
public class IndexDataWS extends BaseWS
{
  private IIndexDataDao dao;

  public IndexDataWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
    this.dao = ((IIndexDataDao)getService("indexDataDao", IIndexDataDao.class));
  }
  @Path("/getIndexData")
  @GET
  public String getIndexData(@QueryParam("id") String id) {
    if ((id == null) || (id.trim().equals(""))) {
      return toJson("查询参数id为空", null, Formater.OperationResult.FAIL);
    }
    return this.dao.getIndexData(id);
  }
}