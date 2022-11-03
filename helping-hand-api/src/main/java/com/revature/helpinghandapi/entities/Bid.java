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

    @Column(nullable = false)

}