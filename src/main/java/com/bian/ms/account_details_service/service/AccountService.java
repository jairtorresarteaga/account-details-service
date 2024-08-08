package com.bian.ms.account_details_service.service;

import com.bian.ms.account_details_service.dto.AccountResponseDTO;
import com.bian.ms.account_details_service.model.BackendAccountRequest;
import com.bian.ms.account_details_service.model.BackendAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {
    private final RestTemplate restTemplate;
    private final String backendServiceUrl = "https://apis.arquitecturabank.com/core/api/v1/detalle-cuenta-ahorro";

    @Autowired
    public AccountService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AccountResponseDTO getAccountDetails(String identification) {
        // Crea la solicitud para el servicio backend
        BackendAccountRequest backendRequest = new BackendAccountRequest();
        backendRequest.setNumero_cuenta(identification);

        // Realiza la llamada POST al servicio backend
        BackendAccountResponse backendResponse = restTemplate.postForObject(
                backendServiceUrl,
                backendRequest,
                BackendAccountResponse.class
        );

        // Mapea la respuesta del backend al DTO de respuesta
        return mapToAccountResponseDTO(backendResponse);
    }

    private AccountResponseDTO mapToAccountResponseDTO(BackendAccountResponse backendResponse) {
        AccountResponseDTO.AccountInnerDTO accountInnerDTO = new AccountResponseDTO.AccountInnerDTO();
        accountInnerDTO.setIdentification(backendResponse.getNumero_cuenta());
        accountInnerDTO.setBaseCurrency(backendResponse.getTipo_moneda_cuenta());
        accountInnerDTO.setStatus(backendResponse.getEstado_cuenta());
        accountInnerDTO.setType(backendResponse.getTipo_cuenta().equals("savings") ? "saving" : backendResponse.getTipo_cuenta());

        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        accountResponseDTO.setAccount(accountInnerDTO);
        return accountResponseDTO;
    }
}