package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.tq.dao.FamilyItemDao;
import com.tq.utils.Formater;

@Path("/fmlItem")
public class FamilyItemWS extends BaseWS {
	public FamilyItemWS(@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		super(request, response);
	}

	@Path("/getItems")
	@GET
	public String getFmlItems(@QueryParam("id") String id) {
		if ((id == null) || (id.trim().equals(""))) {
			return null;
		}

		return ((FamilyItemDao) getService("fmlItemDao", FamilyItemDao.class))
				.getFmlItems(id);
	}

	@Path("/getTransferInfo")
	@GET
	public String getTransferInfoByItemId(@QueryParam("id") String id) {
		if ((id == null) || (id.trim().equals(""))) {
			return null;
		}

		return ((FamilyItemDao) getService("fmlItemDao", FamilyItemDao.class))
				.getTransferInfoByItemId(id);
	}

	@Path("/getSSInfo")
	@GET
	public String getSocialsecurityInfoByItemId(@QueryParam("id") String id) {
		if ((id == null) || (id.trim().equals(""))) {
			return null;
		}

		return ((FamilyItemDao) getService("fmlItemDao", FamilyItemDao.class))
				.getSocialsecurityInfoByItemId(id);
	}

	@Path("/getHptInfo")
	@GET
	public String getHptInfoByItemId(@QueryParam("id") String id) {
		if ((id == null) || (id.trim().equals(""))) {
			return null;
		}

		return ((FamilyItemDao) getService("fmlItemDao", FamilyItemDao.class))
				.getHptInfoByItemId(id);
	}

	@Path("/idnumberExists")
	@GET
	public String existsByIdNumber(@QueryParam("idnumber") String idNumber) {
		if ((idNumber == null) || (idNumber.trim().equals(""))) {
			return toJson("查询参数不能为空", null, Formater.OperationResult.FAIL);
		}

		return ((FamilyItemDao) getService("fmlItemDao", FamilyItemDao.class))
				.existsByIdNumber(idNumber);
	}
}