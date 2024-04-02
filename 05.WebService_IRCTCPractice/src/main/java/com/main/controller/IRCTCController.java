package com.main.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.model.Flight;
import com.main.model.Passanger;

@RestController
public class IRCTCController 
{
	@Autowired
	RestTemplate rt;
	
	@GetMapping("/getAllFlight")
	public List<Flight> getData()
	{
		List<Flight> all=new ArrayList<Flight>();
		Flight[] spice=rt.getForObject("http://localhost:8086/getAllFlight", Flight[].class);
		
		Flight[] indigo=rt.getForObject("http://localhost:8085/getAllFlight", Flight[].class);
		
		 for(Flight indigoFlight:indigo)
	      {
	    	  all.add(indigoFlight);
	      }
		 
		 for(Flight spiceFlight:spice)
		 {
			all.add(spiceFlight);
		 }
		 
		 Comparator<Flight>  compare=(o1 , o2)->o1.getPrice()-o2.getPrice();
		  all.sort(compare);
		return all;
	}
	
	@GetMapping("/getAllFlight/{fromLocation}/{toLocation}")
	public List<Flight> getData(@PathVariable String fromLocation,@PathVariable String toLocation)
	{
		List<Flight> all=new ArrayList<Flight>();
		
		Flight[] spice=rt.getForObject("http://localhost:8086/getAllFlight/"+fromLocation+"/"+toLocation, Flight[].class);
		Flight[] indigo=rt.getForObject("http://localhost:8085/getAllFlight/"+fromLocation+"/"+toLocation ,Flight[].class);
		
		 for(Flight indigoFlight:indigo)
	      {
	    	  all.add(indigoFlight);
	      }
		 
		 for(Flight spiceFlight:spice)
		 {
			all.add(spiceFlight);
		 }
		 
		 Comparator<Flight>  compare=(o1 , o2)->o1.getPrice()-o2.getPrice();
		  all.sort(compare);
		return all;
	}
	
	@PostMapping("/saveSpicejetPassanger")
	public String saveSpicejetPassanger(@RequestBody Passanger passanger)
	{
		rt.postForObject("http://localhost:8086/saveSpicejetPassanger", passanger, String.class);
		return "Booking Successfully";
	}
	
	@PostMapping("/saveIndigoPassanger")
	public String saveIndigoPassanger(@RequestBody Passanger passanger)
	{
		rt.postForObject("http://localhost:8085/saveIndigoPassanger", passanger, String.class);
		return "Booking Successfully";
	}
}
