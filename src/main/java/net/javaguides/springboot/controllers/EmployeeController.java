package net.javaguides.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.models.EmployeeModel;
import net.javaguides.springboot.repositories.EmployeeRepository;
import net.javaguides.springboot.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public String addEmployee(@RequestBody EmployeeModel employeeData) {
		EmployeeModel empModel = employeeRepository.findByEmpName(employeeData.empName);
		if (empModel != null) {
			if (empModel.getStatus()) {
				return "please logout";
			}
			else {
				empModel.setStatus(true);
				employeeRepository.save(empModel);
				return "Saved";
			}
		} else {
			return employeeService.addEmployee(employeeData);
		}
	}

	@PostMapping("/logout")
	public String logoutEmployee(@RequestBody EmployeeModel employeeData) {
		EmployeeModel empModel = employeeRepository.findByEmpName(employeeData.empName);
		empModel.setStatus(false);
		employeeRepository.save(empModel);
		return "logged Out";
	}
}
