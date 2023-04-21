package com.eamapp.crud.crudspringboot.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false, length = 100)
    private String date;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client; 

    @ManyToOne
    @JoinColumn(name = "id_comercial")
    private Comercial comercial; 

    public Order() {
    }  

    public Order(Long id, Double amount, String date, Client client, Comercial comercial) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.client = client;
        this.comercial = comercial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Comercial getComercial() {
        return comercial;
    }

    public void setComercial(Comercial comercial) {
        this.comercial = comercial;
    }

    

}
