package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category extends DomainImpl {

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> bookLst;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
