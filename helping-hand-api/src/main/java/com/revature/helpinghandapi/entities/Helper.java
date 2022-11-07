package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

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

    public Helper() {
        this.id = UUID.randomUUID().toString();
    }

    public Helper(String id, String username, String password, String first, String last, Set<Bid> bids) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
        this.bids = bids;
    }

    public Helper(String username, String password, String first, String last, Set<Bid> bids) {
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
        this.bids = bids;
    }

    public Helper(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helper helper = (Helper) o;
        return Objects.equals(id, helper.id) && Objects.equals(username, helper.username) && Objects.equals(password, helper.password) && Objects.equals(first, helper.first) && Objects.equals(last, helper.last) && Objects.equals(bids, helper.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, first, last, bids);
    }

    @Override
    public String toString() {
        return "Helper{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", bids=" + bids +
                '}';
    }
}