package com.example.LibraryManagement.Repository;


import com.example.LibraryManagement.Entitity.BooksEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntities, Integer> {
}
