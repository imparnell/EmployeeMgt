package com.aug.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aug.daos.EmployeeDao;
import com.aug.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public boolean hasAuthentication(Employee employee) {
		List<Employee> employees = employeeDao
				.findUserByEmailPassword(employee);
		return (employees.size() > 0) ? true : false;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAll() {
		List<Employee> employees = employeeDao.findAll();
		return employees;
	}
	
	public boolean save(Employee employee){
		try{
		employeeDao.save(employee);
		return true;
		}catch(Exception ex){
			return false;
		}
	}

}
