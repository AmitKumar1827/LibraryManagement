package com.example.LibraryManagement.Services;

import java.util.List;
import com.example.LibraryManagement.Pojo.*;

public interface ServiceApi
{
    public void addBook(Books books);
    public void addUser(User user);
    public List<Books> getBooks();
    public void addIssue(UserBookHistory userBookHistory);
    public UserBookHistory addReturnDate(UserBookHistory userBookHistory);
    public Books getPopularBook();
    public User getUserWithMaxBook();
}
