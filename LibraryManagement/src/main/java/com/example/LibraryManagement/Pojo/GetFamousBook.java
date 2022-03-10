package com.example.LibraryManagement.Pojo;

import java.io.Serializable;


public class GetFamousBook implements Serializable {

    private  Integer bookid;
    private   String name;
    private   String writer;
    private  String summary;
    private   String category;
    private  Integer NoOfActiveUser;

    public GetFamousBook( Integer bookid, String name, String writer, String summary, String category, Integer noOfActiveUser) {

//        this.id = id;
        this.bookid = bookid;
        this.name = name;
        this.writer = writer;
        this.summary = summary;
        this.category = category;
        NoOfActiveUser = noOfActiveUser;
    }


    public GetFamousBook() {
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getNoOfActiveUser() {
        return NoOfActiveUser;
    }

    public void setNoOfActiveUser(Integer noOfActiveUser) {
        NoOfActiveUser = noOfActiveUser;
    }
}