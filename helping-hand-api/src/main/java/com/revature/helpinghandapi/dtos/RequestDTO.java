package com.revature.helpinghandapi.dtos;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

import java.util.Objects;
import java.io.Serializable;


@Data
public class RequestDTO {
    private String id;
    private String title;
    private Client clientId;
    private Status status;

    public RequestDTO(){}

    public RequestDTO(Request request){
        this.id = request.getId();
        this.title = request.getTitle();
        this.clientId = request.getClient();
        this.status = request.getStatus();
    }

}