package com.main.service;

import java.util.List;

import com.main.model.Employee;

public interface EmployeeService {

	public void saveData(Employee e);

	public List<Employee> getAllData();

	public Employee getDataById(int eid);

	public Employee updateData(int eid, Employee e);

	public Employee updateEmployeeAddress(int eid, String addr);

	public void deleteEmployeeById(int eid);

}
