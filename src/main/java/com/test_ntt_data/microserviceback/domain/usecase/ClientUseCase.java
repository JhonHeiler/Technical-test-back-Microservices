package com.test_ntt_data.microserviceback.domain.usecase;

import com.test_ntt_data.microserviceback.domain.model.Client;
import com.test_ntt_data.microserviceback.domain.model.gateway.ClientRepository;
import com.test_ntt_data.microserviceback.infrastruture.entry.points.ClientInput;
import com.test_ntt_data.microserviceback.shared.error.BadRequestException;
import com.test_ntt_data.microserviceback.shared.error.ClienteNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class ClientUseCase implements ClientRepository {
    private static final String DOCUMENT_TYPE_C = "C";
    private static final String DOCUMENT_TYPE_P = "P";

    @Override
    public Client getClient(ClientInput clientInput) {
        if (!isValidDocumentType(clientInput.getDocumentType())) {
            throw new BadRequestException("Tipo de documento inválido");
        }

        if (!isValidDocumentNumber(clientInput.getDocumentNumber())) {
            throw new ClienteNotFoundException("Cliente no encontrado");
        }
        return createClient();
    }

    private boolean isValidDocumentType(String documentType) {
        return documentType.equals(DOCUMENT_TYPE_C) || documentType.equals(DOCUMENT_TYPE_P);
    }

    private boolean isValidDocumentNumber(String documentNumber) {
        return documentNumber.equals("23445322");
    }

    private Client createClient() {
        Client client = new Client();
        client.setFirstName("Jhon");
        client.setSecondName("Heiler");
        client.setFirstSurname("Mosquera");
        client.setSecondSurname("Cordoba");
        client.setPhone("1077475328");
        client.setAddrress("Calle 123");
        client.setCityResidence("Quibdo");
        return client;
    }

}
