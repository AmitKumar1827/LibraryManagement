package com.example.LibraryManagement.Controller;



import com.example.LibraryManagement.Pojo.Books;
import com.example.LibraryManagement.Pojo.User;
import com.example.LibraryManagement.Pojo.UserBookHistory;
import com.example.LibraryManagement.Services.ServiceApiImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("Services")
public class ServiceController {
    @Autowired
    ServiceApiImplementation serviceApiImplementation;


    @PostMapping(value = "/Book",consumes = "application/json")
    public void addBooks(@RequestBody @Valid Books books) {
        serviceApiImplementation.addBook(books);
    }

    @PostMapping(value = "/User", consumes = "application/json")
    public void addUser(@RequestBody @Valid User user) {
        serviceApiImplementation.addUser(user);
    }

    @PostMapping(value="/Issue" , consumes = "application/json")
    public void Issue(@RequestBody @Valid UserBookHistory userBookHistory){
        serviceApiImplementation.addIssue(userBookHistory);
    }

    @PutMapping(value="/Return" , consumes = "application/json")
    public UserBookHistory returnDate(@RequestBody @Valid UserBookHistory userBookHistory){

            return serviceApiImplementation.addReturnDate(userBookHistory);

    }

    @GetMapping(value = "/getfamousbook")
    public Books getAllImformationBook() {
        return serviceApiImplementation.getPopularBook();
    }

    @GetMapping(value = "/getuser")
    public User getImformationUserMaxBooks(){
        return serviceApiImplementation.getUserWithMaxBook();
    }




}
