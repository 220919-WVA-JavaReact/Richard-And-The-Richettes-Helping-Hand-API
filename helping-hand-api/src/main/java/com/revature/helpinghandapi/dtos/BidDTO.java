package com.revature.helpinghandapi.dtos;

import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

@Data
public class BidDTO {
//    private String id;
    private Helper helper;
    private Request request;
    private float amount;
//    private Status status;

    public BidDTO(){}
    public BidDTO(Bid bid){
//        this.id = bid.getId();
        this.helper = bid.getHelper();
        this.request = bid.getRequest();
        this.amount = bid.getAmount();
//        this.status = bid.getStatus();
    }
}
