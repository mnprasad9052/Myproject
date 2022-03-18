package com.crud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
@Service
public interface EmployeeServiceImpl {

	public Employee saveEmployee(Employee emp);

	public Employee getEmp(Long id);

	public List<Employee> getAllEmployees();

	public Employee updateEmpById(Employee employee,Long id) throws Exception;

	//Employee updateEmp(Long id);
	
	public void deleteEmpById(Long id) throws Exception;

}
