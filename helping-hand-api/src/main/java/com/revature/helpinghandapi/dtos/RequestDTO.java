package com.revature.helpinghandapi.dtos;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import lombok.Data;

import java.util.Date;
import java.util.Objects;
import java.io.Serializable;


@Data
public class RequestDTO {
    private String clientId;
    private String title;

    private String description;

    private Date deadline;

    public RequestDTO(){}

    public RequestDTO(Request request){
        this.clientId = request.getClient().getId();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.deadline = request.getDeadline();
    }

}