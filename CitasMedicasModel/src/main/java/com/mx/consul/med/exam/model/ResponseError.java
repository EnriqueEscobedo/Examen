package com.mx.consul.med.exam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Mauricio Chavez
 *
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ResponseError", description = "Respuesta de error a un fallo en el sistema")
public class ResponseError {

    @JsonProperty("codigo")
    @ApiModelProperty(value = "errorCode - codigo asignado a un error", required = true)
    private int errorCode;

    @JsonProperty("clave")
    @ApiModelProperty(value = "httpStatus", required = true)
    private String httpStatus;

    @JsonProperty("errorMessage")
    @ApiModelProperty(value = "errorMessage - error descrito de manera clara", required = true)
    private String errorMessage;

    @JsonProperty("descripcion")
    @ApiModelProperty(value = "rootErrorMessage error general", required = true)
    private String rootErrorMessage;

    @JsonProperty("mensajes")
    @ApiModelProperty(value = "errorList lista de errores", required = true)
    private List<String> errorList;

}
