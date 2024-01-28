package br.com.projetoo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.projetoo.exception.ResourceNotFoundException;
import br.com.projetoo.repositories.PersonRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.projetoo.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public Person findById(Long id) {
		
		logger.info("Finding one person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Rafael");
		person.setLastName("Alves");
		person.setAddress("Brasil");
		person.setGender("Male");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("nao achouu"));
	}
	
	public Person create(Person person) {

		logger.info("Creating one person!");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one person!");

		var entity  = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("not found"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);

	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");

		var entity  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		repository.delete(entity);
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}
}
