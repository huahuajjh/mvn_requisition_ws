package com.tq.webservice;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.tq.entity.ArchiveFile;
import com.tq.entity.querymodel.ArchiveFileQueryModel;
import com.tq.idao.IArchiveFileDao;
import com.tq.utils.Formater;
import com.tq.utils.Serialization;

@Path("/archiveFile")
public class ArchiveFileWS extends BaseWS {
	private IArchiveFileDao dao;

	public ArchiveFileWS(@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		super(request, response);
		this.dao = ((IArchiveFileDao) getService("fileDao",
				IArchiveFileDao.class));
	}

	@Path("/addFile")
	@POST
	public String addFile(@FormParam("file") String file) {
		ArchiveFile aFile = (ArchiveFile) Serialization.toObject(file,
				ArchiveFile.class);
		if (aFile == null) {
			return toJson("新增文件对象不能为空", null, Formater.OperationResult.FAIL);
		}
		aFile.setId(UUID.randomUUID().toString());
		aFile.setCreateDate(new Date());
		if (aFile.getArticle().length() > 500) {
			return toJson("文章过长，限制500字", null, Formater.OperationResult.FAIL);
		}
		return this.dao.addFile(aFile);
	}

	@Path("/modify")
	@POST
	public String modifyFile(@FormParam("file") String file) {
		ArchiveFile aFile = (ArchiveFile) Serialization.toObject(file,
				ArchiveFile.class);
		if (aFile == null) {
			return toJson("待修改的文件对象不能为空", null, Formater.OperationResult.FAIL);
		}

		return this.dao.modifyFile(aFile);
	}

	@Path("/delById")
	@POST
	public String delById(@FormParam("id") String id) {
		return this.dao.delFileById(id);
	}

	@Path("/queryByFuzzy")
	@POST
	public String queryByFuzzy(@FormParam("fuzzy") String fuzzy) {
		ArchiveFileQueryModel model = (ArchiveFileQueryModel) Serialization
				.toObject(fuzzy, ArchiveFileQueryModel.class);
		if (model == null) {
			return toJson("序列化失败", null, Formater.OperationResult.FAIL);
		}
		model.setPageIndex((model.getPageIndex() - 1) * model.getPageSize());
		return this.dao.queryByFuzzy(model);
	}

	@Path("/queryByTypeId")
	@POST
	public String queryByTypeId(@FormParam("typeId") String typeId,
			@FormParam("index") String pageIndex,
			@FormParam("size") String pageSize) {
		try {
			int index = Integer.valueOf(pageIndex).intValue();
			int size = Integer.valueOf(pageSize).intValue();
			return this.dao.queryByTypeId(typeId, index, size);
		} catch (Exception e) {
			return toJson(e.getMessage(), null, Formater.OperationResult.FAIL);
		}
	}

	@Path("/queryByKeywords")
	@POST
	public String queryByKeywords(@FormParam("keywords") String keywords,
			@FormParam("index") String pageIndex,
			@FormParam("size") String pageSize) {
		int index = Integer.valueOf(pageIndex).intValue();
		int size = Integer.valueOf(pageSize).intValue();
		return this.dao.queryByKeywords(keywords, index, size);
	}
}