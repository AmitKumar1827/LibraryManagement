package com.example.LibraryManagement.Pojo;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class UserBookHistory {
    @Id
    private Integer id;

    @ManyToOne
    private Integer userId;

    private Integer bookId;
    private String startDate;
    private String endDate;

    public UserBookHistory() {
    }

    public UserBookHistory(Integer id, Integer userId, Integer bookId, String startDate, String endDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UserBookHistory(Integer id, Integer userId, Integer bookId, String startDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
