package com.liroa.garage.service.client;

import com.liroa.garage.domain.client.Client;
import com.liroa.garage.domain.client.DataListClient;
import com.liroa.garage.domain.client.DataRegisterClient;
import com.liroa.garage.domain.client.DataUpdateClient;
import com.liroa.garage.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client createClient(DataRegisterClient dataRegisterClient) {

        Client clients = new Client();
        clients.setName(dataRegisterClient.name());
        clients.setNumber(dataRegisterClient.number());
        clients.setEmail(dataRegisterClient.email());

        return clientRepository.save(clients);
    }

    @Override
    public List<DataListClient> getAllClient() {

        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(
                client -> new DataListClient(
                        client.getIdClient(),
                        client.getName(),
                        client.getNumber(),
                        client.getEmail()
        )).toList();
    }

    @Override
    public Client getClientById(Long idClient) {

        return clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("id not found for get client"));

    }

    @Override
    public Client updateClient(Long idClient, DataUpdateClient dataUpdateClient) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(()-> new RuntimeException("id not found for update client"));

        client.setName(dataUpdateClient.name());
        client.setNumber(dataUpdateClient.number());
        client.setEmail(dataUpdateClient.email());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long idClient) {

        Client client = clientRepository.findById(idClient)
                        .orElseThrow(()-> new RuntimeException("id not found dor delete client"));

        clientRepository.delete(client);
    }


}
