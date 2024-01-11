package br.com.projeto;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.exceptions.UnsupMathOp;

@RestController
public class MathController {

	
	@RequestMapping(value = "/operation/{numone}/{operation}/{numtwo}" , method=RequestMethod.GET)
	
	public Double operation( @PathVariable(value = "numone")String numone, 
			@PathVariable(value = "operation") String operation,
			@PathVariable(value = "numtwo")String numtwo) throws Exception {
		if(!IsNum(numone) || !IsNum(numtwo)){
			throw new UnsupMathOp("not supported");
		}
		if(operation.equals("x")) {
			return convDouble(numone) * convDouble(numtwo);
		}
		if(operation.equals("-")) {
			return convDouble(numone) - convDouble(numtwo);
		}
		if(operation.equals("/")) {
			return convDouble(numone) / convDouble(numtwo);
		}
		if(operation.equals("x2")) {
			return (convDouble(numone) + convDouble(numtwo)) / 2;
		}
		if(operation.equals("+")) {
			return convDouble(numone) + convDouble(numtwo);
		}
		else{
			return 0D;
		}
		
	}
	
	
	private Double convDouble(String strnum) {
		if(strnum == null) return 0D;
		String num = strnum.replaceAll(",", ".");
		if(IsNum(num)) return Double.parseDouble(num);
		return 0D;
	}

	private boolean IsNum(String strnum) {
		if(strnum == null) return false;
		String num = strnum.replaceAll(",", ".");
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
