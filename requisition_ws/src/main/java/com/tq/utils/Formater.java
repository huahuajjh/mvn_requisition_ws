package com.tq.utils;

import java.io.Serializable;

public final class Formater implements Serializable {
	private static final long serialVersionUID = 1L;
	private String msg;
	private Object data;
	private OperationResult type;

	public String getMsg() {
		return this.msg;
	}

	public Object getData() {
		return this.data;
	}

	public OperationResult getType() {
		return this.type;
	}

	private Formater(String msg, Object data, OperationResult type) {
		this.msg = msg;
		this.data = data;
		this.type = type;
	}

	public static Formater obtain(String msg, Object data,
			OperationResult type) {
		return new Formater(msg, data, type);
	}

	public static enum OperationResult {
		SUCCESS,

		ERROR,

		FAIL;
	}
}