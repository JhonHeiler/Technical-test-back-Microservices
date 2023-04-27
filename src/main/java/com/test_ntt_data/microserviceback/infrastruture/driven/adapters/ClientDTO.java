package com.test_ntt_data.microserviceback.infrastruture.driven.adapters;

import com.test_ntt_data.microserviceback.domain.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ClientDTO {
    private String firtName;
    private String secondName;
    private String firtSurname;
    private String secondSurname;
    private String phone;
    private String direction;
    private String cityResidence;

    public ClientDTO(String firtName, String secondName, String firtSurname, String secondSurname, String phone, String direction, String cityResidence) {
        this.firtName = firtName;
        this.secondName = secondName;
        this.firtSurname = firtSurname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.direction = direction;
        this.cityResidence = cityResidence;
    }

    public static ClientDTO fromDomain(Client client) {
        return new ClientDTO(
                client.getFirstName(),
                client.getSecondName(),
                client.getSecondSurname(),
                client.getSecondSurname(),
                client.getPhone(),
                client.getAddrress(),
                client.getCityResidence()
        );
    }

}
