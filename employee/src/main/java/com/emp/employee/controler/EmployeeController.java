package com.emp.employee.controler;

import com.emp.employee.model.Employee;
import com.emp.employee.model.dto.EmployeeDTO;
import com.emp.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@CrossOrigin("*")
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		
		Employee employeeRes = employeeService.creatEmployee(employeeDTO);
		if(employeeRes == null) {
			return ResponseEntity.ok("Employee_ALREADY_REGISTER");
		}
		return ResponseEntity.ok(employeeRes);
	}
	
	@PutMapping("/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		Employee updatedEmployee = employeeService.updateEmployee(employeeDTO);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/")
	public boolean deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	
	@GetMapping("/All")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
}
