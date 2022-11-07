package com.revature.helpinghandapi.dto;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Helper;
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

    public HelperDTO(Helper helper) {
        this.id = helper.getId();
        this.first = helper.getFirst();
        this.last = helper.getLast();
        this.username = helper.getUsername();
    }
}
