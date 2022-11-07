package com.revature.helpinghandapi.repositories;

import com.revature.helpinghandapi.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {

}
