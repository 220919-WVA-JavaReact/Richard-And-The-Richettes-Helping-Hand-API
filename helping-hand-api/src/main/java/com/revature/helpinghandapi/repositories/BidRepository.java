package com.revature.helpinghandapi.repositories;
import com.revature.helpinghandapi.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {
//equals DAO

//    Bid createBid(String id, Helper helper, Request request, float amount, Status status);

//    Bid updateBid(String id, Status status);
}
