package com.mx.consul.med.exam.service.util;

public class ValidaUtil {

	public static String validaNull(String str) {
		String srcs = str;
		if (srcs == null) {
			srcs = "";
		}
		return srcs.trim();
	}
	
	public static int validaNull(Integer in) {
		Integer srcs = in;
		if (srcs == null) {
			srcs = 0;
		}
		return srcs;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static boolean isValidString(String id) {
		if (isNull(id) || isEmptyString(id)) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private static boolean isNull(Object id) {
		if (id == null){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private static boolean isEmptyString(String id) {
		if (id.length() <= 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
