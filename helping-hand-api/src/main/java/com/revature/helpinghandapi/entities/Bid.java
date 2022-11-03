package com.revature.helpinghandapi.entities;

import javax.persistence.*;

@Entity
@Table(name="bids")
public class Bid {

    @Id
    @Column(name = "bid_id")
    private String id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "helper_id")
    private Helper helper;

    @ManyToOne
    @JoinColumn(referencedColumnName = "request_id")
    private Request request;

    @Column(nullable = false)
    private float amount;

    @Enumerated(EnumType.STRING)
    private Status status;
}