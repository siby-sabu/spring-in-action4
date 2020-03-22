package com.spittr.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spittr.Spittle;
import com.spittr.exception.DuplicateSpitterException;
import com.spittr.exception.SpittleNotFoundException;

@Component
public class DefaultSpittleDepository implements SpittleRepository {

	List<Spittle> spittleList = new ArrayList<>();

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		return dummySpittles();
	}

	private List<Spittle> dummySpittles() {

		Spittle sp1 = new Spittle(1l, "Hello World, The first ever Spittle", new Date(), 0.0, 1.0);
		Spittle sp2 = new Spittle(2l, "Here is another spittle", new Date(), 0.1, 1.2);
		Spittle sp3 = new Spittle(3l, "Spittle, Spittle, spittle", new Date(), 1.1, 2.2);
		Spittle sp4 = new Spittle(4l, "Spittles go fourth", new Date(), 6.1, 2.9);
		spittleList.add(sp1);
		spittleList.add(sp2);
		spittleList.add(sp3);
		spittleList.add(sp4);
		return spittleList;

	}

	@Override
	public Spittle findOne(long id) {
		try {
			return spittleList.get((int) id);
		} catch (Exception e) {
			throw new SpittleNotFoundException();
		}

	}

}
