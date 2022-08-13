package net.javaguides.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.models.EmployeeModel;
import net.javaguides.springboot.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public String addEmployee(EmployeeModel employee) {
		employeeRepository.save(employee);
		return "Saved";
	}
}
