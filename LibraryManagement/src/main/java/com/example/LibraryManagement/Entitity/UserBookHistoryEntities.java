package com.example.LibraryManagement.Entitity;


import javax.persistence.*;

@Entity
@Table(name = "UserBookHistoryEntities")
public class UserBookHistoryEntities {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer bookId;
    private String startDate;
    private String endDate;

    public UserBookHistoryEntities() {
    }


    public UserBookHistoryEntities(Integer id , Integer userId, Integer bookId, String startDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
    }

    public UserBookHistoryEntities(Integer id, Integer userId, Integer bookId, String startDate, String endDate) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}