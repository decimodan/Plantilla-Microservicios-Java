package com.plantilla.demo.enums;

import org.springframework.http.HttpStatus;

public interface CodigosRespuesta {
    String getCodigo();
    String getDescripcion();
    HttpStatus getHttpStatus();
}
