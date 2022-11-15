package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import static com.revature.helpinghandapi.entities.Status.*;
import com.revature.helpinghandapi.repositories.BidRepository;
import com.revature.helpinghandapi.repositories.HelperRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    private BidRepository br;
    private RequestRepository rr;
    private HelperRepository hr;

    @Autowired
    public BidService(BidRepository br, RequestRepository rr, HelperRepository hr) {
        this.br = br;
        this.rr = rr;
        this.hr = hr;
    }

    public BidDTO createBid(BidDTO bid){
        Bid newBid = new Bid();
        Request request = rr.findById(bid.getRequest().getId()).orElse(null);
        Helper helper = hr.findById(bid.getHelperId()).orElse(null);
        newBid.setHelper(helper);
        newBid.setRequest(request);
        newBid.setAmount(bid.getAmount());
        newBid.setStatus(PENDING);
        br.save(newBid);
        bid.setStatus(PENDING);
        bid.setId(newBid.getId());
        bid.setHelperId(helper.getId());
        return bid;
    } //This takes in a JSON object that contains helperId of the helper making the bid,the requestId that they want to make a bid on and the amount they want to bid


    public BidDTO updateBid(BidDTO bid){
        Bid updatedBid = br.findById(bid.getId()).orElse(null);
        assert updatedBid != null;
        updatedBid.setStatus(bid.getStatus()); //this has to be marked as getBidStatus because the Status is an object
        if(bid.getStatus().equals(PENDING)) {
            updatedBid.setAmount(bid.getAmount());
        }
        br.save(updatedBid);
        if(bid.getStatus().equals(ACCEPTED)){
            closeBid(bid);
        }
        bid.setHelperId(updatedBid.getHelper().getId());
        bid.setStatus(updatedBid.getStatus());
        bid.setAmount(updatedBid.getAmount());
        return bid;
    } //This takes in a JSON object that contains the requestId and allows the Status and amount to be changed

    public void closeBid(BidDTO bidDTO){
        Request request = rr.findById(bidDTO.getRequest().getId()).orElse(null);
        List<Bid> bids = br.findAll();
        for(Bid bid : bids){
            if(bid.getStatus() == PENDING) {
                assert request != null;
                if (bid.getRequest().getId().equals(request.getId())) {
                    bid.setStatus(DECLINED);
                    br.save(bid);
                }
            }
        }
    }

    public List<BidDTO> getAllBids() {
        List<Bid> bids = br.findAll();
        List<BidDTO> bidDTOs = new ArrayList<>();
        for(Bid bid : bids){
            BidDTO bidDTO = new BidDTO();
            bidDTO.setStatus(bid.getStatus());
            bidDTO.setRequest(bid.getRequest());
            bidDTO.setHelperId(bid.getHelper().getId());
            bidDTO.setId(bid.getId());
            bidDTO.setAmount(bid.getAmount());
            bidDTOs.add(bidDTO);
        }
        return bidDTOs;
    }

    public Optional<Bid> getBidById(String id) {
        return br.findById(id);
    }

    public List<BidDTO> getBidsByRequestId(String requestId) {
        return br.findByRequestId(requestId);
    }

    public List<BidDTO> getBidsByHelperId(String helperId) {
        return br.findByHelperId(helperId);
    }
}
