package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Bid;
import lombok.Data;

@Data
public class BidDTO {
    private String helperId;
    private String requestId;
    private float amount;

    public BidDTO(){}
    public BidDTO(Bid bid){
        this.helperId = bid.getHelper().getId();
        this.requestId = bid.getRequest().getId();
        this.amount = bid.getAmount();
    }

}
