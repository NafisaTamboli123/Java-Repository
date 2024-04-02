package com.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Flight;
import com.main.model.Passanger;
import com.main.repository.PassangerRepository;
import com.main.repository.SpicejetRepository;
import com.main.service.SpicejetService;

@Service
public class SpicejetServiceImpl implements SpicejetService
{
	@Autowired
	SpicejetRepository sr;
	
	@Autowired
	PassangerRepository pr;

	@Override
	public void saveData(Flight flight) 
	{
		sr.save(flight);
		
	}

	@Override
	public List<Flight> getData() 
	{
		return sr.findAll();
	}

	@Override
	public List<Flight> getData(String fromLocation, String toLocation) 
	{
		
		return sr.findAllByFromLocationAndToLocation(fromLocation, toLocation);
	}

	@Override
	public void savePassanger(Passanger passanger) 
	{
		pr.save(passanger);
		
	}

}
