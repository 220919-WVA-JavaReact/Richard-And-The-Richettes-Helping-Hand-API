package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    private BidRepository br;

    @Autowired
    public BidService(BidRepository br) {
        this.br = br;
    }

    public List<Bid> getAllBids() {
        return br.findAll();
    }

    public Optional<Bid> getBidById(String id) {
        return br.findById(id);
    }
}
