package com.plantilla.demo.errors;

import java.util.List;

public class ResponseError {
    private String codigo;
    private String mensaje;
    private String folio;
    private String info;
    private List<ErrorDescription> detalles;

    public ResponseError(String codigo, String mensaje, String folio, String info, List<ErrorDescription> detalles) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
        this.info = info;
        this.detalles = detalles;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getFolio() { return folio; }
    public void setFolio(String folio) { this.folio = folio; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public List<ErrorDescription> getDetalles() { return detalles; }
    public void setDetalles(List<ErrorDescription> detalles) { this.detalles = detalles; }
}
