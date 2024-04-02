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
import com.main.service.SpicejetService;

@RestController
public class SpicejetController 
{
	@Autowired
	SpicejetService ss;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Flight flight)
	{
		ss.saveData(flight);
		return "Data Saved Successfully";
	}
	
	@GetMapping("/getAllFlight")
	public List<Flight> getData()
	{
		List<Flight> lf=ss.getData();
		return lf;
	}
	
	@GetMapping("/getAllFlight/{fromLocation}/{toLocation}")
	public List<Flight> getData(@PathVariable String fromLocation,@PathVariable String toLocation)
	{
		List<Flight> lf=ss.getData(fromLocation,toLocation);
		return lf;
	}
	
	@PostMapping("/saveSpicejetPassanger")
	public String savePassanger(@RequestBody Passanger passanger)
	{
		ss.savePassanger(passanger);
		return "Booking Done";
	}
}
