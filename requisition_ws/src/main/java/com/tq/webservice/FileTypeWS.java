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

import com.tq.entity.FileType;
import com.tq.entity.querymodel.FileTypeQueryModel;
import com.tq.idao.IFileTypeDao;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/fileType")
public class FileTypeWS extends BaseWS {
	private IFileTypeDao dao;

	public FileTypeWS(@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		super(request, response);
		this.dao = ((IFileTypeDao) getService("fileTypeDao",
				IFileTypeDao.class));
	}

	@Path("addType")
	@POST
	public String addType(@FormParam("title") String title,
			@FormParam("pid") String pid) {
		FileType type = new FileType();
		type.setId(UUID.randomUUID().toString());
		type.setTitle(title);
		type.setPid(pid);
		String str = this.dao.addFileType(type);
		return str;
	}

	@Path("/getAll")
	@GET
	public String getAllType() {
		return this.dao.getAllType();
	}

	@Path("/delByIds")
	@POST
	public String delByIds(@FormParam("ids") String ids) {
		return this.dao.delByIds(ids);
	}

	@Path("/queryByPid")
	@GET
	public String queryByPid(@QueryParam("pid") String pid) {
		FileTypeQueryModel model = new FileTypeQueryModel();
		model.setPid(pid);
		return this.dao.queryByPid(model);
	}

	@Path("/modify")
	@POST
	public String modifyFileType(@FormParam("type") String type) {
		FileType filetype = (FileType) Serialization.toObject(type,
				FileType.class);
		if (filetype == null) {
			return toJson("待编辑的类型为空", null, Formater.OperationResult.FAIL);
		}
		if (filetype.getTitle().trim().equals("")) {
			return toJson("类型名称不能为空", null, Formater.OperationResult.FAIL);
		}
		return this.dao.modifyFileType(filetype);
	}
}