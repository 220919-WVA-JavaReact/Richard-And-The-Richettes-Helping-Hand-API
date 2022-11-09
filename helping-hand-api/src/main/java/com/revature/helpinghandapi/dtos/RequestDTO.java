package com.revature.helpinghandapi.dtos;
import com.revature.helpinghandapi.entities.Request;
import lombok.Data;
import java.util.Date;

@Data
public class RequestDTO {
    private String clientId;
    private String title;
    private String description;
    private Date deadline;
    private String id;

    public RequestDTO(){}

    public RequestDTO(Request request){
        this.clientId = request.getClient().getId();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.deadline = request.getDeadline();
        this.id = request.getId();
    }

}