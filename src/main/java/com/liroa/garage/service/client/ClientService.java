package com.liroa.garage.service.client;

import com.liroa.garage.domain.client.Client;
import com.liroa.garage.domain.client.DataListClient;
import com.liroa.garage.domain.client.DataRegisterClient;
import com.liroa.garage.domain.client.DataUpdateClient;

import java.util.List;

public interface ClientService {

    Client createClient (DataRegisterClient dataRegisterClient);

    List<DataListClient> getAllClient();

    Client getClientById (Long idClient);

    Client updateClient (Long idClient, DataUpdateClient dataUpdateClient);

    void deleteClient(Long idClient);
}
