package com.example.demo.topic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/save")
	public String process() {
		personService.savePerson(new Person("1", "Smith",34,9823434));
		personService.savePerson(new Person("2", "Umang",23,9923434));
		personService.savePerson(new Person("3", "Shubham",54,987234));
		
		return "Done";
	}
	
	@RequestMapping("/person")
	public Iterable<Person> getTopics() {

		return personService.getAllPersons();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/person")
	public void postPersons(@RequestBody Person person) {

		personService.savePerson(person);

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
	public Optional<Person> getPerson(@PathVariable String id) {

		personService.getPerson(id);

		return personService.getPerson(id);
	}

}
