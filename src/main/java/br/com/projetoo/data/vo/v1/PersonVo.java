package br.com.projetoo.data.vo.v1;

import com.github.dozermapper.core.Mapping;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class PersonVo extends RepresentationModel<PersonVo> implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

    @Mapping("id")
	private Long Key;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	
	public PersonVo() {}

}