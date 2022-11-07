package com.revature.helpinghandapi.dtos;

import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

@Data
public class BidDTO {
//    private String id;
    private String helperId;
    private String requestId;
    private float amount;
//    private Status status;

    public BidDTO(){}
    public BidDTO(Bid bid){
//        this.id = bid.getId();
        this.helperId = bid.getHelper().getId();
        this.requestId = bid.getRequest().getId();
        this.amount = bid.getAmount();
//        this.status = bid.getStatus();
    }

//    public StatusDTO(Status status){
//        this.helper = status.getHelper();
//
//    }
}
