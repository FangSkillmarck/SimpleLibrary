package com.spring.jpa.h2.simplelibrary.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();


    public Customer() {
    }

    public Customer(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
