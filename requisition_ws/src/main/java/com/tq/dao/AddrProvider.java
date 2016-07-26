package com.tq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tq.idao.IAddrProvider;
import com.tq.utils.Formater;

public class AddrProvider extends BaseDao implements IAddrProvider {
	public String getAddr(String fuzzyStr, int code) {
		SqlSession session = session();
		List addrs = null;
		try {
			switch (code) {
			case 1:
				addrs = session.selectList("queryProAddr", fuzzyStr);
				return toJson("", addrs, Formater.OperationResult.SUCCESS);
			case 2:
				addrs = session.selectList("queryFmlAddr", fuzzyStr);
				return toJson("", addrs, Formater.OperationResult.SUCCESS);
			case 3:
				addrs = session.selectList("queryFmlItemAddr", fuzzyStr);
				return toJson("", addrs, Formater.OperationResult.SUCCESS);
			case 4:
				addrs = session.selectList("queryVisitorAddr", fuzzyStr);
				return toJson("", addrs, Formater.OperationResult.SUCCESS);
			case 5:
				addrs = session.selectList("queryRemovedInfoAddr", fuzzyStr);
				return toJson("", addrs, Formater.OperationResult.SUCCESS);
			}

			return toJson("错误的code", null, Formater.OperationResult.FAIL);
		} catch (Exception e) {
			String str;
			return toJson("error:" + e.getMessage(), null,
					Formater.OperationResult.FAIL);
		} finally {
			session.close();
		}
	}
}