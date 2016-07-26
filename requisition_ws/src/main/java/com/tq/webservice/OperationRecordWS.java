package com.tq.webservice;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.dao.OperationRecordDao;
import com.tq.entity.OperationRecord;
import com.tq.entity.querymodel.OperationRecordQuerymodel;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/operationRecordWS")
public class OperationRecordWS extends BaseWS
{
  public OperationRecordWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
  }
  @Path("/addRecord")
  @POST
  @Consumes({"application/x-www-form-urlencoded"})
  public String addRecord(@FormParam("record") String record) { OperationRecord model = (OperationRecord)Serialization.toObject(record, OperationRecord.class);
    if (model == null) {
      return toJson("record反序列化失败", null, Formater.OperationResult.FAIL);
    }
    model.setIp(ip());
    model.setId(UUID.randomUUID().toString());
    model.setTime(new Date());
    return ((OperationRecordDao)getService("recordDao", OperationRecordDao.class)).addRecord(model); } 
  @Path("/queryPage")
  @POST
  @Consumes({"application/x-www-form-urlencoded"})
  public String queryByPage(@FormParam("queryModel") String queryModel) {
    OperationRecordQuerymodel query = (OperationRecordQuerymodel)Serialization.toObject(queryModel, OperationRecordQuerymodel.class);
    if (query == null) return toJson("record反序列化失败", null, Formater.OperationResult.FAIL);
    return ((OperationRecordDao)getService("recordDao", OperationRecordDao.class)).getByPage(query);
  }
  @Path("/queryData")
  @GET
  public String queryDataById(@QueryParam("id") String id) {
    return ((OperationRecordDao)getService("recordDao", OperationRecordDao.class)).getDataById(id);
  }
}