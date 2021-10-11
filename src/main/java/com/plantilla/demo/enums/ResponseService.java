package com.plantilla.demo.enums;

public class ResponseService extends ResponseBase{
    private static final long serialVersionUID = 1L;

    private Object resultado;

    public ResponseService(CodigosRespuesta codigo, String folio, Object resultado) {
        super(codigo, folio);
        this.resultado = resultado;
    }

    public Object getResultado() { return resultado; }
    public void setResultado(Object resultado) { this.resultado = resultado; }
}
