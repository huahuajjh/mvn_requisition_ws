package com.tq.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tq.entity.ArchiveFile;
import com.tq.entity.querymodel.ArchiveFileQueryModel;
import com.tq.idao.IArchiveFileDao;
import com.tq.utils.Formater;
import com.tq.utils.PageFormater;

public class ArchiveFileDao extends BaseDao implements IArchiveFileDao {
	public String addFile(ArchiveFile file) {
		SqlSession session = session();
		try {
			session.insert("addArchiveFile", file);
			session.commit();
			return toJson("新增文件成功", null, Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			// String str;
			session.rollback();
			return toJson("新增文件失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}

	public String modifyFile(ArchiveFile file) {
		SqlSession session = session();
		try {
			session.update("updateArchiveFile", file);
			session.commit();
			return toJson("修改文件成功", null, Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			String str;
			return toJson("修改文件失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.rollback();
			session.close();
		}
	}

	public String delFileById(String id) {
		SqlSession session = session();
		try {
			session.delete("delArchiveByPid", id);
			session.commit();
			return toJson("删除文件成功", null, Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			// String str;
			session.rollback();
			return toJson("删除文件失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}

	public String queryByFuzzy(ArchiveFileQueryModel queryModel) {
		SqlSession session = session();
		try {
			int count = ((Integer) session
					.selectOne("selectArchiveCountByFuzzy", queryModel))
							.intValue();
			if (count == 0) {
				return toJson("查询文件成功", null, Formater.OperationResult.SUCCESS);
			}
			List list = session.selectList("selectArchiveByFuzzy", queryModel);
			return toJsonByPage(PageFormater.obtain(list, count), "查询文件列表成功",
					Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			String str;
			return toJson("查询失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}

	public String queryByTypeId(String typeId, int pageIndex, int pageSize) {
		Map map = new HashMap();
		map.put("typeId", typeId);
		map.put("index", Integer.valueOf((pageIndex - 1) * pageSize));
		map.put("size", Integer.valueOf(pageSize));

		SqlSession session = session();
		try {
			int count = ((Integer) session
					.selectOne("selectArchiveCountByTypeId", typeId))
							.intValue();
			if (count == 0) {
				return toJson("查询文件成功，但是未查询到数据", null,
						Formater.OperationResult.FAIL);
			}
			List list = session.selectList("selectArchiveByTypeId", map);
			return toJsonByPage(PageFormater.obtain(list, count), "查询文件成功",
					Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			String str;
			return toJson("查询失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}

	public String queryByKeywords(String keywords, int pageIndex,
			int pageSize) {
		Map map = new HashMap();
		map.put("keywords", keywords);
		map.put("index", Integer.valueOf((pageIndex - 1) * pageSize));
		map.put("size", Integer.valueOf(pageSize));

		SqlSession session = session();
		try {
			int count = ((Integer) session
					.selectOne("selectArchiveCountByKeyword", keywords))
							.intValue();
			if (count == 0) {
				return toJson("查询文件成功，但是未查询到数据", null,
						Formater.OperationResult.FAIL);
			}
			List list = session.selectList("selectArchiveByKeyword", map);
			return toJsonByPage(PageFormater.obtain(list, count), "查询文件成功",
					Formater.OperationResult.SUCCESS);
		} catch (Exception e) {
			String str;
			return toJson("查询失败-" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}
}