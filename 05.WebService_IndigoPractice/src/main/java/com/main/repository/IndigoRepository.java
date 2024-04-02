package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Flight;

@Repository
public interface IndigoRepository extends JpaRepository<Flight, Integer>
{

	List<Flight> findAllByFromLocationAndToLocation(String fromLocation, String toLocation);

}
