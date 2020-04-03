package com.spittr.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class SpitterRepositoryImpl implements SpitterManipulator{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public int updateLateSpittersLastName(Long id) {
		
		String update = "update Spitter spitter set spitter.lastName ='Late'  where spitter.id > :id";
		return em.createQuery(update)
				 .setParameter("id", id)
				 .executeUpdate();
		
	}

}
