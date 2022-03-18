package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl emplserviceimpl;
	
	@PostMapping("/saveemp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody() Employee emp)
	{
		Employee empsaved=emplserviceimpl.saveEmployee(emp);
		return new ResponseEntity<Employee>(empsaved,HttpStatus.CREATED);
	}
    
	@GetMapping("/getemp/{id}")
	public Employee getEmp(@PathVariable("id") Long id)
	{
		return emplserviceimpl.getEmp(id);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployees()
	{
		return emplserviceimpl.getAllEmployees();
	
	}
	
	@PutMapping("/updateemp/{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee,@PathVariable("id") Long id) throws Exception
	{
		return new ResponseEntity<Employee>(emplserviceimpl.updateEmpById(employee, id), HttpStatus.OK);
		//return emplserviceimpl.updateEmpById(employee, id);
		
		
	}
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<String> deleteByEmployeeId(@PathVariable("id") Long id) throws Exception
	{
		emplserviceimpl.deleteEmpById(id);
		
		return new ResponseEntity<String>("Employee deleted Successfully",HttpStatus.OK);
		
	}
	
}