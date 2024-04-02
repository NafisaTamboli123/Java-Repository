package com.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Flight;
import com.main.model.Passanger;
import com.main.repository.IndigoRepository;
import com.main.repository.PassangerRepository;
import com.main.service.IndigoService;

@Service
public class IndigoServiceImpl implements IndigoService
{
	@Autowired
	IndigoRepository ir;
	
	@Autowired
	PassangerRepository pr;

	@Override
	public void saveData(Flight flight)
	{
		ir.save(flight);
		
	}

	@Override
	public List<Flight> getData() 
	{
		return ir.findAll();
	}

	@Override
	public List<Flight> getData(String fromLocation, String toLocation) 
	{
		return ir.findAllByFromLocationAndToLocation(fromLocation,toLocation);
	}

	@Override
	public void savePassanger(Passanger passanger) 
	{
		
		pr.save(passanger);
	}

	@Override
	public Passanger getPassanger(String pName) 
	{
		return pr.findByPname(pName);
		//return null;
	}

}
