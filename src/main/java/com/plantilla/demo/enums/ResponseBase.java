package com.plantilla.demo.enums;

public class ResponseBase {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String mensaje;
    private String folio;

    public ResponseBase(String codigo, String mensaje, String folio) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
    }

    public ResponseBase(CodigosRespuesta codigo, String folio) {
        this.codigo = codigo.getCodigo();
        this.mensaje = codigo.getDescripcion();
        this.folio = folio;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }
}
