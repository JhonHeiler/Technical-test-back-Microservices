package com.test_ntt_data.microserviceback.domain.model.gateway;

import com.test_ntt_data.microserviceback.domain.model.Client;
import com.test_ntt_data.microserviceback.infrastruture.entry.points.ClientInput;




public interface ClientRepository {
    Client getClient(ClientInput clientInput);
}
