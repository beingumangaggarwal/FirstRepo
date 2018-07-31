package com.example.controller;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/person")
	public Iterable<Person> getTopics() {

		return personService.getAllPersons();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	public void postPersons(@RequestBody Person person) {

		personRepository.save(person);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
	public void deletePersons(@PathVariable String id) {
		personService.deletePerson(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
	public void updatePersons(@RequestBody Person person) {

		personService.savePerson(person);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/person/{id}")
	@ResponseBody
	public Optional<Person> getPersone(
			@RequestParam(name = "name") String name, @PathVariable String id) {

		Optional<Person> person = personService.getPerson(id);

		person.get().setName(name);

		return personService.getPerson(id);
	}

}
