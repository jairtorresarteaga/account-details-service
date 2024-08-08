package com.bian.ms.account_details_service.model;

public class BackendAccountResponse {
    private String numero_cuenta;
    private String tipo_moneda_cuenta;
    private String estado_cuenta;
    private String tipo_cuenta;

    // Constructor por defecto
    public BackendAccountResponse() {
    }

    // Getters para los campos
    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public String getTipo_moneda_cuenta() {
        return tipo_moneda_cuenta;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    // Setters para los campos (si es necesario para tu lógica de negocio)
    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void setTipo_moneda_cuenta(String tipo_moneda_cuenta) {
        this.tipo_moneda_cuenta = tipo_moneda_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }
}
