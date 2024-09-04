package com.studentproject.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentproject.demo.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    Optional<Employee>findByName(String name);
    Optional<Employee>findByNameAndLocation(String name,String Location);
	
    
    //JPQL  java persistence query language
    //JPQL used fetch data from database in the index param 
    @Query(value="select a from Employee a where a.location=?1")
    public List<Employee> getLocation(String location);
    
    
    @Query(value="select r from Employee r where r.name=?1 and r.role=?2")
    public Employee getNameAndRole(String name,String role);
   
   
   //JPQL used fetch in data from database in the name param
   @Query(value="select y from Employee y where y.name=:name or y.location=:location")
   public List<Employee> getNameOrLocation(@Param("name") String name,
    		                                 @Param("location") String location);
   
   @Query(value="select * from employees where id>?1",nativeQuery=true)
   public List<Employee> getId(int id);
      
}
