package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Passanger;

@Repository
public interface PassangerRepository extends CrudRepository<Passanger, Integer>,JpaRepository<Passanger, Integer>
{
	public Passanger findByPname(String pName);

}
