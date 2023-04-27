package com.test_ntt_data.microserviceback.infrastruture.entry.points.controllers;

import com.test_ntt_data.microserviceback.domain.usecase.ClientUseCase;
import com.test_ntt_data.microserviceback.infrastruture.driven.adapters.ClientDTO;
import com.test_ntt_data.microserviceback.infrastruture.entry.points.ClientInput;
import com.test_ntt_data.microserviceback.shared.error.BadRequestException;
import com.test_ntt_data.microserviceback.shared.error.ClienteNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {
    private final ClientUseCase clientUseCase;

    public ClientController(ClientUseCase clientUseCase) {
        this.clientUseCase = clientUseCase;
    }


    @GetMapping("/clientes")
    public ResponseEntity<?> getClient(
            @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber) {

        try {
            ClientInput validClient = new ClientInput(documentType, documentNumber);
            ClientDTO clientDTO = ClientDTO.fromDomain(clientUseCase.getClient(validClient));
            return ResponseEntity.ok(clientDTO);
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().body("Solicitud inválida: " + e.getMessage());
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error interno: " + e.getMessage());
        }
    }


}
