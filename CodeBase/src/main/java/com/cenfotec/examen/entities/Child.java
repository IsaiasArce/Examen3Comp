package com.cenfotec.examen.entities;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Child {
    @Id
    @Autowired
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String plan;
    private String alergies;
    @OneToMany
    Set<Book> books;

    public Long getId() {
        return id;
    }

    public Child() {
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

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
