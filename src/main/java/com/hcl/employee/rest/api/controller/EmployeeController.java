package com.hcl.employee.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.rest.api.entity.Employee;
import com.hcl.employee.rest.api.service.ImplEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	ImplEmployeeService implEmployeeService;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
		Employee employee2 = implEmployeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long
			empId)
	{
		Employee employee = implEmployeeService.getEmployeeById(empId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long empId,@RequestParam("salary") double salary)
	{
		Employee employee  =implEmployeeService.updateEmployee(empId, salary);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> list_emp = implEmployeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list_emp, HttpStatus.OK);
	}
}
