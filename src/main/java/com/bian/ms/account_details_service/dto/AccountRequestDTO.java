package com.bian.ms.account_details_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRequestDTO {

    @JsonProperty("Account") // Asegúrate de que el nombre coincida con el JSON entrante
    private AccountInnerDTO Account;

    // Getter para Account
    public AccountInnerDTO getAccount() {
        return Account;
    }

    // Setter para Account
    public void setAccount(AccountInnerDTO Account) {
        this.Account = Account;
    }

    public static class AccountInnerDTO {

        @JsonProperty("Identification") // Asegúrate de que el nombre coincida con el JSON entrante
        private String Identification;

        // Getter para Identification
        public String getIdentification() {
            return Identification;
        }

        // Setter para Identification
        public void setIdentification(String Identification) {
            this.Identification = Identification;
        }
    }
}