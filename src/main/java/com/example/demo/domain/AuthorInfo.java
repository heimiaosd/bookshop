package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class AuthorInfo extends DomainImpl {

    @OneToOne(mappedBy = "info")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
