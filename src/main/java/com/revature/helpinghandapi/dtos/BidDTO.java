package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

@Data
public class BidDTO {
    private String helperId;
    private Request request;
    private float amount;
    private String id;
    private Status status;

    public BidDTO(){
        System.out.println("hello");
        System.out.println(this.id);
    }
    public BidDTO(Bid bid){
        this.helperId = bid.getHelper().getId();
        this.request = bid.getRequest();
        this.amount = bid.getAmount();
        this.id = bid.getId();
        this.status = bid.getStatus();
    }


}
