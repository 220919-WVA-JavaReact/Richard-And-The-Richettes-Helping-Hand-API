package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Objects;
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


    public Client() {
    }

    public Client(String id, String username, String password, String first, String last) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(username, client.username) && Objects.equals(password, client.password) && Objects.equals(first, client.first) && Objects.equals(last, client.last) && Objects.equals(requests, client.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, first, last, requests);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", requests=" + requests +
                '}';
    }
}
