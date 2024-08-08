/*package com.bian.ms.account_details_service.controller;
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

 */

package com.bian.ms.account_details_service.controller;

import com.bian.ms.account_details_service.dto.AccountRequestDTO;
import com.bian.ms.account_details_service.dto.AccountResponseDTO;
import com.bian.ms.account_details_service.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings-account/v1.0")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(
            summary = "API para Consultar el Detalle de una Cuenta de Ahorros a través del Número de Cuenta",
            description = "Retrieve the details of a savings account by its identification number",
            tags = {"BQ - SavingsAccount"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AccountResponseDTO.class)
            ),
            headers = {
                    @io.swagger.v3.oas.annotations.headers.Header(
                            name = "MessageIdentification",
                            description = "Unique identifier for the message",
                            schema = @Schema(type = "string")
                    )
            }
    )
    @ApiResponse(responseCode = "400", description = "BadRequest", content = @Content)
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    @ApiResponse(responseCode = "404", description = "NotFound", content = @Content)
    @ApiResponse(responseCode = "429", description = "TooManyRequests", content = @Content)
    @ApiResponse(responseCode = "500", description = "InternalServerError", content = @Content)
    @PostMapping("/retrieve")
    public ResponseEntity<AccountResponseDTO> getAccountDetails(
            @Parameter(description = "Object containing account identification details", required = true)
            @RequestBody AccountRequestDTO requestDTO
    ) {
        String identification = requestDTO.getAccount().getIdentification();
        AccountResponseDTO accountDetails = accountService.getAccountDetails(identification);
        return ResponseEntity.ok(accountDetails);
    }

    // Otros endpoints pueden ser agregados aquí si son necesarios
}
