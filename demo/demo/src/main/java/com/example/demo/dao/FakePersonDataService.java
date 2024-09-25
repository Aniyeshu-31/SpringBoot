package com.example.demo.dao;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Person;
import java.util.*;
@Repository("fakeDao")
public class FakePersonDataService implements PersonDao{
    private static List<Person> db = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }
    @Override
    public List<Person> selectAllPeople() {
        return db;
    }
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        return db.stream().filter(person->person.getid().equals(id)).findFirst();
    }
    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty())return 0;
        
        db.remove(personMaybe.get());
        return 1;
    }
    @Override
    public int updatePersonById(UUID id, Person person) {
        // TODO Auto-generated method stub

        return selectPersonById(id)
              .map(p->{
            int ind = db.indexOf(p);
            if(ind >= 0){
                db.set(ind,new Person(id, person.getName()));
            }
             return 1;
        }).orElse(0);
    }
    
}