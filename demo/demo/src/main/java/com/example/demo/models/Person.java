package com.example.demo.models;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class Person{
     private final UUID id;
     @NotBlank
     private final String name;

     public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name){
           this.name = name;
           this.id = id;
       }
       public String getName(){
           return name;
       }
       public UUID getid(){
          return id;
       }
}
