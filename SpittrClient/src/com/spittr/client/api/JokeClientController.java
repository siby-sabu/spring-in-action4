package com.spittr.client.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spittr.client.data.Joke;

@RestController
@RequestMapping("joke")
public class JokeClientController {
	
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public Joke getOneJoke() {
//		try
//		{
//			HttpClient client = HttpClients.createDefault();
//			HttpGet req = new HttpGet("https://joke3.p.rapidapi.com/v1/joke");
//			req.addHeader("x-rapidapi-host", "joke3.p.rapidapi.com");
//			req.addHeader("x-rapidapi-key", "9b7b7449dfmsh87ec624830bb1f2p10a3e3jsn636ab2f54aeb");
//			HttpResponse resp =	client.execute(req);
//			HttpEntity entity = resp.getEntity();
//			ObjectMapper mapper = new ObjectMapper();
//			return mapper.readValue(entity.getContent(), Joke.class);
//			
//		}catch(IOException e) {
//			throw new RuntimeException(e);
//		}
//		
//		
//	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Joke> getOneJoke() {
		RestTemplate rest = new RestTemplate();
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
		//Get actual vlaues by registering in https://rapidapi.com/
		headers.add("x-rapidapi-host", "sfaff");
		headers.add("x-rapidapi-key", "adad");
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);
		return rest.exchange("https://joke3.p.rapidapi.com/v1/joke", HttpMethod.GET, requestEntity, Joke.class);
	}
	
	

	
	
	

}
