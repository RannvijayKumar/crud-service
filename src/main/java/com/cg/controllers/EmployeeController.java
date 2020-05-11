package com.cg.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.models.Employee;
import com.cg.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repos;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/employee")
	public List<Employee> retrieveAllEmployee() {
		System.out.println("inside retrieveAllEmployee of Controller");
		return repos.findAll();
	}

//	@PostMapping(path = "/add")
//	public Employee add(@Valid @RequestBody Employee emp) {
//		System.out.println("inside add() of Controller");
//		return repos.save(emp);
//	}
	
	
	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Employee emp) {
		System.out.println("inside add() of Controller");
		
		restTemplate.postForLocation("http://localhost:2244/add", emp);
		
		
		
		repos.save(emp);
	}
	
	

	@GetMapping(path = "/findById/{id}")
	public Optional<Employee> findById(@PathVariable int id) {
		System.out.println("inside findById of Controller");
		return repos.findById(id);
	}

	@GetMapping(path = "/delete/{id}")
	public List<Employee> delete(@PathVariable int id) {
		System.out.println("inside delete of Controller");
		repos.deleteById(id);
		return repos.findAll();
	}

//	@PutMapping(path="/update")
//	public Employee update(@RequestBody Employee emp) {
//        System.out.println("inside add() of Controller" );
//		 return repos.save(emp);
//	}

	@PutMapping(path = "/updateEmployee/{empId}")
	public Employee editEmployeeDetails(@Valid @PathVariable int empId, @RequestBody Employee employee) {
		System.out.println(empId);
		// repos.findById(empId);
		Employee emp = repos.save(employee);
		return emp;
	}

	@DeleteMapping(path = "/deleteAll")
	public void deleteAllDetails() {

		repos.deleteAll();
	}
}
