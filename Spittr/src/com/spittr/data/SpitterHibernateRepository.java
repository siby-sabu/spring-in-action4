//package com.spittr.data;
//
//import java.io.Serializable;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//
//import com.spittr.Spitter;
//
//@Repository
//@Transactional
//public class SpitterHibernateRepository implements SpitterRepository{
//	
//	SessionFactory sessionFactory;
//	
//	@Autowired
//	public SpitterHibernateRepository(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
//	
//	private Session currentSession() {
//		return sessionFactory.getCurrentSession();
//	}
//
//	@Override
//	public Spitter save(Spitter spitter) {
//		Serializable id = currentSession().save(spitter);
//		return new Spitter((Long) id, spitter.getFirstName(), spitter.getLastName(), spitter.getUserName(), spitter.getPassword());	
//	}
//
//	@Override
//	public Spitter get(String username) {
//		return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("userName", username)).list().get(0);
//		
//	}
//
//}
