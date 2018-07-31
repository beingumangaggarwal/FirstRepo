package com.example.demo.topic;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id
	private String id;

	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "contact")
	private int contact;
	@Column(name = "department")
	private Department department;
	@Column(name = "transport")
	private Transport transport;
	@Column(name = "doj")
	private LocalDate doj;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "salary")
	private long salary;

	public Person() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Person(String id, String name, int age, int contact,
			Department department, Transport transport, LocalDate doj,
			LocalDate dob, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.department = department;
		this.transport = transport;
		this.doj = doj;
		this.dob = dob;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

}
