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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.revature.helpinghandapi.entities.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes= HelpingHandApiApplication.class)
public class BidTests {

    @MockBean
    private BidRepository br;

    @MockBean
    private RequestRepository rr;

    @MockBean
    private HelperRepository hr;

    @Autowired
    private BidService bs;

    @Test
    public void createBidTest() {
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
    public void getBidByRequestIdTest() {
        Client client = new Client();

        Date date = new Date();

        Helper helper = new Helper();
        helper.setId("exampleHelper");
        helper.setUsername("ExampleUser");
        helper.setPassword("ExamplePass");
        helper.setFirst("HelperF");
        helper.setLast("HelperL");

        Helper helper2 = new Helper();
        helper2.setId("2");
        helper2.setUsername("user2");
        helper2.setPassword("pass2");
        helper2.setFirst("first2");
        helper2.setLast("last2");

        Request request = new Request();
        request.setId("exampleRequest");
        request.setClient(client);
        request.setTitle("exampleTitle");
        request.setDeadline(date);
        request.setAvailability(Availability.OPEN);

        Bid bid = new Bid();
        bid.setAmount(250);
        bid.setRequest(request);
        bid.setHelper(helper);
        bid.setStatus(PENDING);

        Bid bid2 = new Bid();
        bid2.setAmount(200);
        bid2.setRequest(request);
        bid2.setHelper(helper2);
        bid2.setStatus(PENDING);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setRequest(request);
        bidDTO.setAmount(250);
        bidDTO.setHelperId(helper.getId());
        bidDTO.setStatus(PENDING);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setRequest(request);
        bidDTO2.setAmount(200);
        bidDTO2.setHelperId(helper2.getId());
        bidDTO2.setStatus(PENDING);

        List<BidDTO> bids = new ArrayList<>();
        bids.add(bidDTO);
        bids.add(bidDTO2);

        Mockito.when(br.findByRequestId("exampleRequest")).thenReturn(bids);
        List<BidDTO> actual = bs.getBidsByRequestId("exampleRequest");
        assertEquals(actual, bids);
        System.out.println("Expected: " + bids);
        System.out.println("Actual: " + actual);
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

    @Test
    public void getBidByHelperIdTest() {
        Client client = new Client();

        Date date = new Date();

        Helper helper = new Helper();
        helper.setId("exampleHelper");
        helper.setUsername("ExampleUser");
        helper.setPassword("ExamplePass");
        helper.setFirst("HelperF");
        helper.setLast("HelperL");


        Request request = new Request();
        request.setId("1");
        request.setClient(client);
        request.setTitle("title1");
        request.setDeadline(date);
        request.setAvailability(Availability.OPEN);

        Request request2 = new Request();
        request2.setId("2");
        request2.setClient(client);
        request2.setTitle("title2");
        request2.setDeadline(date);
        request2.setAvailability(Availability.OPEN);

        Bid bid = new Bid();
        bid.setAmount(250);
        bid.setRequest(request);
        bid.setHelper(helper);
        bid.setStatus(PENDING);

        Bid bid2 = new Bid();
        bid2.setAmount(200);
        bid2.setRequest(request2);
        bid2.setHelper(helper);
        bid2.setStatus(PENDING);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setRequest(request);
        bidDTO.setAmount(250);
        bidDTO.setHelperId(helper.getId());
        bidDTO.setStatus(PENDING);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setRequest(request2);
        bidDTO2.setAmount(200);
        bidDTO2.setHelperId(helper.getId());
        bidDTO2.setStatus(PENDING);

        List<BidDTO> bids = new ArrayList<>();
        bids.add(bidDTO);
        bids.add(bidDTO2);

        Mockito.when(br.findByHelperId("exampleHelper")).thenReturn(bids);

        List<BidDTO> actual = bs.getBidsByHelperId("exampleHelper");
        assertEquals(actual, bids);
        System.out.println("Expected: " + bids);
        System.out.println("Actual: " + actual);
    }

    @Test
    public void getAllBids() {
        Client client = new Client();

        Date date = new Date();

        Helper helper = new Helper();
        helper.setId("exampleHelper");
        helper.setUsername("ExampleUser");
        helper.setPassword("ExamplePass");
        helper.setFirst("HelperF");
        helper.setLast("HelperL");


        Request request = new Request();
        request.setClient(client);
        request.setTitle("title1");
        request.setDeadline(date);
        request.setAvailability(Availability.OPEN);

        Request request2 = new Request();
        request2.setClient(client);
        request2.setTitle("title2");
        request2.setDeadline(date);
        request2.setAvailability(Availability.OPEN);

        Bid bid = new Bid();
        bid.setAmount(250);
        bid.setRequest(request);
        bid.setHelper(helper);
        bid.setStatus(PENDING);

        Bid bid2 = new Bid();
        bid2.setAmount(200);
        bid2.setRequest(request2);
        bid2.setHelper(helper);
        bid2.setStatus(PENDING);

        BidDTO bidDTO = new BidDTO();
        bidDTO.setId(bid.getId());
        bidDTO.setRequest(request);
        bidDTO.setAmount(250);
        bidDTO.setHelperId(helper.getId());
        bidDTO.setStatus(PENDING);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setId(bid2.getId());
        bidDTO2.setRequest(request2);
        bidDTO2.setAmount(200);
        bidDTO2.setHelperId(helper.getId());
        bidDTO2.setStatus(PENDING);

        List<Bid> bids = new ArrayList<>();
        bids.add(bid);
        bids.add(bid2);

        List<BidDTO> bidDTOS = new ArrayList<>();
        bidDTOS.add(bidDTO);
        bidDTOS.add(bidDTO2);

        Mockito.when(br.findAll()).thenReturn(bids);
        List<BidDTO> actual = bs.getAllBids();
        assertEquals(actual, bidDTOS);
        System.out.println("Expected: " + bidDTOS);
        System.out.println("Actual: " + actual);
    }
}
