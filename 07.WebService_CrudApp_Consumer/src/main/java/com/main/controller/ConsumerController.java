package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.model.Employee;

@RestController
public class ConsumerController 
{
	@Autowired
	RestTemplate rt;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Employee e)
	{
		rt.postForObject("http://localhost:9090/save", e, String.class);
		return "Data Save Successfully";
	}
	
	@GetMapping("/getAllData")
	public List<Employee> getAllData()
	{
		List<Employee> e=rt.getForObject("http://localhost:9090/getAllData", List.class);
		return e;
	}

	@GetMapping("/getDataById/{eid}")
	public Employee getDataById(@PathVariable int eid)
	{
		Employee e=rt.getForObject("http://localhost:9090/getDataById/"+eid, Employee.class);
		return e;
	}
	
	@PutMapping("/employee/{eid}")
	public String updateData(@PathVariable int eid,@RequestBody Employee e)
	{
		rt.put("http://localhost:9090/employee/"+eid, e);
		return "Employee Updated";
	}
	
	@PatchMapping("/employee/{eid}")
	public Employee updateEmployeeAddress(@PathVariable int eid,@RequestBody Employee e)
	{
		Employee e1=rt.patchForObject("http://localhost:9090/employee/"+eid, e,Employee.class);
		return e1;
	}
	
	@DeleteMapping("/delete/{eid}")
	public String deleteData(@PathVariable int eid)
	{
		rt.delete("http://localhost:9090/delete/"+eid);
		return "Deleted Successfully";
	}
}
