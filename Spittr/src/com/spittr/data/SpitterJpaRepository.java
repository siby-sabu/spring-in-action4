//package com.spittr.data;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.AbstractQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.spittr.Spitter;
//
//@Repository
//@Transactional
//@Primary
//public class SpitterJpaRepository implements SpitterRepository{
//	
//	@PersistenceContext
//	private EntityManager em;
//
//	@Override
//	public Spitter save(Spitter spitter) {
//		em.persist(spitter);
//		return spitter;
//	}
//
//	@Override
//	public Spitter get(String username) {
//
//		 CriteriaBuilder cb=em.getCriteriaBuilder();  
//         AbstractQuery<Spitter> cq = cb.createQuery(Spitter.class);  
//         Root<Spitter> spitter =cq.from(Spitter.class);  
//          
//         cq.where(cb.equal(spitter.get("userName"), username));  
//         
//         CriteriaQuery<Spitter> select = ((CriteriaQuery<Spitter>) cq).select(spitter);  
//         TypedQuery<Spitter> tq = em.createQuery(select);  
//         return tq.getResultList().get(0);
//		}
//
//}
