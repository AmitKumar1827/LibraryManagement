package com.example.LibraryManagement.Repository;


import com.example.LibraryManagement.Entitity.UserEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntities, Integer> {
}
