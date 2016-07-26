package com.tq.webservice;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.google.gson.reflect.TypeToken;
import com.tq.dao.RemovedInfoDao;
import com.tq.entity.RemovedInfo;
import com.tq.entity.querymodel.RemovedQueryModel;
import com.tq.idao.IRemovedInfoDao;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/removedInfo")
public class RemovedInfoWS extends BaseWS {
	private IRemovedInfoDao dao;

	public RemovedInfoWS(@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		super(request, response);
		this.dao = ((IRemovedInfoDao) getService("removedInfoDao",
				RemovedInfoDao.class));
	}

	@Path("/query")
	@POST
	public String queryByModel(@FormParam("queryEntity") String queryModel) {
		RemovedQueryModel qm = (RemovedQueryModel) Serialization
				.toObject(queryModel, RemovedQueryModel.class);
		if (qm == null) {
			return toJson("序列化已迁户信息失败", null, Formater.OperationResult.FAIL);
		}
		return this.dao.queryByModel(qm);
	}

	@Path("/add")
	@POST
	public String add(@FormParam("entity") String entity) {
		RemovedInfo info = (RemovedInfo) Serialization.toObject(entity,
				RemovedInfo.class);
		if (info == null) {
			return toJson("序列化已迁户信息失败", null, Formater.OperationResult.FAIL);
		}
		info.setId(UUID.randomUUID().toString());
		info.setCreateDate(new Date());
		return this.dao.addRemovedInfo(info);
	}

	@Path("/edit")
	@POST
	public String edit(@FormParam("entity") String entity) {
		RemovedInfo info = (RemovedInfo) Serialization.toObject(entity,
				RemovedInfo.class);
		if (info == null) {
			return toJson("序列化已迁户信息失败", null, Formater.OperationResult.FAIL);
		}
		return this.dao.editRemovedInfo(info);
	}

	@Path("/del")
	@GET
	public String del(@QueryParam("id") String id) {
		return this.dao.delRemovedInfo(id);
	}

	@Path("/addBatch")
	@POST
	public String addBatch(@FormParam("list") String list) {
		List<RemovedInfo> infos = Serialization.toList(list, new TypeToken() {
		}.getType());

		if (infos == null) {
			return toJson("反序列化失败", null, Formater.OperationResult.FAIL);
		}
		for (RemovedInfo removedInfo : infos) {
			removedInfo.setId(UUID.randomUUID().toString());
			removedInfo.setRemoveDate(new Date());
			removedInfo.setDel(false);
		}
		return this.dao.addBatch(infos);
	}
}