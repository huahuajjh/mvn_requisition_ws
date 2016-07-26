package com.tq.webservice;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.tq.dao.VisitsDao;
import com.tq.entity.Visits;
import com.tq.entity.querymodel.VisitsQueryModel;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/visits")
public class VisitsWS extends BaseWS
{
  private VisitsDao dao;

  public VisitsWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);

    this.dao = ((VisitsDao)getService("visitsDao", VisitsDao.class));
  }
  @Path("/queryByFuzzy")
  @POST
  public String queryByFuzzy(@FormParam("fuzzy") String fuzzy) {
    VisitsQueryModel queryModel = (VisitsQueryModel)Serialization.toObject(fuzzy, VisitsQueryModel.class);
    if (queryModel == null) {
      return toJson("序列化失败", null, Formater.OperationResult.FAIL);
    }

    return this.dao.queryByModel(queryModel);
  }
  @Path("/modify")
  @POST
  public String modify(@FormParam("visits") String info) {
    Visits entity = (Visits)Serialization.toObject(info, Visits.class);
    if (entity == null) {
      return toJson("序列化失败", null, Formater.OperationResult.FAIL);
    }

    return this.dao.modify(entity);
  }
  @Path("/add")
  @POST
  public String add(@FormParam("visits") String info) {
    Visits entity = (Visits)Serialization.toObject(info, Visits.class);
    if (entity == null) {
      return toJson("序列化信访信息失败", null, Formater.OperationResult.FAIL);
    }
    entity.setId(UUID.randomUUID().toString());
    entity.setCreateDate(new Date());
    entity.setDel(false);

    return this.dao.addVisits(entity);
  }
}