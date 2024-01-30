package br.com.projetoo.controllers;

import java.util.List;

import br.com.projetoo.data.vo.v1.PersonVo;
import br.com.projetoo.services.PersonServices;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.projetoo.data.vo.v1.PersonVo;
import br.com.projetoo.services.PersonServices;

@RestController
@RequestMapping("/PersonVo")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	///private PersonVoServices service = new PersonVoServices();
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<PersonVo> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonVo findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}	@PostMapping (
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonVo create(@RequestBody PersonVo PersonVo) {
		return service.create(PersonVo);
	}

	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PersonVo update(@RequestBody PersonVo PersonVo) {
		return service.update(PersonVo);
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}