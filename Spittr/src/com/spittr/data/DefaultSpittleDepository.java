package com.spittr.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.spittr.Spitter;
import com.spittr.Spittle;
import com.spittr.exception.DuplicateSpitterException;
import com.spittr.exception.SpittleNotFoundException;

@Component
public class DefaultSpittleDepository implements SpittleRepository {

	List<Spittle> spittleList = new ArrayList<>();

	@Override
	// @PreAuthorize("hasAnyRole({'ROLE_SPITTLE','ROLE_ADMIN'})")
	// @PostFilter("hasRole('ROLE_ADMIN') || filterObject.spitter.userName ==
	// principal.username")
	// @PostFilter("hasPermission(filterObject,'read')")
	public List<Spittle> findSpittles(long max, int count) {
		return dummySpittles();
	}

	public DefaultSpittleDepository() {

		Spitter spitter = new Spitter();
		spitter.setUserName("anina");

		Spitter spitter2 = new Spitter();
		spitter2.setUserName("siby");

		Spittle sp1 = new Spittle(1l, "Hello World, The first ever Spittle", new Date(), 0.0, 1.0);
		sp1.setSpitter(spitter);
		Spittle sp2 = new Spittle(2l, "Here is another spittle", new Date(), 0.1, 1.2);
		sp2.setSpitter(spitter);
		Spittle sp3 = new Spittle(3l, "Spittle, Spittle, spittle", new Date(), 1.1, 2.2);
		sp3.setSpitter(spitter);
		Spittle sp4 = new Spittle(4l, "Spittles go fourth", new Date(), 6.1, 2.9);
		sp4.setSpitter(spitter2);

		spittleList.add(sp1);
		spittleList.add(sp2);
		spittleList.add(sp3);
		spittleList.add(sp4);

	}

	private List<Spittle> dummySpittles() {

		return spittleList;

	}

	@Override
	public Spittle findOne(long id) {
		try {
			return spittleList.get((int) id-1);
		} catch (Exception e) {
			throw new SpittleNotFoundException(id);
		}

	}

	@Override
	public Spittle saveSpittle(Spittle spittle) {
		spittle.setId((long) (spittleList.size() + 1));
		spittleList.add(spittle);
		return spittle;
	}

	@Override
	public void delete(long id) {
		spittleList.remove((int)id-1);
	}

}
