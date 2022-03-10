package com.example.LibraryManagement.Entitity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "BooksEntities")
public class BooksEntities {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String Name;

    private String writer;
    private String summary;
    private String category;

    public BooksEntities() {
    }

    public BooksEntities(int id, String name, String writer, String summary, String category) {
        this.id = id;
        this.Name = name;
        this.writer = writer;
        this.summary = summary;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

//BooksEntities
//--id
//--name
//--writer
//--summary
//--category