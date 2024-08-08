package com.bian.ms.account_details_service.model;

public class BackendAccountRequest {
    private String numero_cuenta;

    // Constructor por defecto
    public BackendAccountRequest() {
    }

    // Constructor con parámetro
    public BackendAccountRequest(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    // Getter y setter para numero_cuenta
    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }
}