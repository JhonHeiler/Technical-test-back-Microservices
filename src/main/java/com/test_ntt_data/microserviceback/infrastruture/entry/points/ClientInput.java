package com.test_ntt_data.microserviceback.infrastruture.entry.points;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class ClientInput {
    private  String documentType;
    private  String documentNumber;


}
