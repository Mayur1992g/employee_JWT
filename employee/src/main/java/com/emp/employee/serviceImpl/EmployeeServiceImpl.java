package com.emp.employee.serviceImpl;

import com.emp.employee.model.Employee;
import com.emp.employee.model.dto.EmployeeDTO;
import com.emp.employee.repository.EmployeeRepository;
import com.emp.employee.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public EmployeeRepository employeeRepository;


    @Override
    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        Employee em = modelMapper.map(employeeDTO , Employee.class);
        return employeeRepository.save(em);
    }

    @Override
    @Transactional
    public Employee creatEmployee(EmployeeDTO employeeDTO) {
        Employee em = modelMapper.map(employeeDTO , Employee.class);
        return employeeRepository.save(em);
    }


    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
         employeeRepository.deleteById(employeeId);
         return true;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
