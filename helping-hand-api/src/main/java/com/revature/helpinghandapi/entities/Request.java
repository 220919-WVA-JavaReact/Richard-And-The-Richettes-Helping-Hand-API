package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @Column(name = "request_id")
    private String id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "client_id")
    private Client client;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadline;

}
