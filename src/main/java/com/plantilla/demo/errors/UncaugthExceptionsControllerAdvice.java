package com.plantilla.demo.errors;

import com.plantilla.demo.enums.CodigoResponse;
import com.plantilla.demo.enums.Folio;
import com.plantilla.demo.exceptions.DatosInvalidosException;
import com.plantilla.demo.log.EscribirLog;
import com.plantilla.demo.log.Nivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.sql.Array;
import java.util.Arrays;

@ControllerAdvice(annotations = {RestController.class})
public class UncaugthExceptionsControllerAdvice {

    @Autowired
    private Folio folio;

    @Autowired
    private EscribirLog escribirLog;

    @ExceptionHandler({DatosInvalidosException.class})
    public ResponseEntity handleDatosInvalidosException(Exception e){
        ErrorDescription[] errorres = { new ErrorDescription("Problemas en el microservicio",
                Arrays.asList(new String[] {e.getMessage()}))};
        escribirLog.escribir(getClass(), Nivel.ERROR, "DatosInvalidosException: " + e);
        ResponseError response = new ResponseError(CodigoResponse.CODIGO_400.getDescripcion(),
                CodigoResponse.CODIGO_400.getDescripcion(), folio.getFolio(),
                "https://sitiodeerrores.com/errores#" + CodigoResponse.CODIGO_400.getCodigo(),
                Arrays.asList(errorres));
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception e){
        ErrorDescription[] errorres = { new ErrorDescription("Problemas en el microservicio",
                Arrays.asList(new String[] {"Fallo al escribir peticion al archivo"}))};
        escribirLog.escribir(getClass(), Nivel.ERROR, "Exception: " + e);
        ResponseError response = new ResponseError(CodigoResponse.CODIGO_500.getDescripcion(),
                CodigoResponse.CODIGO_500.getDescripcion(), folio.getFolio(),
                "https://sitiodeerrores.com/errores#" + CodigoResponse.CODIGO_500.getCodigo(),
                Arrays.asList(errorres));
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
