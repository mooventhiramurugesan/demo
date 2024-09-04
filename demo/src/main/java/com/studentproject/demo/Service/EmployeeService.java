package com.studentproject.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studentproject.demo.Entity.Employee;
import com.studentproject.demo.Repository.EmployeeRepository;


@Service
public class EmployeeService 
{
	@Autowired
    private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee)
	{
		Employee savedEmployee=employeeRepository.save(employee);
		return savedEmployee;
	}

	
	public Employee getEmployee(int id)
	{
		return  employeeRepository.findById(id).get();
			
	}

	
	public List<Employee> getAllEmployee()
    {
		return employeeRepository.findAll();
	}
	
	
	public String deleteEmployee(int id)
	{
		Employee employee=employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return "Employee delete successfully";	
	}

	
    public Employee getEmployeeByname( String name)	
    {
		return employeeRepository.findByName(name).get();
    }	
    	
   
    public Employee getEmployeeByNameAndLocation(String name,String Location)
    {
    	return employeeRepository.findByNameAndLocation(name, Location).get();
    }
    
    
    public List<Employee> getlocation(String Location)
    {
    	return employeeRepository.getLocation(Location);
    }
    
    
   public Employee getNameAndRole(String name,String role)
     {
       	return employeeRepository.getNameAndRole(name, role);
     }
    
   public List<Employee> getNameOrLocation(String name,String location)
   {
   	return employeeRepository.getNameOrLocation(name, location);
   }
   
   public List<Employee> getId(int id)
   {
	   List<Employee> listemployee= employeeRepository.getId(id);
	   return listemployee;
   }
}	
    	
    	
    	
    	