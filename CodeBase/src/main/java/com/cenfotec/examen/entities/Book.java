package com.cenfotec.examen.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @Autowired
    @Column(name = "ID", nullable = false)
    private  Long id;

    @Column(name = "name")
    private  String name;
    @Column(name = "child")
    @ManyToOne(fetch = FetchType.LAZY)
    private Child child;
    public Long getId() {
        return id;
    }
    @Column(name = "status")
    private int status ;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}