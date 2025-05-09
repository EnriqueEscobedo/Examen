package com.mx.consul.med.exam.dao.cita.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.consul.med.exam.dao.cita.inter.ITCitaMedicaImplDAO;
import com.mx.consul.med.exam.model.cita.CitaMedica;
import com.mx.consul.med.exam.model.cita.Medico;


@Repository
@Transactional
public class CitaMedicaImplDAO implements ITCitaMedicaImplDAO{

	@Override
	public void guardarCita(CitaMedica cita) {
	}

	@Override
	public List<CitaMedica> consuCitaMedicas(Medico medico) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consuCitaMedicas'");
	}

}
