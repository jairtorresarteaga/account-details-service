package com.bian.ms.account_details_service.controller;
import com.bian.ms.account_details_service.dto.AccountRequestDTO;
import com.bian.ms.account_details_service.dto.AccountResponseDTO;
import com.bian.ms.account_details_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings-account/v1.0")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Endpoint para obtener los detalles de la cuenta a través de una solicitud POST
    @PostMapping("/retrieve")
    public ResponseEntity<AccountResponseDTO> getAccountDetails(@RequestBody AccountRequestDTO requestDTO) {
        // Llama al servicio para obtener los detalles de la cuenta usando el número de identificación
        String identification = requestDTO.getAccount().getIdentification();
        AccountResponseDTO accountDetails = accountService.getAccountDetails(identification);
        // Devuelve la respuesta con los detalles de la cuenta
        System.out.println(requestDTO);
        return ResponseEntity.ok(accountDetails);
    }

    // Otros endpoints pueden ser agregados aquí si son necesarios
}