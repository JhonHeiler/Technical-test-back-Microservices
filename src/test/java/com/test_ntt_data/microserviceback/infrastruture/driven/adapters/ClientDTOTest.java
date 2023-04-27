package com.test_ntt_data.microserviceback.infrastruture.driven.adapters;

import com.test_ntt_data.microserviceback.domain.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientDTOTest {
private ClientDTO clientDTO;
private Client client;
    @BeforeEach
    void setUp() {
        clientDTO = new ClientDTO("Jhon","Heiler","Mosquera","Cordoba",
            "323496","Victoria","Quibdo");

        clientDTO = new ClientDTO();
        clientDTO.setFirtName("Jhon");
        clientDTO.setSecondName("Heiler");
        clientDTO.setFirtSurname("Mosquera");
        clientDTO.setSecondSurname("Cordoba");
        clientDTO.setPhone("323496");
        clientDTO.setDirection("Victoria");
        clientDTO.setCityResidence("Quibdo");

        client = new Client(2L,
            "Jhon","Heiler","Mosquera","Cordoba",
            "323496","Victoria","Quibdo");
    }

    @Test
    void getFirtName() {
        assertEquals("Jhon", clientDTO.getFirtName());
    }

    @Test
    void getSecondName() {
        assertEquals("Heiler", clientDTO.getSecondName());
    }

    @Test
    void getFirtSurname() {
        assertEquals("Mosquera", clientDTO.getFirtSurname());
    }

    @Test
    void getSecondSurname() {
        assertEquals("Cordoba", clientDTO.getSecondSurname());
    }

    @Test
    void getPhone() {
        assertEquals(323496, clientDTO.getPhone());
    }

    @Test
    void getDirection() {
        assertEquals("Victoria", clientDTO.getDirection());
    }

    @Test
    void getCityResidence() {
        assertEquals("Quibdo", clientDTO.getCityResidence());
    }

    @Test
    void fromDomain() {
        assertNotNull(ClientDTO.fromDomain(client));
    }
}