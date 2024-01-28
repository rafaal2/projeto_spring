package br.com.projetoo.repositories;

import br.com.projetoo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Long> {
}
