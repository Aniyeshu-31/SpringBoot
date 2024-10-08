package com.example.demo.dao;
import  com.example.demo.models.Person;
import java.util.*;
import java.util.UUID;
public interface PersonDao{
   // Method Overloaded
   int insertPerson(UUID id,Person person);
   default int insertPerson(Person person){
      UUID id = UUID.randomUUID();
      return insertPerson(id, person);
   }
   List<Person> selectAllPeople();
   Optional<Person> selectPersonById(UUID id);
   int deletePersonById(UUID id);
   int updatePersonById(UUID id,Person person);
}