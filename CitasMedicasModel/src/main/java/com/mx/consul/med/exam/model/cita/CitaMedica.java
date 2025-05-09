package com.mx.consul.med.exam.model.cita;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaMedica {
	
	private String consultorio;
	private Integer idDoctor;
	private String fechaConsulta;
	private String nombrePaciente;

}
