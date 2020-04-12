package com.spittr.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;
import com.spittr.exception.SpittleError;
import com.spittr.exception.SpittleNotFoundException;

//@Controller
@RestController
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;

	SpittleRepository repository;

	@Autowired
	public SpittleController(SpittleRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<Spittle> spittles(@RequestParam(name = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(name = "count", defaultValue = "20") int count, Model model) {
		return repository.findSpittles(max, count);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Spittle> save(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
		Spittle spittle2 =  repository.saveSpittle(spittle);
		URI uri = ucb
					.path("/spittle/")
					.path(String.valueOf(spittle2.getId()))
					.build()
					.toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity<Spittle>(spittle2,headers, HttpStatus.CREATED);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/{spittleId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Spittle> spittle(@PathVariable long spittleId) {
//		Spittle spittle =  repository.findOne(spittleId);
//		HttpStatus status = spittle != null ? HttpStatus.OK: HttpStatus.NOT_FOUND;
//		return new ResponseEntity<Spittle>(spittle,status);
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{spittleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Spittle spittle(@PathVariable long spittleId) {
		return  repository.findOne(spittleId);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		repository.delete(id);
	}
	
	
	
	@ExceptionHandler(SpittleNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public SpittleError  spittleNotFound(SpittleNotFoundException e){
		return  new SpittleError(String.format("No spittle with id [%s] found", e.getSpittleId()), 4);
	}

}
