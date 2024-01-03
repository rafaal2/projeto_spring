package br.com.projeto;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SddcController {
	private static String Tmp = "hello, %s!";
	private AtomicLong Counter = new AtomicLong();
	
	@GetMapping("/sddc")
	public Sddc sddc(@RequestParam(value = "name", defaultValue = "world")String name) {
		name = "tchowwww";
		return new Sddc(Counter.incrementAndGet(), String.format(name));
	}
	
	
	

}
