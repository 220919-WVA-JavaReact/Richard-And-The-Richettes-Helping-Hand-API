package com.revature.helpinghandapi.dto;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import lombok.Data;

import java.util.Set;

@Data
public class HelperDTO {

    private String id;
    private String username;
    private String first;
    private String last;
    Set<Request> requests;

    public HelperDTO(Client client) {
        this.id = client.getId();
        this.first = client.getFirst();
        this.last = client.getLast();
        this.username = client.getUsername();
    }
}
