package com.revature.helpinghandapi.repositories;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {
    List<BidDTO> findByRequestId(String requestId);

    List<BidDTO> findByHelperId(String helperId);
}
