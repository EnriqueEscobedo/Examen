package com.mx.consul.med.exam.model.cita.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseValidation {

	
	@JsonProperty ("code")
	private String psCode;
	
	@JsonProperty ("severityLevel")
	private String psSeverityLevel;
	
	@JsonProperty ("businessMeaning")
	private String psBusinessMeaning;
	
	@JsonProperty ("description")
	private String psDescription;

	@JsonProperty ("idProceso")
	private String psIdProceso;
	
}

