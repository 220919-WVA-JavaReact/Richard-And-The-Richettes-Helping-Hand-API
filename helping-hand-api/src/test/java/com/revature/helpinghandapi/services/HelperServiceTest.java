package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.HelpingHandApiApplication;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.HelperDTO;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.repositories.HelperRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= HelpingHandApiApplication.class)
public class HelperServiceTest {
    @MockBean
    private HelperRepository hr;

    @Autowired
    private HelperService cs;

    @Test
    public void successLogin(){
        Credentials credentials = new Credentials();

        credentials.setUsername("testbobbytables");
        credentials.setPassword("testpassword");

        Helper helper = new Helper();

        helper.setUsername(credentials.getUsername());
        helper.setPassword(credentials.getPassword());

        Mockito.when(hr.getHelperByUsernameAndPassword(credentials.getUsername(), credentials.getPassword())).thenReturn(Optional.of(helper));

        HelperDTO expected = new HelperDTO(helper);

        HelperDTO actual = cs.authenticate(credentials);

        assertEquals(expected, actual);


    }

    @Test
    public void successRegister(){

        Credentials creds = new Credentials();
        creds.setFirst("diffFirst");
        creds.setLast("diffLast");
        creds.setUsername("theUserName");
        creds.setPassword("pass");

        HelperDTO expected = new HelperDTO();
        expected.setId("ten");
        expected.setFirst("diffFirst");
        expected.setLast("diffLast");
        expected.setUsername("theUserName");

        HelperDTO actual = cs.createHelper(creds);

        expected.setId(actual.getId());

        assertEquals(expected, actual);
    }

}
