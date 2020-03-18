package com.spittr.data;

import com.spittr.Spitter;

public interface SpitterRepository {
	
	public Spitter save(Spitter spitter);
	
	public Spitter get(String userName);

}
