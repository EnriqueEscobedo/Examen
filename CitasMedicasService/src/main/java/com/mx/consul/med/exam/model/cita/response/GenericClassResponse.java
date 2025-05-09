package com.mx.consul.med.exam.model.cita.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"Exception","Response"})
public class GenericClassResponse<T> {
	
	@JsonProperty("exception")
	private T               psException;
	@JsonProperty("response")
	private ResponseBody    poResponse;

}
