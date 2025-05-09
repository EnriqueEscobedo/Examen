package com.mx.consul.med.exam.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mx.consul.med.exam.service.exception.UnknownResourceException;
import org.apache.log4j.Logger;



public class UtilConversor {
	private static final Logger logger = Logger.getLogger(UtilConversor.class);

	public String parseToJson(Object object) {
		try {

			StringBuilder strb = new StringBuilder();
			strb.append("\n");
			strb.append(new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(object));

			return strb.toString();

		} catch (Exception ex) {
			// falta agregar un error global
			logger.error(ex.getMessage());
			throw new UnknownResourceException(ex.getMessage());

		}

	}
}
