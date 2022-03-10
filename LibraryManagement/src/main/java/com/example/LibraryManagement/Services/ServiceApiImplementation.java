package com.example.LibraryManagement.Services;




import com.example.LibraryManagement.Entitity.BooksEntities;
import com.example.LibraryManagement.Entitity.UserBookHistoryEntities;
import com.example.LibraryManagement.Entitity.UserEntities;
import com.example.LibraryManagement.Pojo.Books;
import com.example.LibraryManagement.Pojo.GetFamousBook;
import com.example.LibraryManagement.Pojo.User;
import com.example.LibraryManagement.Pojo.UserBookHistory;
import com.example.LibraryManagement.Repository.BooksRepository;
import com.example.LibraryManagement.Repository.RedisRepository;
import com.example.LibraryManagement.Repository.UserBookHistoryRepository;
import com.example.LibraryManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceApiImplementation implements ServiceApi {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    UserBookHistoryRepository userBookHistoryRepository;

    @Autowired
    RedisRepository redisRepository;


    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
    public static <T> Integer mostCommonFreq(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getValue();
    }




    public int count(){
        Iterable<UserBookHistoryEntities> iterable = userBookHistoryRepository.findAll();
        List<UserBookHistory> list = new ArrayList<>();
        for (UserBookHistoryEntities i : iterable) {
            list.add(new UserBookHistory(i.getId(), i.getUserId(), i.getBookId(), i.getStartDate()));
        }
        ArrayList<Integer> bookid = new ArrayList<>();
        for (UserBookHistory i : list) {
            bookid.add(i.getBookId());
        }

        Integer maxId = mostCommon(bookid);
        return maxId;
    }
    public int countUser(){
        Iterable<UserBookHistoryEntities> iterable = userBookHistoryRepository.findAll();
        List<UserBookHistory> list = new ArrayList<>();
        for (UserBookHistoryEntities i : iterable) {
            list.add(new UserBookHistory(i.getId(), i.getUserId(), i.getBookId(), i.getStartDate()));
        }
        ArrayList<Integer> bookid = new ArrayList<>();
        for (UserBookHistory i : list) {
            bookid.add(i.getBookId());
        }

        Integer maxId = mostCommon(bookid);
        return maxId;
    }

    @Override
    public void addBook(Books books) {
        booksRepository.save(new BooksEntities(books.getId(), books.getName(), books.getWriter(), books.getSummary(),
                books.getCategory()));

    }

    @Override
    public void addUser(User user) {
        userRepository.save(new UserEntities(user.getId(), user.getName(), user.getAddress(), user.getPhoneNumber()));

    }

    public List<Books> getBooks() {
        Iterable<BooksEntities> booksEntitiesList = booksRepository.findAll();
        List<Books> list = new ArrayList<>();
        for (BooksEntities b : booksEntitiesList) {
            list.add(new Books(b.getId(), b.getName(), b.getWriter(), b.getSummary(), b.getCategory()));
        }
        return list;

    }

    @Override
    public void addIssue(UserBookHistory userBookHistory) {


//
//            Integer max = count();
//            Integer maxFreq = countUser();
//            Iterable<BooksEntities> books = booksRepository.findAll();
//            GetFamousBook books1 = new GetFamousBook();
//
//            for (BooksEntities i : books) {
//                if (i.getId() == max) {
//                    books1.setBookid(i.getId());
//                    books1.setName(i.getName());
//                    books1.setWriter(i.getWriter());
//                    books1.setSummary(i.getSummary());
//                    books1.setCategory(i.getCategory());
////                    books1.setNoOfActiveUser(maxFreq);
//
//                }
//            }
//            redisRepository.addStudent(books1);
            userBookHistoryRepository.save(new UserBookHistoryEntities(userBookHistory.getId(), userBookHistory.getUserId(),
                    userBookHistory.getBookId(), userBookHistory.getStartDate()));

        }

    @Override
    public UserBookHistory addReturnDate(UserBookHistory userBookHistory)  {
        String date = "";
        boolean isPresent = false;
        Iterable<UserBookHistoryEntities> iterable = userBookHistoryRepository.findAll();
        for (UserBookHistoryEntities i : iterable) {
            if (i.getBookId() == userBookHistory.getBookId() && i.getUserId() == userBookHistory.getUserId()) {
                date = i.getStartDate();
                isPresent = true;

            }
        }

        if (isPresent) {
            userBookHistoryRepository.save(new UserBookHistoryEntities(userBookHistory.getId(), userBookHistory.getUserId(),
                    userBookHistory.getBookId()
                    , date, userBookHistory.getEndDate()));
            return userBookHistory;
        } else {
            return null;
            //throw new exception
        }
    }

    @Override
    public Books getPopularBook() {




//        Iterable<UserBookHistoryEntities> iterable = userBookHistoryRepository.findAll();
//        List<UserBookHistory> list = new ArrayList<>();
//        for (UserBookHistoryEntities i : iterable) {
//            list.add(new UserBookHistory(i.getId(), i.getUserId(), i.getBookId(), i.getStartDate()));
//        }
//        ArrayList<Integer> bookid = new ArrayList<>();
//        for (UserBookHistory i : list) {
//            bookid.add(i.getBookId());
//        }
//
//        Integer maxId = mostCommon(bookid);

//        List<GetFamousBook>list = redisRepository.findAll();


            Integer maxId = count();

            Iterable<BooksEntities> books = booksRepository.findAll();
            Books books1 = new Books();
            GetFamousBook getFamousBook = new GetFamousBook();
            for (BooksEntities i : books) {
                if (i.getId() == maxId) {
                    books1.setId(i.getId());
                    books1.setName(i.getName());
                    books1.setWriter(i.getWriter());
                    books1.setSummary(i.getSummary());
                    books1.setCategory(i.getCategory());

                }
            }

//            GetFamousBook getFamousBook1 = new GetFamousBook(books1.getId() , books1.getName() ,
//                    books1.getWriter() , books1.getSummary(), books1.getCategory() , countUser());
//            redisRepository.addStudent(getFamousBook1);

            return books1;




    }

    @Override
    public User getUserWithMaxBook() {
//        Iterable<UserBookHistoryEntities> iterable = userBookHistoryRepository.findAll();
//        List<UserBookHistory> list = new ArrayList<>();
//        for (UserBookHistoryEntities i : iterable) {
//            list.add(new UserBookHistory(i.getId(), i.getUserId(), i.getBookId(), i.getStartDate()));
//        }
//        ArrayList<Integer> userId = new ArrayList<>();
//        for (UserBookHistory i : list) {
//            userId.add(i.getUserId());
//        }
//
//        Integer max = mostCommon(userId);

        Integer max = countUser();

        Iterable<UserEntities> userEntities = userRepository.findAll();
        User user = new User();
        for (UserEntities i : userEntities) {
            if (i.getId() == max) {
                user.setId(i.getId());
                user.setName(i.getName());
                user.setAddress(i.getAddress());
                user.setPhoneNumber(i.getPhoneNumber());

            }
        }
        return user;
    }
}
