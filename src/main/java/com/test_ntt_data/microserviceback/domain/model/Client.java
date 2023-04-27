package com.test_ntt_data.microserviceback.domain.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Client {
    private  Long id;
    private  String  firstName;
    private  String  secondName;
    private  String  firstSurname;
    private  String   secondSurname;
    private  String phone;
    private  String  addrress;
    private  String  cityResidence;

    public Client(Long id, String firstName, String secondName, String firstSurname, String secondSurname, String phone, String addrress, String cityResidence) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.phone = phone;
        this.addrress = addrress;
        this.cityResidence = cityResidence;
    }
}
