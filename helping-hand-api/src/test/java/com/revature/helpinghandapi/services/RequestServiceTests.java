package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.HelpingHandApiApplication;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Availability;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.repositories.ClientRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes= HelpingHandApiApplication.class)
public class RequestServiceTests {

    @MockBean
    RequestRepository mockRepository;

    @MockBean
    ClientRepository cr;

    @Autowired
    private RequestService rut;

    @Test
    public void getRequestByClientIdCorrect() {
        // Arrange
        Date now = new Date();
        Client testClient = new Client();
        testClient.setId("10");
        Client testClient2 = new Client();
        testClient2.setId("11");
        Request newRequest = new Request();
        newRequest.setAvailability(Availability.OPEN);
        newRequest.setId("1");
        newRequest.setTitle("test");
        newRequest.setDescription("test description");
        newRequest.setDeadline(now);
        newRequest.setClient(testClient);
        Request newRequest2 = new Request();
        newRequest2.setAvailability(Availability.OPEN);
        newRequest2.setId("2");
        newRequest2.setTitle("test2");
        newRequest2.setDescription("test description 2");
        newRequest2.setDeadline(now);
        newRequest2.setClient(testClient);
        Request newRequest3 = new Request();
        newRequest3.setAvailability(Availability.OPEN);
        newRequest3.setId("3");
        newRequest3.setTitle("test3");
        newRequest3.setDescription("test description 3");
        newRequest3.setDeadline(now);
        newRequest3.setClient(testClient2);

        RequestDTO expected = new RequestDTO();
        expected.setRequestId("1");
        expected.setClientId("10");
        expected.setTitle("test");
        expected.setDescription("test description");
        expected.setDeadline(now);
        expected.setAvailability(Availability.OPEN);
        RequestDTO expected2 = new RequestDTO();
        expected2.setRequestId("2");
        expected2.setClientId("10");
        expected2.setTitle("test2");
        expected2.setDescription("test description 2");
        expected2.setDeadline(now);
        expected2.setAvailability(Availability.OPEN);

        List<RequestDTO> requests = new ArrayList<>();
        requests.add(expected);
        requests.add(expected2);


        Mockito.when(mockRepository.findRequestsByClientId(expected.getClientId())).thenReturn(requests);

        // Act
        List<RequestDTO> actual = rut.getRequestsByClientId("10");
        // Assert
        assertEquals(actual, requests);
        System.out.println("EXPECTED: " + requests);
        System.out.println("ACTUAL: " + actual);
    }

    @Test
    public void createRequestCorrect(){
        Date now = new Date();
        Client testClient = new Client();
        testClient.setId("1");
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setTitle("test");
        requestDTO.setDescription("test description");
        requestDTO.setDeadline(now);
        requestDTO.setClientId(testClient.getId());

        Mockito.when(cr.findById(testClient.getId())).thenReturn(Optional.of(testClient));

        RequestDTO expected = new RequestDTO();
        expected.setRequestId("2");
        expected.setClientId(testClient.getId());
        expected.setTitle("test");
        expected.setDescription("test description");
        expected.setDeadline(now);
        expected.setAvailability(Availability.OPEN);

        RequestDTO actual = rut.createRequest(requestDTO);
        actual.setRequestId("2");

        assertEquals(expected, actual);
        System.out.println("EXPECTED: " + expected);
        System.out.println("ACTUAL: " + actual);

    }

    @Test
    public void getAllRequests(){

    }

}
