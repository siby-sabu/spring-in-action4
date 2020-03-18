package com.spittr.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		return spitterMap.get(userName);
	}

}
