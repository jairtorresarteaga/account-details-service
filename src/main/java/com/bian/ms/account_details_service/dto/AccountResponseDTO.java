package com.bian.ms.account_details_service.dto;

public class AccountResponseDTO {
    private AccountInnerDTO Account;

    // Getters y setters
    public AccountInnerDTO getAccount() {
        return Account;
    }

    public void setAccount(AccountInnerDTO Account) {
        this.Account = Account;
    }

    public static class AccountInnerDTO {
        private String Identification;
        private String BaseCurrency;
        private String Status;
        private String Type;

        // Getters y setters
        public String getIdentification() {
            return Identification;
        }

        public void setIdentification(String Identification) {
            this.Identification = Identification;
        }

        public String getBaseCurrency() {
            return BaseCurrency;
        }

        public void setBaseCurrency(String BaseCurrency) {
            this.BaseCurrency = BaseCurrency;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }
    }
}