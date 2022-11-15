package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.HelpingHandApiApplication;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.entities.*;
import com.revature.helpinghandapi.repositories.BidRepository;
import com.revature.helpinghandapi.repositories.HelperRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static com.revature.helpinghandapi.entities.Status.PENDING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest(classes= HelpingHandApiApplication.class)
public class BidTests{

    @MockBean
    private BidRepository br;

    @MockBean
    private RequestRepository rr;

    @MockBean
    private HelperRepository hr;

    @Autowired
    private BidService bs;

    @Test
    public void createBidTest(){
        Client client = new Client();

        Date date = new Date();

        Helper helper = new Helper();
        helper.setId("exampleHelper");
        helper.setUsername("ExampleUser");
        helper.setPassword("ExamplePass");
        helper.setFirst("HelperF");
        helper.setLast("HelperL");

        Request request = new Request();
        request.setId("exampleRequest");
        request.setClient(client);
        request.setTitle("exampleTitle");
        request.setDeadline(date);
        request.setAvailability(Availability.OPEN);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setAmount(250);
        bidDTO.setRequest(request);
        bidDTO.setHelperId(helper.getId());


        BidDTO expectedBidDTO = new BidDTO();
        expectedBidDTO.setAmount(250);
        expectedBidDTO.setHelperId(helper.getId());
        expectedBidDTO.setStatus(PENDING);
        expectedBidDTO.setRequest(request);



        Mockito.when(rr.findById(request.getId())).thenReturn(Optional.of(request));
        Mockito.when(hr.findById(helper.getId())).thenReturn(Optional.of(helper));
        BidDTO actual = bs.createBid(bidDTO);
        expectedBidDTO.setId(actual.getId());
        assertEquals(expectedBidDTO, actual);
        System.out.println("Expected: " + expectedBidDTO);
        System.out.println("Actual: " + actual);
    }

    @Test
    public void getBidByIdExists() {
        Client client = new Client();

        Date date = new Date();

        Helper helper = new Helper();
        helper.setId("exampleHelper");
        helper.setUsername("ExampleUser");
        helper.setPassword("ExamplePass");
        helper.setFirst("HelperF");
        helper.setLast("HelperL");

        Request request = new Request();
        request.setId("exampleRequest");
        request.setClient(client);
        request.setTitle("exampleTitle");
        request.setDeadline(date);
        request.setAvailability(Availability.OPEN);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setAmount(250);
        bidDTO.setRequest(request);
        bidDTO.setHelperId(helper.getId());



//        assertEquals(expected, actual);
    }

    @Test
    public void updateBid() {
        Helper helper = new Helper();
        helper.setId("exampleHelper");

        Bid bid = new Bid();
        bid.setId("exampleBid");
        bid.setAmount(250);
        bid.setStatus(PENDING);
        bid.setHelper(helper);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setId("exampleBid");
        bidDTO.setAmount(150);
        bidDTO.setStatus(PENDING);

        BidDTO updatedBidDTO = new BidDTO();
        updatedBidDTO.setId("exampleBid");
        updatedBidDTO.setHelperId(helper.getId());
        updatedBidDTO.setAmount(150);
        updatedBidDTO.setStatus(PENDING);

        Mockito.when(br.findById(bidDTO.getId())).thenReturn(Optional.of(bid));
        BidDTO actual = bs.updateBid(bidDTO);
        assertEquals(updatedBidDTO, actual);
        System.out.println("Expected: " + updatedBidDTO);
        System.out.println("Actual: " + actual);

    }

//    @Test
//    public void getBidsByHelperId() {
//        Helper helper = new Helper();
//        Bid bid = new Bid();
//
//        helper.setId("exampleRequest");
//
//        Mockito.when(br.findById("exampleRequest")).thenReturn(Optional.of(bid));
//        BidDTO expected
//    }
}
