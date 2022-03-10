package com.example.LibraryManagement.Repository;


import com.example.LibraryManagement.Entitity.UserBookHistoryEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookHistoryRepository extends CrudRepository<UserBookHistoryEntities,Integer> {
}
