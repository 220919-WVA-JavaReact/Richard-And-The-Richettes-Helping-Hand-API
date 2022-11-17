package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Client;
import lombok.Data;

@Data
public class ClientDTO {
    private String id;
    private String username;
    private String first;
    private String last;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.first = client.getFirst();
        this.last = client.getLast();
        this.username = client.getUsername();
    }
}
