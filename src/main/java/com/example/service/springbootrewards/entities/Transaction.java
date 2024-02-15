package com.example.service.springbootrewards.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Transaction extends Reward {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Customer customer;

    private Double total;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date saveDate;

    public Transaction(Long id, Customer customer, Double total, String description, Date date) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.description = description;
        this.saveDate = date;
    }

    public Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getPoints() {
        this.points = 0l;
        if (this.total > 50 && this.total <= 100) {
            this.points += (this.total.intValue() - 50) * 1;
        }
        if (this.total > 100) {
            this.points += 50;  //1 point for every dollar spent over $50
            this.points += (this.total.intValue() - 100) * 2;  //2 points for every dollar spent over $100
        }
        return this.points;
    }

    @Override
    public String toString() {
        return String.format("Transaction [id=%s, customer=%s, total=%s, description=%s, saveDate=%s]", id, customer,
                total, description, saveDate);
    }

}
