package com.aug.daos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.entities.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class EmployeeDaoTest {

	@Autowired
	private EmployeeDao employeeDao;

	private Employee employee;

	@Before
	public void setUp() {
		employee = new Employee();
		employee.setEmail("admin");
		employee.setPassword("password");
	}

	@Test
	public void shouldBeReternNotEmptyEmployee() {
		employeeDao.save(employee);
		assertThat(employeeDao.findAll().size(), IsNot.not(0));
	}
	@Test
	public void shouldNotSaveEmployee() {

		assertThat(employeeDao.findUserByEmailPassword(employee).size(), is(0));
	}

	@Test
	public void shouldReturnUserListWhenEmailAndPasswordExistInDB() {
		assertThat(employeeDao.findUserByEmailPassword(employee).size(), is(1));
	}

	@Test
	public void shouldNotReturnUserWhenEmailDoesNotExistInDB() {
		employee.setEmail("admin1");
		assertThat(employeeDao.findUserByEmailPassword(employee).size(), is(0));
	}

	@Test
	public void shouldNotReturnUserWhenPasswordDoesNotExistInDB() {
		employee.setPassword("fakepassword");
		assertThat(employeeDao.findUserByEmailPassword(employee).size(), is(0));
	}

	@Test
	public void shouldSaveEmployee() {
		employee.setEmail("test4@gmail.com");
		employee.setPassword("test4");
		employeeDao.save(employee);
		assertThat(employeeDao.findUserByEmailPassword(employee).size(), is(1));
	}

}