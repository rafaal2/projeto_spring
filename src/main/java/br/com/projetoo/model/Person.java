package br.com.projetoo.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name", nullable = false, length = 80)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 80)
	private String lastName;
	@Column(nullable = false, length = 80)
	private String address;
	@Column(nullable = false, length = 6)
	private String gender;
	
	public Person() {}

}