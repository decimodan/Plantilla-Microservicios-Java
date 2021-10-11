package com.plantilla.demo.errors;

import java.util.List;

public class ErrorDescription {
    private String propiedad;

    private List<String> error;

    public String getPropiedad() { return propiedad; }
    public void setPropiedad(String propiedad) { this.propiedad = propiedad; }

    public List<String> getError() { return error; }
    public void setError(List<String> error) { this.error = error; }

    public ErrorDescription(String propiedad, List<String> error) {
        this.propiedad = propiedad;
        this.error = error;
    }
}
