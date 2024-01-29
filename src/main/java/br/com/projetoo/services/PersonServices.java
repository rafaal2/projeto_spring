package br.com.projetoo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.projetoo.data.vo.v1.PersonVo;
import br.com.projetoo.exception.ResourceNotFoundException;
import br.com.projetoo.mapper.DozerMapper;
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
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("nao achouu"));
	}
	
	public PersonVo create(PersonVo personVo) {

		logger.info("Creating one PersonVo!");

		return DozerMapper .parseObject(repository.save(), )

	public PersonVo update(PersonVo PersonVo) {

		logger.info("Updating one PersonVo!");

		var entity = repository.findById(PersonVo.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(PersonVo.getFirstName());
		entity.setLastName(PersonVo.getLastName());
		entity.setAddress(PersonVo.getAddress());
		entity.setGender(PersonVo.getGender());

		return repository.save(PersonVo);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one PersonVo!");

		var entity  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));

		repository.delete(entity);
	}

}
