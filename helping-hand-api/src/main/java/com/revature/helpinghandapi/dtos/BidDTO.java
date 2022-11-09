package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

@Data
public class BidDTO {
    private String helperId;
    private String requestId;
    private float amount;
    private String bidId;
    private Status bidStatus;

    public BidDTO(){}
    public BidDTO(Bid bid){
        this.helperId = bid.getHelper().getId();
        this.requestId = bid.getRequest().getId();
        this.amount = bid.getAmount();
        this.bidId = bid.getId();
        this.bidStatus = bid.getStatus();
    }


}
