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

import com.main.model.Employee;
import com.main.service.EmployeeService;

@RestController
public class Controller 
{
	@Autowired
	EmployeeService es;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Employee e)
	{
		es.saveData(e);
		return "Data Save Successfully";
	}
	
	@GetMapping("/getAllData")
	public List<Employee> getAllData()
	{
		List<Employee> el=es.getAllData();
		return el;
	}
	
	@GetMapping("/getDataById/{eid}")
	public Employee getDataById(@PathVariable int eid)
	{
		Employee e=es.getDataById(eid);
		return e;
	}
	
	@PutMapping("/employee/{eid}")
	public Employee updateData(@PathVariable int eid,@RequestBody Employee e)
	{
		Employee e1=es.updateData(eid,e);
		return e1;
	}
	
	@PatchMapping("/employee/{eid}")
	public Employee updateEmployeeAddress(@PathVariable int eid,@RequestBody Employee e)
	{
		Employee e1=es.updateEmployeeAddress(eid,e.getAddr());
		return e1;
	}
	
	@DeleteMapping("/delete/{eid}")
	public String deleteEmployeeById(@PathVariable int eid)
	{
		es.deleteEmployeeById(eid);
		return "Employee Deleted Successfully"; 
	}
}
