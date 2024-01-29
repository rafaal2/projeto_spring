package br.com.projetoo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.projetoo.data.vo.v1.PersonVo;
import br.com.projetoo.exception.ResourceNotFoundException;
import br.com.projetoo.mapper.DozerMapper;
import br.com.projetoo.model.Person;
import br.com.projetoo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.projetoo.data.vo.v1.PersonVo;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	public List<PersonVo> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVo.class );
	}

	public PersonVo findById(Long id) {
		
		logger.info("Finding one PersonVo!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("nao achouu"));
		return DozerMapper.parseObject(entity, PersonVo.class);
	}
	
	public PersonVo create(PersonVo person) {

		logger.info("Creating one PersonVo!");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVo.class);
		return vo;
	}
	public PersonVo update(PersonVo person) {

		logger.info("Updating one PersonVo!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo =DozerMapper.parseObject(repository.save(entity), PersonVo.class);

		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one PersonVo!");

		var entity  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		repository.delete(entity);
	}

}
