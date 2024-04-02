package com.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Employee;
import com.main.repository.EmployeeRepository;
import com.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeRepository er;

	@Override
	public void saveData(Employee e)
	{
		er.save(e);
		
	}

	@Override
	public List<Employee> getAllData() {
		
		return er.findAll();
	}

	@Override
	public Employee getDataById(int eid) 
	{
		Optional<Employee> e=er.findById(eid);
		return e.get();
	}

	@Override
	public Employee updateData(int eid, Employee e) 
	{
		Optional<Employee> e1=   er.findById(eid);
		  e.seteId(eid);
		   if(e1.isPresent()) return er.save(e);
		   else  throw new  RuntimeException("The Employee you are trying to update is not present.");
		
	}

	@Override
	public Employee updateEmployeeAddress(int eid, String addr) {
		Optional<Employee> e1=   er.findById(eid);
		if(e1.isPresent())
		{
			Employee e=e1.get();
			    e.setAddr(addr);;
		return er.save(e);
		}
		 else 
			 
			 throw new  RuntimeException("The Employee you are trying to update is not present.");
		
	}

	@Override
	public void deleteEmployeeById(int eid)
	{
		Optional<Employee> e=er.findById(eid);
		if(e.isPresent())
		{
		er.deleteById(eid);
		}
		else 
			 
			 throw new  RuntimeException("The Employee you are trying to delete is not present.");
		
		
	}

	
}
