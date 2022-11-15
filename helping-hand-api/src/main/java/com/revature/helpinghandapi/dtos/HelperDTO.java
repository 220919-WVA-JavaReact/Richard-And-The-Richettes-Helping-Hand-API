package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Helper;
import lombok.Data;

@Data
public class HelperDTO {

    private String id;
    private String username;
    private String first;
    private String last;

    public HelperDTO() {
    }

    public HelperDTO(Helper helper) {
        this.id = helper.getId();
        this.first = helper.getFirst();
        this.last = helper.getLast();
        this.username = helper.getUsername();
    }
}
