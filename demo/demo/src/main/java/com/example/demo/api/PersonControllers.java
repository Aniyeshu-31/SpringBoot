package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;
import com.example.demo.service.PersonService;

import io.micrometer.common.lang.NonNull;

import java.util.*;
@RequestMapping("api/v1/person")
@RestController
public class PersonControllers {
    private final PersonService personService;
    @Autowired
    public PersonControllers(PersonService personService){
         this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person personById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    } 
    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
         personService.deletePersonById(id);
    }   
    @PutMapping(path="{id}")
        public void updatePersonById(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody Person newPerson){
              personService.updatePersonById(id,newPerson);
        }
}
