package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceImpl{
	
	@Autowired
	EmployeeRepository emprepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		
		return emprepository.save(emp);
	}

	@Override
	public Employee getEmp(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee= emprepository.findById(id);
		
		if(employee.isPresent())
			return employee.get();
		return null;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepository.findAll();
	}
	
     @Override
	public Employee updateEmpById(Employee employee,Long id) throws Exception {
		// TODO Auto-generated method stub
    	 
    	 //we need to check whether the employee id is exist or not
    	 
    	 Employee existempplyee=emprepository.findById(id).orElseThrow(()->new Exception("Id not Found"));
    	 existempplyee.setName(employee.getName());
    	 emprepository.save(existempplyee);
    	 return existempplyee;
    	
	}

	@Override
	public void deleteEmpById(Long id) throws Exception {
		// TODO Auto-generated method stub
		emprepository.findById(id).orElseThrow(()->new Exception("Id not Found"));
		
		emprepository.deleteById(id);
		
	}

}
