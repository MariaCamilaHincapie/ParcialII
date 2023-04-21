package com.eamapp.crud.crudspringboot.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY)
    private List<Client> client;

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY)
    private List<Comercial> comercial;

    public Region(Long id, String name, List<Client> client, List<Comercial> comercial) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.comercial = comercial;
    }

    public Region() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public List<Comercial> getComercial() {
        return comercial;
    }

    public void setComercial(List<Comercial> comercial) {
        this.comercial = comercial;
    }
}
