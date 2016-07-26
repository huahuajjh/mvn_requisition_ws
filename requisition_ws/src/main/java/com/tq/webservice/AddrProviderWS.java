package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.idao.IAddrProvider;
import com.tq.utils.Formater;

@Path("/addrProvider")
public class AddrProviderWS extends BaseWS {
	private IAddrProvider dao;

	public AddrProviderWS(@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		super(request, response);
		this.dao = ((IAddrProvider) getService("addrProvider",
				IAddrProvider.class));
	}

	@GET
	@Path("/getAddr")
	public String getAddr(@QueryParam("fuzzy") String fuzzyStr,
			@QueryParam("code") String code) {
		int c = 0;
		try {
			c = Integer.valueOf(code).intValue();
		} catch (Exception e) {
			return toJson("errot:" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		}
		return this.dao.getAddr(fuzzyStr, c);
	}
}