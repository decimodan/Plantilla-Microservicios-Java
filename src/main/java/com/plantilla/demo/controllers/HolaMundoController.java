package com.plantilla.demo.controllers;

import com.plantilla.demo.dto.Entrada;
import com.plantilla.demo.enums.CodigoResponse;
import com.plantilla.demo.enums.CodigosRespuesta;
import com.plantilla.demo.enums.Folio;
import com.plantilla.demo.enums.ResponseService;
import com.plantilla.demo.exceptions.DatosInvalidosException;
import com.plantilla.demo.log.EscribirLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

@RestController
public class HolaMundoController {

    @Autowired
    private Folio folio;

    @Autowired
    private EscribirLog escribirLog;

    @GetMapping(path = "/holamundo", produces = "application/json")
    public Object holaMundo() throws Exception{
        String holaMundo = "Hola Mundo";
        return new ResponseEntity(
                new ResponseService((CodigosRespuesta) CodigoResponse.CODIGO_200, folio.getFolio(), Arrays.asList(holaMundo)),CodigoResponse.CODIGO_200.getHttpStatus());
    }

    @PostMapping(path = "/holamundo", consumes = "application/json", produces = "application/json")
    public Object holaMundoP(@RequestBody Entrada entrada) throws Exception{
        String nombre = entrada.getName();
        Date fecha = entrada.getDate();

        if(nombre == null || fecha == null){
            throw new DatosInvalidosException("El valor del nombre o la fecha son invalidos");
        }

        return new ResponseEntity(
                new ResponseService((CodigosRespuesta) CodigoResponse.CODIGO_200, folio.getFolio(), Arrays.asList("Hola " + nombre + " son las " + fecha)),CodigoResponse.CODIGO_200.getHttpStatus());
    }
}
