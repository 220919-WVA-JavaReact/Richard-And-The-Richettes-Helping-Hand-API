package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @Column(name="client_id")
    private String id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String first;

    @Column(nullable = false)
    private String last;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    Set<Request> requests;

}
