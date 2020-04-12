package com.spittr.client.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.spittr.client.data.Spittle;

@RestController
@RequestMapping("/rest/v1/")
public class SpittleClientController {
	
//	@GetMapping("spittles")
//	public List<Spittle> getSpittles(){
//		RestTemplate rest = new RestTemplate();
//		return rest.getForObject("http://localhost:8080/Spittr/spittles/", List.class);
//		
//	}
	
	
//	@GetMapping("spittles")
//	public Spittle[] getSpittles(){
//		RestTemplate rest = new RestTemplate();
//		return rest.getForObject("http://localhost:8080/Spittr/spittles/", Spittle[].class);
//		
//	}
	
//	@GetMapping("spittles")
//	public ResponseEntity<Spittle[]> getSpittles(){
//		RestTemplate rest = new RestTemplate();
//		//return rest.getForObject("http://localhost:8080/Spittr/spittles/", Spittle[].class);
//		return rest.getForEntity("http://localhost:8080/Spittr/spittles/", Spittle[].class);
//		
//	}
	
	@GetMapping("spittles/{id}")
	public Spittle getOneSpittles(@PathVariable("id") String id){
		RestTemplate rest = new RestTemplate();
		Map<String,String> params = new HashMap<String,String>();
		params.put("id", id);
		//return rest.getForObject("http://localhost:8080/Spittr/spittles/{id}", Spittle.class, id);
		return rest.getForObject("http://localhost:8080/Spittr/spittles/{id}", Spittle.class, params);
	}
	
//	@PostMapping("/spittles")
//	public Spittle saveSpittle(@RequestBody Spittle spittle) throws RestClientException, URISyntaxException {
//		
//		RestTemplate rest = new RestTemplate();
//		return rest.postForObject(new URI("http://localhost:8080/Spittr/spittles"), spittle, Spittle.class);
//		
//	}
	
	@DeleteMapping("spittles/{id}")
	public void deleteSpittle(@PathVariable("id") long id) {
		RestTemplate rest  = new RestTemplate();
		rest.delete("http://localhost:8080/Spittr/spittles/{id}", id);
	}
	
	@PostMapping("/spittles")
	public URI saveSpittle(@RequestBody Spittle spittle) throws RestClientException, URISyntaxException {
		
		RestTemplate rest = new RestTemplate();
		return rest.postForLocation(new URI("http://localhost:8080/Spittr/spittles"), spittle);
		
	}
	
	
	
	
	
	
	
	

}
