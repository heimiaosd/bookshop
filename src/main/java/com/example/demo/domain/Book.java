package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedEntityGraph(name = "Book.fetch.category.and.author", attributeNodes = {@NamedAttributeNode("category"), @NamedAttributeNode("authors")})
public class Book extends DomainImpl {

    @Version
    private int version;

    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<BookAuthor> authors;

    public List<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<BookAuthor> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
