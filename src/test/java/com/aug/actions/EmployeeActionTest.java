package com.aug.actions;

import java.util.ArrayList;
import java.util.List;

import com.aug.entities.Employee;
import com.aug.services.EmployeeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class EmployeeActionTest {

	@Mock
    private EmployeeService mockEmployeeService;
	
	private Employee employee;
	
    private EmployeeAction employeeAction;
    private List <Employee> employees = new ArrayList <Employee> ();
    @Before
	public void setUp() {
        employeeAction = new EmployeeAction();
		employeeAction.setEmployeeService(mockEmployeeService);
	}

	@Test
	public void list() throws Exception {
		when(mockEmployeeService.findAll()).thenReturn(employees);
        assertThat(employeeAction.lists(), is(equalTo("welcome")));

        verify(mockEmployeeService, times(1)).findAll();
	}
	
	@Test
	public void save() throws Exception {
		when(mockEmployeeService.save(employee)).thenReturn(true);
        assertThat(employeeAction.save(), is(equalTo("success")));

        verify(mockEmployeeService, times(1)).save(employee);
	}

}