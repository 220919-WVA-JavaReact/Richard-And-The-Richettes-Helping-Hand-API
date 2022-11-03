package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="helpers")
public class Helper {

    @Id
    @Column(name="helper_id")
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first;

    @Column(nullable = false)
    private String last;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "helper")
    Set<Bid> bids;

}