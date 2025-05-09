package com.mx.consul.med.exam.dao.constants;

public final class SolicitudesProcesarConstantesDAO {

    public static final String GUARDAR_CITA_MEDICA() {
        StringBuilder consulta = new StringBuilder();
        consulta.append(" INSERT INTO CITA_MEDICA (CONSULTORIO,ID_DOCTOR,FECHA_CONSULTA,NOMBRE_PACIENTE) ");
        consulta.append(" VALUES (:consultorio,:idDoctor,:fechaConsulta,:nombrePaciente)");
        return consulta.toString();
    }

    public static final String OBTENER_CITAS_MEDICAS() {
        StringBuilder consulta = new StringBuilder();

        consulta.append(" SELECT * ");
        consulta.append(" FROM TT_MEDICO MED");
        consulta.append(" INNER JOIN  CITA_MEDICA CIT");
        consulta.append(" ON MED.ID_DOCTOR = CIT.ID_DOCTOR");
        consulta.append(" AND SOL.FECHA_CONSULTA ");
        consulta.append(" BETWEEN IRN.FECHA_INICIO_VIGENCIA ");
        consulta.append(" AND IRN.FECHA_CONSULTA ");
        consulta.append(" WHERE MED.ID_DOCTOR = ? ");

        return consulta.toString();
    }

  }
