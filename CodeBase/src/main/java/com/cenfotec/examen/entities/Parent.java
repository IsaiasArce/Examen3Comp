package com.cenfotec.examen.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Parent implements Serializable {
    @Id
    @Autowired
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String secondPhone;
    @ManyToMany
    Set<Child> children;

    public Parent() {

    }
    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public Parent(Long id, String name, String phone, String address, String secondPhone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.secondPhone = secondPhone;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
