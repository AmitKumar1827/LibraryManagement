package com.example.LibraryManagement.Repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.Pojo.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RedisRepository {


        private String STUDENT_COLLECTION = "library";
        private RedisTemplate<String ,GetFamousBook> redisTemplate;
        private HashOperations hashOps;


        public RedisRepository(RedisTemplate<String, GetFamousBook> redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        @PostConstruct
        public void init(){
            this.hashOps = this.redisTemplate.opsForHash();
        }

        public List<GetFamousBook> findAll(){
            Map<String , GetFamousBook> allElement = hashOps.entries(STUDENT_COLLECTION);
            return allElement.values().stream().collect(Collectors.toList());
        }

        public void addStudent(GetFamousBook student){
            hashOps.put(STUDENT_COLLECTION,student.getBookid(),student);
        }

        public void delete(Integer id){
            hashOps.delete(STUDENT_COLLECTION,id);

        }
        public void delete(){
            hashOps.delete(STUDENT_COLLECTION);
        }





}
