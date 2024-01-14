package com.example.library.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "year_created")
    private Integer yearCreat;

    @Column(name = "author_id")
    private Integer authorId;

    public BookEntity() {
    }

    public BookEntity(String nameBook, Integer yearCreat, Integer authorId) {
        this.nameBook = nameBook;
        this.yearCreat = yearCreat;
        this.authorId = authorId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getYearCreat() {
        return yearCreat;
    }

    public void setYearCreat(Integer yearCreat) {
        this.yearCreat = yearCreat;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nameBook, that.nameBook) && Objects.equals(yearCreat, that.yearCreat) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameBook, yearCreat, authorId);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", yearCreat=" + yearCreat +
                ", authorId=" + authorId +
                '}';
    }
}
