package com.mx.consul.med.exam.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.consul.med.exam.model.cita.CitaMedica;
import com.mx.consul.med.exam.model.cita.Medico;
import com.mx.consul.med.exam.model.cita.response.GenericClassResponse;
import com.mx.consul.med.exam.service.exception.ServiceException;
import com.mx.consul.med.exam.service.inter.ITCitaMedicaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Roberto Enrique Torres
 * @version 1.0.0
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/cita")
@Api(tags="Cita", description="Citas Medicas API")
public class CitasRestController {

	Logger log = LogManager.getLogger(CitasRestController.class);
	
	
	@Autowired
	private ITCitaMedicaService citaService;
	
	
	@PostMapping(value = "/guardar")
	@ApiOperation(value="Cita", httpMethod = "POST", notes="Servicio que permite realizar el guardado de la cita")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Error, conexion a base de datos no disponible"),
			@ApiResponse(code=300, message="Error en atributos generales"),
			@ApiResponse(code=400, message="Error de negocio"),
	})	
	public ResponseEntity guardarCita(@RequestBody CitaMedica citaMedica) {
		
		GenericClassResponse loResponse = new GenericClassResponse();
		try {
			loResponse = citaService.guardarCitaMedica(citaMedica);
		}catch (Exception ex) {
			return new ResponseEntity<GenericClassResponse<ServiceException>>(HttpStatus.BAD_REQUEST);

		}
		return ResponseEntity.status(HttpStatus.OK).body(loResponse);
	}

	@PostMapping(value = "/guardar")
	@ApiOperation(value="Cita", httpMethod = "POST", notes="Servicio que permite realizar el guardado de la cita")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Error, conexion a base de datos no disponible"),
			@ApiResponse(code=300, message="Error en atributos generales"),
			@ApiResponse(code=400, message="Error de negocio"),
	})	
	public ResponseEntity consultarCita(@RequestBody Medico medico) {
		
		GenericClassResponse loResponse = new GenericClassResponse();
		try {
			loResponse = citaService.consultarCitasMedicas(medico);
		}catch (Exception ex) {
			return new ResponseEntity<GenericClassResponse<ServiceException>>(HttpStatus.BAD_REQUEST);

		}
		return ResponseEntity.status(HttpStatus.OK).body(loResponse);
	}
}
