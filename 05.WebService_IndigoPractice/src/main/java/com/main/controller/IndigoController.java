package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Flight;
import com.main.model.Passanger;
import com.main.service.IndigoService;

@RestController
public class IndigoController 
{
	@Autowired
	IndigoService is;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Flight flight)
	{
		is.saveData(flight);
		return "Data Saved Successfully";
	}
	
	@GetMapping("/getAllFlight")
	public List<Flight> getData()
	{
		List<Flight> lf=is.getData();
		return lf;
	}
	
	@GetMapping("/getAllFlight/{fromLocation}/{toLocation}")
	public List<Flight> getData(@PathVariable String fromLocation,@PathVariable String toLocation)
	{
		List<Flight> lf=is.getData(fromLocation,toLocation);
				return lf;
	}
	
	@PostMapping("/saveIndigoPassanger")
	public String savePassanger(@RequestBody Passanger passanger)
	{
		is.savePassanger(passanger);
		return "Booking Done";
	}
	
	@GetMapping("/GetPassanger/{pName}")
	public Passanger getPassanger(@PathVariable String pName)
	{
		Passanger p=is.getPassanger(pName);
		return p;
	}
}
