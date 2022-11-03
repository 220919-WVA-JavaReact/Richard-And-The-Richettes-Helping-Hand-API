package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @Column(name = "request_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadline;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "request")
    Set<Bid> bids;

}
