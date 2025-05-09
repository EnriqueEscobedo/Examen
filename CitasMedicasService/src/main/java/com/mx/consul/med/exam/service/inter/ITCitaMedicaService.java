package com.mx.consul.med.exam.service.inter;

import com.mx.consul.med.exam.model.cita.CitaMedica;
import com.mx.consul.med.exam.model.cita.Medico;
import com.mx.consul.med.exam.model.cita.response.GenericClassResponse;
import com.mx.consul.med.exam.service.exception.ServiceException;


public interface ITCitaMedicaService {
	
	public GenericClassResponse<ServiceException> guardarCitaMedica(CitaMedica cita);
	public GenericClassResponse<ServiceException> consultarCitasMedicas(Medico medico);
}
