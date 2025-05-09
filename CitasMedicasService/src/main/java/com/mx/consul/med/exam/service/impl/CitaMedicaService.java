package com.mx.consul.med.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.consul.med.exam.dao.cita.inter.ITCitaMedicaImplDAO;
import com.mx.consul.med.exam.model.cita.CitaMedica;
import com.mx.consul.med.exam.model.cita.Medico;
import com.mx.consul.med.exam.model.cita.response.GenericClassResponse;
import com.mx.consul.med.exam.model.cita.response.ResponseBody;
import com.mx.consul.med.exam.service.exception.ServiceException;
import com.mx.consul.med.exam.service.inter.ITCitaMedicaService;
import com.mx.consul.med.exam.service.util.ValidaUtil;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class CitaMedicaService implements ITCitaMedicaService {
	Logger log = LogManager.getLogger(CitaMedicaService.class);
	
	@Autowired
	private ITCitaMedicaImplDAO citaDAO;
	
	@Override
	public GenericClassResponse<ServiceException> guardarCitaMedica(CitaMedica cita) {
		GenericClassResponse loCitaResponse = GenericClassResponse();
		if (ValidaUtil.isValidString(cita.getConsultorioMedico()) == true ) {
			ResponseBody loResponseBody =UtileriaEstaticos.CONSUL_VACIO;
			loCitaResponse.setPoResponse(loResponseBody);
			return loCitaResponse;
		}
		if (ValidaUtil.validaNull(cita.getIdDoctor()) == true ) {
			ResponseBody loResponseBody =UtileriaEstaticos.ID_DOCTOR_VACIO;
			loCitaResponse.setPoResponse(loResponseBody);
			return loCitaResponse;
		}
		citaDAO.guardarCita(cita);
		return loCitaResponse;
	}

	@Override
	public GenericClassResponse<ServiceException> consultarCitasMedicas(Medico medico) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarCitasMedicas'");
	}

}
