package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.exceptions.LoginException;
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
            // adding validation later
        }
        Client newClient = new Client();
        newClient.setFirst(cred.getFirst());
        newClient.setLast(cred.getLast());
        newClient.setUsername(cred.getUsername());
        newClient.setPassword(cred.getPassword());
        return new ClientDTO(cr.save(newClient));
    }

    public ClientDTO authenticate(Credentials cred) {
        Client client = cr.getClientByUsernameAndPassword(cred.getUsername(), cred.getPassword()).orElseThrow(LoginException::new);
        if(cred.getUsername() != client.getUsername() || cred.getPassword() != client.getPassword()){
            // adding validation later
        }
        return new ClientDTO(client);
    }
}
