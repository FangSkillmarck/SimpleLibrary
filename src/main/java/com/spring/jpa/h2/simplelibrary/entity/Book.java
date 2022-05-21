package com.spring.jpa.h2.simplelibrary.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String title;

  private String author;

  private String isbn;

  private String genre;

  private String customerName;

  private boolean borrowed;

  public Book() {
  }

  public Book(String title, String author, String isbn, String genre, String customerName, boolean borrowed) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.genre = genre;
    this.customerName = customerName;
    this.borrowed = borrowed;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public boolean isBorrowed() {
    return borrowed;
  }
  public void setBorrowed(boolean isBorrowed) {
    this.borrowed = isBorrowed;
  }

}