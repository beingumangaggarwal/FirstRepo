package com.example.demo.topic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/person")
	public Iterable<Person> getTopics() {

		return personService.getAllPersons();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	public void postPersons(@RequestBody Person person) {

		personService.savePerson(person);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
	public void deletePersons(@PathVariable int id) {
		personService.deletePerson(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/person/{id}")
	public Optional<Person> getPerson(@PathVariable String id) {

		return personService.getPerson(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
	public void updatePersons(@RequestBody Person person) {

		personService.savePerson(person);

	}

}
