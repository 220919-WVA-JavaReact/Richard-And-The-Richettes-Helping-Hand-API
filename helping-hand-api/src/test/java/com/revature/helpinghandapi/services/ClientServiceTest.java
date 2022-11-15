package com.revature.helpinghandapi.services;


import com.revature.helpinghandapi.HelpingHandApiApplication;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= HelpingHandApiApplication.class)
public class ClientServiceTest {
    @MockBean
    private ClientRepository cr;

    @Autowired
    private ClientService cs;

    @Test
    public void successLogin(){
        Credentials credentials = new Credentials();

        credentials.setUsername("testbobbytables");
        credentials.setPassword("testpassword");

        Client client = new Client();

        client.setUsername(credentials.getUsername());
        client.setPassword(credentials.getPassword());

        Mockito.when(cr.getClientByUsernameAndPassword(credentials.getUsername(), credentials.getPassword())).thenReturn(Optional.of(client));

        ClientDTO expected = new ClientDTO(client);

        ClientDTO actual = cs.authenticate(credentials);

        assertEquals(expected, actual);


    }

}
