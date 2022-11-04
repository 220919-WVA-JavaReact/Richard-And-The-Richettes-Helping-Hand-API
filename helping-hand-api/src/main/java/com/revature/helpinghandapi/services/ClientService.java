package com.revature.helpinghandapi.services;


import com.revature.helpinghandapi.dto.ClientDTO;
import com.revature.helpinghandapi.dto.Credentials;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository cr;

    @Autowired
    public ClientService(ClientRepository cr) {
        this.cr = cr;
    }

    public ClientDTO createClient(Credentials cred){


        if(cr.getClientByUsername(cred.getUsername()).isPresent()) {

        }
        Client newClient = new Client();

        newClient.setFirst(cred.getFirst());
        newClient.setLast(cred.getLast());
        newClient.setUsername(cred.getUsername());
        newClient.setPassword(cred.getPassword());
        return new ClientDTO(cr.save(newClient));
    }
}
