package com.test_ntt_data.microserviceback.domain.usecase;

import com.test_ntt_data.microserviceback.domain.model.Client;
import com.test_ntt_data.microserviceback.domain.model.gateway.ClientRepository;
import com.test_ntt_data.microserviceback.infrastruture.entry.points.ClientInput;
import com.test_ntt_data.microserviceback.shared.error.BadRequestException;
import com.test_ntt_data.microserviceback.shared.error.ClienteNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ClientUseCaseTest {
    private ClientUseCase clientUseCase;

    @BeforeEach
    public void setUp() {
        clientUseCase = new ClientUseCase();
    }

    @Test
    public void testGetClient_ValidInput_ReturnsClient() {
        // Arrange
        ClientInput clientInput = new ClientInput();
        clientInput.setDocumentType("C");
        clientInput.setDocumentNumber("23445322");

        // Act
        Client client = clientUseCase.getClient(clientInput);

        // Assert
        Assertions.assertNotNull(client);
        Assertions.assertEquals("Jhon", client.getFirstName());
        Assertions.assertEquals("Heiler", client.getSecondName());
        Assertions.assertEquals("Mosquera", client.getFirstSurname());
        Assertions.assertEquals("Cordoba", client.getSecondSurname());
        Assertions.assertEquals("1077475328", client.getPhone());
        Assertions.assertEquals("Calle 123", client.getAddrress());
        Assertions.assertEquals("Quibdo", client.getCityResidence());
    }

    @Test
    public void testGetClient_InvalidDocumentType_ThrowsBadRequestException() {
        // Arrange
        ClientInput clientInput = new ClientInput();
        clientInput.setDocumentType("InvalidType");
        clientInput.setDocumentNumber("23445322");

        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> {
            clientUseCase.getClient(clientInput);
        });
    }

    @Test
    public void testGetClient_InvalidDocumentNumber_ThrowsClienteNotFoundException() {
        // Arrange
        ClientInput clientInput = new ClientInput();
        clientInput.setDocumentType("P");
        clientInput.setDocumentNumber("InvalidNumber");

        // Act & Assert
        Assertions.assertThrows(ClienteNotFoundException.class, () -> {
            clientUseCase.getClient(clientInput);
        });
    }
}