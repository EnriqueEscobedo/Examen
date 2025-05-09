package com.mx.consul.med.exam.model.cita;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String especialidad;
}
