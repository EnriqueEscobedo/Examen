package com.mx.consul.med.exam.dao.cita.inter;

import java.util.List;

import com.mx.consul.med.exam.model.cita.CitaMedica;
import com.mx.consul.med.exam.model.cita.Medico;

public interface ITCitaMedicaImplDAO {

	public void guardarCita(CitaMedica cita);
	public List<CitaMedica> consuCitaMedicas(Medico medico);
}
