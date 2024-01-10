package br.com.projeto;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private AtomicLong Counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numone}/{numtwo}" , method=RequestMethod.GET)
	
	public Double sum(
					  @PathVariable(value = "numone")String numone,
					  @PathVariable(value = "numtwo")String numtwo) {
						return 1D;
		
	}

}
