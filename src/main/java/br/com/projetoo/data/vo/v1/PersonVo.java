package br.com.projetoo.data.vo.v1;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class PersonVo implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	
	public PersonVo() {}

}