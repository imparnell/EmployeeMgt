package com.aug.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.aug.entities.Employee;
import com.aug.services.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ResultPath(value = "/")
public class EmployeeAction extends ActionSupport {

	@Autowired
	private EmployeeService employeeService;
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Action(value = "showemployee", results = {
			@Result(name = "input", location = "pages/showemployee.jsp"),
			@Result(name = "welcome", location = "pages/welcome.jsp") })
	public String lists() {
		employees = employeeService.findAll();
		if (employees.size() != 0)
			return "input";
		else
			return "welcome";
	}
	

	@Action(value = "register", results = {
			@Result(name = "input", location = "pages/register.jsp"),
			@Result(name = "success", location = "pages/success.jsp") })
	public String save() {
		employeeService.save(employee);
		return "success";
	}

	@Action(value = "initLogin", results = { @Result(name = "input", location = "pages/login.jsp") })
	public String init() {
		return INPUT;
	}
}