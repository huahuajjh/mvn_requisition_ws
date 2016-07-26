package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.entity.querymodel.StatisticsQueryModel;
import com.tq.idao.IStatistics;
import com.tq.utils.DateFormater;

@Path("/statistics")
public class StatisticsWS extends BaseWS
{
  public StatisticsWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
  }
  @Path("/getData")
  @GET
  public String getStatisticsData(@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate, @QueryParam("pageIndex") int start, @QueryParam("pageSize") int size) {
    StatisticsQueryModel model = new StatisticsQueryModel();
    model.setStartDate(DateFormater.parse(startDate));
    model.setEndDate(DateFormater.parse(endDate));
    model.setStart((start - 1) * size);
    model.setSize(size);

    IStatistics dao = (IStatistics)getService("statistics", IStatistics.class);
    return dao.getStatisticsData(model);
  }
}