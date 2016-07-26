package com.tq.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tq.utils.Formater;
import com.tq.utils.PageFormater;
import com.tq.utils.Serialization;
import com.tq.utils.ServiceLocator;

public abstract class BaseWS {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public BaseWS(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

		this.response.setCharacterEncoding("UTF-8");

		this.response.setHeader("Access-Control-Allow-Origin", "*");
		this.response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		this.response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with");
	}

	protected String ip() {
		return this.request.getRemoteAddr();
	}

	protected <T> T getService(String springId, Class<T> serviceType) {
		return ServiceLocator.instance().getService(springId, serviceType);
	}

	private Formater formater(String msg, Object data,
			Formater.OperationResult type) {
		return Formater.obtain(msg, data, type);
	}

	protected String toJson(String msg, Object data,
			Formater.OperationResult type) {
		return toJson(formater(msg, data, type));
	}

	private String toJson(Object obj) {
		if (obj == null) {
			throw new NullPointerException("待序列化的对象为null");
		}
		return Serialization.toJson(obj);
	}

	protected String toJsonByPage(PageFormater page, String msg,
			Formater.OperationResult type) {
		return toJson(msg, page, type);
	}
}