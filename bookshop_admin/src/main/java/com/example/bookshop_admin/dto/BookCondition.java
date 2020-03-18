package com.example.bookshop_admin.dto;

public class BookCondition {
    private String name;
    private  Long id;

    public String getName() {
        return name;
    }

    public void setName(String bookName) {
        this.name = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
