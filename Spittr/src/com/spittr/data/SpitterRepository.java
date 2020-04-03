package com.spittr.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spittr.Spitter;

@Repository
public interface SpitterRepository  extends JpaRepository<Spitter, Long>, SpitterManipulator{
	
	
	public Spitter findSpitterByUserName(String userName);
	
	@Query("select s from Spitter s  where s.id = ?1")
	public Spitter findByOnlyId(Long id);
	
	

}
