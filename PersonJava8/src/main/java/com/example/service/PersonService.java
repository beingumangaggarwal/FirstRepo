package com.example.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.topic.Person;
import com.example.repository.PersonRepository;

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

	public void deletePerson(String id) {

		personRepository.deleteById(id);
	}

	public void getId() {
		personRepository.findAll();

	}

}
