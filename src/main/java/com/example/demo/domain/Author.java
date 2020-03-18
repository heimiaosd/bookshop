package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
public class Author extends DomainImpl {

    private String name;

    @Column(columnDefinition = "INT(3)")
    private int age;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> hobbies;

    @ElementCollection
    private List<Address> addressLst;

    @OneToMany(mappedBy = "author")
    @OrderBy("book.name asc")
    private List<BookAuthor> books;

    @OneToOne
    private AuthorInfo info;

    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthorInfo getInfo() {
        return info;
    }

    public void setInfo(AuthorInfo info) {
        this.info = info;
    }

    public List<BookAuthor> getBooks() {
        return books;
    }

    public void setBooks(List<BookAuthor> books) {
        this.books = books;
    }

    public List<Address> getAddressLst() {
        return addressLst;
    }

    public void setAddressLst(List<Address> addressLst) {
        this.addressLst = addressLst;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
