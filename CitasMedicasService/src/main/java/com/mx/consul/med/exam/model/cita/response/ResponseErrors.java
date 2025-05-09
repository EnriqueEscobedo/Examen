package com.mx.consul.med.exam.model.cita.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"description"})
public class ResponseErrors {

	@JsonProperty ("description")
	private String psDescription;

}
