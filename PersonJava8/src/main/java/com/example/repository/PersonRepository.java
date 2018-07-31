package com.example.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.topic.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}

