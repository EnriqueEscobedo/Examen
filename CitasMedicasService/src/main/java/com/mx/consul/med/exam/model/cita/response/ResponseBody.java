package com.mx.consul.med.exam.model.cita.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"status""payload"})
public class ResponseBody {
	@JsonProperty ("status")
	private String             psStatus;
	@JsonProperty ("payload")
	private List<?>            paPayload;

}
