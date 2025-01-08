package com.liroa.garage.controller;

import com.liroa.garage.domain.client.Client;
import com.liroa.garage.domain.client.DataListClient;
import com.liroa.garage.domain.client.DataRegisterClient;
import com.liroa.garage.domain.client.DataUpdateClient;
import com.liroa.garage.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody DataRegisterClient dataRegisterClient){

            Client client = clientService.createClient(dataRegisterClient);
            return new ResponseEntity<>(client , HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<DataListClient>> getAllClient(){
        return ResponseEntity.ok(clientService.getAllClient());
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<Client> getClientById(@PathVariable Long idClient ){
        return ResponseEntity.ok(clientService.getClientById(idClient));
    }

    @PutMapping("/{idClient}")
    public ResponseEntity<?> updateClient (@PathVariable Long idClient, @RequestBody DataUpdateClient dataUpdateClient){

        Client client = clientService.updateClient(idClient, dataUpdateClient);

        return ResponseEntity.ok(new DataUpdateClient(client.getName(), client.getNumber(), client.getEmail()));

    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient){

        clientService.deleteClient(idClient);

        return ResponseEntity.noContent().build();

    }



}
