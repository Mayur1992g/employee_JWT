package com.emp.employee.service;

import com.emp.employee.model.Employee;
import com.emp.employee.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {


    Employee updateEmployee(EmployeeDTO employeeDTO);

    Employee creatEmployee(EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long userId);

    boolean deleteEmployee(Long employeeId);

    List<Employee> getAllEmployee();
}
