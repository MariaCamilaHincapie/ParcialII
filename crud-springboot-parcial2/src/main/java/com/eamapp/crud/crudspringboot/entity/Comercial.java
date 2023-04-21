package com.eamapp.crud.crudspringboot.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "comercials")
public class Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "lastname1", nullable = false, length = 100)
    private String lastname1;

    @Column(name = "lastname2", nullable = false, length = 100)
    private String lastname2;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region; 

    @Column(name = "comission", nullable = false)
    private Float comission;

    @OneToMany(mappedBy = "", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Comercial() {
    }

    public Comercial(Long id, String name, String lastname1, String lastname2, Region region, Float comission) {
        this.id = id;
        this.name = name;
        this.lastname1 = lastname1;
        this.lastname2 = lastname2;
        this.region = region;
        this.comission = comission;
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

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Float getComission() {
        return comission;
    }

    public void setComission(Float comission) {
        this.comission = comission;
    }

}
