package com.example.library.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name_author")
    private String firstNameAutor;

    @Column(name = "last_name_author")
    private String lastNameAutor;

    public AuthorEntity() {
    }

    public AuthorEntity(String firstNameAutor, String lastNameAutor) {
        this.id = id;
        this.firstNameAutor = firstNameAutor;
        this.lastNameAutor = lastNameAutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstNameAutor() {
        return firstNameAutor;
    }

    public void setFirstNameAutor(String firstNameAutor) {
        this.firstNameAutor = firstNameAutor;
    }

    public String getLastNameAutor() {
        return lastNameAutor;
    }

    public void setLastNameAutor(String lastNameAutor) {
        this.lastNameAutor = lastNameAutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstNameAutor, that.firstNameAutor) && Objects.equals(lastNameAutor, that.lastNameAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstNameAutor, lastNameAutor);
    }

    @Override
    public String toString() {
        return "AutorEntity{" +
                "id=" + id +
                ", firstNameAutor='" + firstNameAutor + '\'' +
                ", lastNameAutor='" + lastNameAutor + '\'' +
                '}';
    }
}
