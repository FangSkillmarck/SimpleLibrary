package com.spring.jpa.h2.simplelibrary.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;

  private String author;

  private String isbn;

  private String genre;

  private String ReaderName;

  private boolean borrowed = Boolean.FALSE;

  public Book(String title, String author, String isbn, String genre, String readerName, boolean b) {
  }

  public boolean isBorrowed() {
    return borrowed;
  }
  public void setBorrowed(boolean isBorrowed) {
    this.borrowed = isBorrowed;
  }


}
