package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.repositories.BidRepository;
import com.revature.helpinghandapi.repositories.HelperRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.revature.helpinghandapi.entities.Status.PENDING;
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
    
    public Bid createBid(BidDTO bid){
        Bid newBid = new Bid();
        Request request = rr.findById(bid.getRequestId()).orElse(null);
        Helper helper = hr.findById(bid.getHelperId()).orElse(null);
        newBid.setHelper(helper);
        newBid.setRequest(request);
        newBid.setAmount(bid.getAmount());
        newBid.setStatus(PENDING);
        br.save(newBid);
        return newBid;
    }


    public List<Bid> getAllBids() {
        return br.findAll();
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
