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
public class RequestServiceTest {

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
        expected.setId("1");
        expected.setClientId("10");
        expected.setTitle("test");
        expected.setDescription("test description");
        expected.setDeadline(now);
        expected.setAvailability(Availability.OPEN);
        RequestDTO expected2 = new RequestDTO();
        expected2.setId("2");
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
        expected.setId("2");
        expected.setClientId(testClient.getId());
        expected.setTitle("test");
        expected.setDescription("test description");
        expected.setDeadline(now);
        expected.setAvailability(Availability.OPEN);

        RequestDTO actual = rut.createRequest(requestDTO);
        actual.setId("2");

        assertEquals(expected, actual);
        System.out.println("EXPECTED: " + expected);
        System.out.println("ACTUAL: " + actual);

    }

    @Test
    public void getAllRequests(){
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
        RequestDTO newRequest4 = new RequestDTO();
        newRequest4.setAvailability(Availability.OPEN);
        newRequest4.setId(newRequest.getId());
        newRequest4.setTitle("test");
        newRequest4.setDescription("test description");
        newRequest4.setDeadline(now);
        newRequest4.setClientId(testClient.getId());
        RequestDTO newRequest5 = new RequestDTO();
        newRequest5.setAvailability(Availability.OPEN);
        newRequest5.setId(newRequest2.getId());
        newRequest5.setTitle("test2");
        newRequest5.setDescription("test description 2");
        newRequest5.setDeadline(now);
        newRequest5.setClientId(testClient.getId());
        RequestDTO newRequest6 = new RequestDTO();
        newRequest6.setAvailability(Availability.OPEN);
        newRequest6.setId(newRequest3.getId());
        newRequest6.setTitle("test3");
        newRequest6.setDescription("test description 3");
        newRequest6.setDeadline(now);
        newRequest6.setClientId(testClient2.getId());

        List<Request> requests = new ArrayList<>();
        requests.add(newRequest);
        requests.add(newRequest2);
        requests.add(newRequest3);

        List<RequestDTO> requestsDTO = new ArrayList<>();
        requestsDTO.add(newRequest4);
        requestsDTO.add(newRequest5);
        requestsDTO.add(newRequest6);

        Mockito.when(mockRepository.findAll()).thenReturn(requests);


        List<RequestDTO> actual = rut.getAllRequests();

        assertEquals(actual, requestsDTO);
        System.out.println("EXPECTED: " + requestsDTO);
        System.out.println("ACTUAL: " + actual);


    }

}
