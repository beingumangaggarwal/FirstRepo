package com.example.demo.topic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Iterable<Person> getAllPersons() {

		return personRepository.findAll();
	}

	public Optional<Person> getPerson(String id) {

		return personRepository.findById(id);
	}

	public void savePerson(Person person) {

		personRepository.save(person);
	}

	public void deletePerson(int id) {

		personRepository.deleteById(id);
	}

}
