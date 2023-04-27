package com.test_ntt_data.microserviceback.infrastruture.entry.points;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientInputTest {
    private ClientInput clientInput;
    @BeforeEach
    void setUp() {
        clientInput = new ClientInput("B","1077");
        clientInput = new ClientInput();
        clientInput.setDocumentType("C");
        clientInput.setDocumentNumber("10");
    }

    @Test
    void getDocumentType() {
        assertEquals("C", clientInput.getDocumentType());
    }

    @Test
    void getDocumentNumber() {
        assertEquals("10", clientInput.getDocumentNumber());
    }

    @Test
    void toBuilder() {
        ClientInput clientInput1 = ClientInput.builder().documentType("P").build();
        assertEquals("P",clientInput1.getDocumentType());
    }
}