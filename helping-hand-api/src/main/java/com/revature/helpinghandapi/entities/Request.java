package com.revature.helpinghandapi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "requests")
public class Request {

    @Id
    @Column(name= "request_id")
    private String id;

    @ManyToOne
    @JoinColumn(name= "client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date deadline;

    public Request() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) && Objects.equals(client, request.client) && Objects.equals(title, request.title) && Objects.equals(description, request.description) && Objects.equals(deadline, request.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, title, description, deadline);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
