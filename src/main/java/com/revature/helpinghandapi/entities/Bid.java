package com.revature.helpinghandapi.entities;
import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @Column(name = "bid_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "helper_id", referencedColumnName = "helper_id")
    private Helper helper;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private Request request;

    @Column(nullable = false)
    private float amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Bid() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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
        Bid bid = (Bid) o;
        return Float.compare(bid.amount, amount) == 0 && Objects.equals(id, bid.id) && Objects.equals(helper, bid.helper) && Objects.equals(request, bid.request) && status == bid.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, helper, request, amount, status);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id='" + id + '\'' +
                ", helper=" + helper +
                ", request=" + request +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}