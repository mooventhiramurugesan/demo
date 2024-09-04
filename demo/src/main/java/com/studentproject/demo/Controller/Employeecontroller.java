package com.studentproject.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentproject.demo.Entity.Employee;
import com.studentproject.demo.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class Employeecontroller 
{  
	
	@Autowired
    private EmployeeService employeeService;
	
	@PostMapping(value="/save")
	public Employee saveEmployee( @RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") int id)
	{
		return employeeService.getEmployee(id);
	}
	
	@GetMapping(value="/getAllEmployee/{id}")
	public List<Employee> getAllEmployee(@PathVariable("id") int id)
	{
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping(value="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id)
	{
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping(value="/getfindbyName")
	public Employee Getemployeebyname(@RequestParam ("name") String name)
	{ 
		return employeeService.getEmployeeByname(name);
		
	}
	
	
	@GetMapping(value="/getfindByNameAndLocation")
	public Employee getemployeefindbynameandlocation(@RequestParam("name")String name,
			               @RequestParam("Location")String Location)
	{
		return employeeService.getEmployeeByNameAndLocation(name, Location);
	}
	
	@GetMapping(value="/getlocation")
	public ResponseEntity<List<Employee>> getlocation(@RequestParam("location") String location)
	{
		List<Employee> employee= employeeService.getlocation(location);
		return ResponseEntity.ok(employee);	
	}
	
	@GetMapping(value="/getnameandrole")
     public ResponseEntity<Employee> getNameAndRole(
		                                 @RequestParam("name") String name,
		                                 @RequestParam("role") String role)
    {
	Employee employee= employeeService.getNameAndRole(name, role);
	return ResponseEntity.ok(employee);
		
	}	
	
	@GetMapping(value="/getNameOrLocation")
	public ResponseEntity<List<Employee>> getNameOrLocation(@RequestParam("name")String name,
			                                                  @RequestParam("location")String location)
	{
	 List<Employee> employees=employeeService.getNameOrLocation(name, location);
	 return ResponseEntity.ok(employees);
	}
	
    @GetMapping(value="/getByIdGreaterThan/{id}")
	public ResponseEntity<List<Employee>> getId(@PathVariable("id")int id)
	{
		List<Employee> employee=employeeService.getId(id);
		return ResponseEntity.ok(employee);
	}
	
}
