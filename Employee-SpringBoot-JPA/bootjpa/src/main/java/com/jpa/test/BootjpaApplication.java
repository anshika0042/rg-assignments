package com.jpa.test;

import com.jpa.test.dao.EmployeeRepository;
import com.jpa.test.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class BootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaApplication.class, args);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

//		---INSERT---
//		Employee employee = new Employee();
//		employee.setName("Shyam");
//		employee.setDepartment("Electrical");
//		Employee result = employeeRepository.save(employee);
//		System.out.println(result);

//		---UPDATE---
//		Optional<Employee> optional = employeeRepository.findById(1);
//		Employee employee = optional.get();
//		employee.setName("Ankit");
//		Employee employee1 = employeeRepository.save(employee);
//		System.out.println(employee1);

//		---DELETE---
//		employeeRepository.deleteById(2);
//		System.out.println("Deleted");

//		---Fetch---
		Iterable<Employee> allemployee = employeeRepository.findAll();
		allemployee.forEach(employee->System.out.println(employee));

		//To delete all we can also write:
		// employeeRepository.deleteAll(allemployee)
	}
}
