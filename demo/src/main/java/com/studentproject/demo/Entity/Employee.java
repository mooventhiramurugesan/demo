package com.studentproject.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee 
{        
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id;
	    @Column(name="name",nullable=false)
        private String name;
	    @Column(name="role",length=122)
        private String role;
        private String location;
        
		public Employee()
		{
			
		}

		public Employee(int id, String name, String role, String location) 
		{
			this.id = id;
			this.name = name;
			this.role = role;
			this.location = location;
		}

		public int getId()
		{
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public String getRole() 
		{
			return role;
		}

		public void setRole(String role) 
		{
			this.role = role;
		}

		public String getLocation() 
		{
			return location;
		}

		public void setLocation(String location) 
		{
			this.location = location;
		}
		
		
}
