package com.example.demo.topic;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

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

	@RequestMapping(method = RequestMethod.POST, value = "/saveAll")
	public void postPersonsList(@RequestBody Iterable<Person> person) {

		personService.saveAll(person);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
	public void deletePersons(@PathVariable String id) {
		personService.deletePerson(id);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
	public void updatePersons(@RequestBody Person person) {

		personService.savePerson(person);

	}

	@RequestMapping(value = "/employee")
	@ResponseBody
	public String handler(
			@RequestParam(value = "doj", required = false, defaultValue = "default") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate doj) {

		Iterable<Person> p1 = personService.getAllPersons();

		List<Person> list = Lists.newArrayList(p1);

		System.out.println("The Doj is " + doj);
		return "Done";

	}

	public static Predicate<Person> isAgeMoreThan(Integer age) {
		return p -> p.getAge() > age;
	}

	public static List<Person> filterEmployees(List<Person> persons,
			Predicate<Person> predicate) {
		return persons.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

	@RequestMapping(value = "/getEmployeeAge")
	@ResponseBody
	public List<Person> getEmployeeAge() {

		Iterable<Person> employee = personService.getAllPersons();

		List<Person> employeeList = Lists.newArrayList(employee);

		return (filterEmployees(employeeList, isAgeMoreThan(35)));

	}

	public static Predicate<Person> isSalMoreThan(Integer salary) {
		return p -> p.getSalary() > salary;
	}

	public static List<Person> filterEmployeeSalary(List<Person> persons,
			Predicate<Person> predicate) {
		return persons.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

	@RequestMapping(value = "/getEmployeeSalary")
	@ResponseBody
	public List<Person> getEmployeeSalary() {

		Iterable<Person> employee = personService.getAllPersons();

		List<Person> employeeList = Lists.newArrayList(employee);

		return (filterEmployeeSalary(employeeList, isSalMoreThan(100000)));

	}

	public static Predicate<Person> isDept(Department department) {
		return p -> p.getDepartment() == department;
	}

	public static List<Person> filterEmployeesDepartment(List<Person> persons,
			Predicate<Person> predicate) {
		return persons.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

	@RequestMapping(value = "/getEmployeeDepartment")
	@ResponseBody
	public List<Person> getDepartment(
			@RequestParam(value = "department", required = false, defaultValue = "default") Department department) {

		Iterable<Person> employee = personService.getAllPersons();

		List<Person> employeeList = Lists.newArrayList(employee);

		return (filterEmployeesDepartment(employeeList, isDept(department)));

	}

	public static Predicate<Person> istransport(Transport transport) {
		return p -> p.getTransport() == transport;
	}

	public static List<Person> filterEmployeesTransport(List<Person> persons,
			Predicate<Person> predicate) {
		return persons.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

	@RequestMapping(value = "/getEmployeeTransport")
	@ResponseBody
	public List<Person> getEmployeeTransport(
			@RequestParam(value = "transport", required = false, defaultValue = "default") Transport transport) {

		Iterable<Person> employee = personService.getAllPersons();

		List<Person> employeeList = Lists.newArrayList(employee);

		return (filterEmployeesTransport(employeeList, istransport(transport)));

	}

	public static Predicate<Person> isbday(int bday) {
		return p -> p.getDob().getMonthValue() == bday;
	}

	public static List<Person> filterEmployeesBirthday(List<Person> persons,
			Predicate<Person> predicate) {
		return persons.stream().filter(predicate)
				.collect(Collectors.<Person> toList());
	}

	@RequestMapping(value = "/getEmployeeBirthday")
	@ResponseBody
	public List<Person> getEmployeeBirthday(
			@RequestParam(value = "birthday", required = false, defaultValue = "default") int bday) {

		Iterable<Person> employee = personService.getAllPersons();

		List<Person> employeeList = Lists.newArrayList(employee);

		return (filterEmployeesBirthday(employeeList, isbday(bday)));

	}

}
