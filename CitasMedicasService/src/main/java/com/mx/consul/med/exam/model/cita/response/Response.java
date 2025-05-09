package com.mx.consul.med.exam.model.cita.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mx.consul.med.exam.service.util.UtileriaEstaticos;
import com.mx.consul.med.exam.service.util.ValidaUtil;

@Component
public class Response<T> {
	
	/**
	 * Carga correcta del objeto ResponseEntity
	 * @param toPayload
	 * @return
	 */
	public ResponseBody responseOk(List<?> toPayload) {		
		ResponseBody response = new ResponseBody();
		response.setStatus(UtileriaEstaticos.STATUS_CERO);
		response.setPayload(toPayload);
		return response;
	}
	
	public ResponseBody responseError(Integer tiCode, Integer tiSeverity, String tsMsgCode, String tsMessage) {

		String lsMessage = ValidaUtil.isValidString(tsMsgCode) ? tsMsgCode.concat(": ").concat(tsMessage) : tsMessage;
		ResponseBody loResponse = new ResponseBody();
		loResponse.setStatus(UtileriaEstaticos.STATUS_MENOS_UNO);
		loResponse.setCode(tiCode.toString());
		loResponse.setSeverity( tiSeverity != null ? tiSeverity.toString() : UtileriaEstaticos.SEVERITY );
		loResponse.setMessage( lsMessage );
		ResponseErrors loErrors = new ResponseErrors();
		loErrors.setDescription(tsMessage);
		loResponse.setErrors(loErrors);
		return loResponse;
	}
}
