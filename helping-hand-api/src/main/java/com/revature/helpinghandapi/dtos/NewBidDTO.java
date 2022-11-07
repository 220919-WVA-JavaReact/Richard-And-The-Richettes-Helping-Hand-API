package com.revature.helpinghandapi.dtos;

import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import lombok.Data;

@Data
public class NewBidDTO {
    private Helper helper;
    private Request request;
    private float amount;
}
