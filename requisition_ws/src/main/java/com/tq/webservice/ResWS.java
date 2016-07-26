package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.tq.dao.ResDao;

@Path("/res")
public class ResWS extends BaseWS
{
  public ResWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
  }
  @GET
  @Path("/getAllRes")
  public String getRes() {
    return ((ResDao)getService("resDao", ResDao.class)).getAllRes();
  }
}