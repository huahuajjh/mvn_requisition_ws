package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.dao.OneKeyQueryDao;

@Path("/onekeyQuery")
public class OneKeyQueryWS extends BaseWS
{
  public OneKeyQueryWS(@Context HttpServletRequest request, @Context HttpServletResponse response)
  {
    super(request, response);
  }
  @Path("/getInfo")
  @GET
  public String getInfoById(@QueryParam("id") String id) {
    if ((id != null) && (!id.trim().equals("")))
    {
      String json = ((OneKeyQueryDao)getService("oneKeyDao", OneKeyQueryDao.class)).getOnekeyQuery(id);
      return json;
    }
    return null;
  }
  @Path("/getFuzzy")
  @GET
  public String fuzzyResult(@QueryParam("fuzzy") String fuzzy) {
    if ((fuzzy != null) && (!fuzzy.trim().equals("")))
    {
      String json = ((OneKeyQueryDao)getService("oneKeyDao", OneKeyQueryDao.class)).getFuzzy(fuzzy);
      return json;
    }
    return null;
  }
}