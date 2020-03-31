package com.spittr.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spittr.Spitter;

@Component
public class DefaultSpitterDepository implements SpitterRepository {

	Map<String,Spitter> spitterMap = new HashMap<>();

	@Override
	public Spitter save(Spitter spitter) {
		spitter.setId(Long.valueOf(spitterMap.size()+1));
		spitterMap.put(spitter.getUserName(), spitter);
		return spitterMap.get(spitter.getUserName());
	}

	@Override
	public Spitter get(String  userName) {
//		if(spitterMap.size()>0) {
//			return spitterMap.get(userName);
//		}
		Spitter spitter = new Spitter();
		spitter.setId(1l);
		spitter.setUserName("siby");
		spitter.setPassword("$2a$10$M4vGFYoOPUoIfu5Y2zuIW.cGciXuhYHl8iXGGhCjOdkIxU37zgn42");
		spitterMap.put("1", spitter);
		return spitter;

	}

}
