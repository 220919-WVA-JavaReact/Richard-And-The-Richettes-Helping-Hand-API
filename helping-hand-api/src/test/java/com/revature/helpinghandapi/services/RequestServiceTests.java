package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.HelpingHandApiApplication;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Availability;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
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

    @Autowired
    private RequestService rut;

    @Test
    public void getRequestByClientIdCorrect() {
        // Arrange
        Date now = new Date();
        Client testClient = new Client();
        testClient.setId("10");
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
        Request returnedRequest = new Request();
        returnedRequest.setClient(testClient);
        returnedRequest.setId("2");
        returnedRequest.setTitle("test");
        returnedRequest.setDescription("test description returned");
        returnedRequest.setDeadline(now);
        returnedRequest.setAvailability(Availability.OPEN);

        Mockito.when(mockRepository.save(returnedRequest)).thenReturn(returnedRequest);

        Request expected = new Request();
        expected.setId("2");
        expected.setClient(testClient);
        expected.setTitle("test");
        expected.setDescription("test description returned");
        expected.setDeadline(now);
        expected.setAvailability(Availability.OPEN);

        RequestDTO actual = rut.createRequest(requestDTO);
        actual.setRequestId(expected.getId());

        assertEquals(expected, actual);
        System.out.println("EXPECTED: " + expected);
        System.out.println("ACTUAL: " + actual);

    }

    @Test
    public void getAllRequests(){

    }

}
