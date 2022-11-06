package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @Column(name = "request_id")
    private String requestId;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadline;

    @Column(nullable = false)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "request")
    Set<Bid> bids;

    public Request() {
    }

    public Request(Client client, String title, String description, Date deadline){
        this.client = client;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Request(String id, Client client, String title, String description, Date deadline) {
        this.requestId = id;
        this.client = client;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public String getId() {
        return requestId;
    }

    public void setId(String id) {
        this.requestId = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(requestId, request.requestId) && Objects.equals(client, request.client) && Objects.equals(title, request.title) && Objects.equals(description, request.description) && Objects.equals(deadline, request.deadline) && Objects.equals(bids, request.bids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, client, title, description, deadline, bids);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + requestId + '\'' +
                ", client=" + client +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", bids=" + bids +
                '}';
    }
}
