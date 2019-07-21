package br.com.fztn.Person.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.fztn.Person.model.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.getAndIncrement());
		person.setFirstName("Felipy");
		person.setLastName("Cabral");
		person.setAddress("São Paulo");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0 ; i < 8 ; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person " + i);
		person.setLastName("LastName " + i);
		person.setAddress("Address " + i);
		person.setGender("Gender " + i);
		return person;
	}
}
