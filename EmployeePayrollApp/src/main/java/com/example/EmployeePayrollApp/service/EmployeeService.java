package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.entity.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Fetch an employee by id
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Create a new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee); // Save the employee (ID will be generated automatically)
    }

    // Update an employee (do not set the ID)
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setPosition(employee.getPosition());
            updatedEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(updatedEmployee); // Save the updated employee without changing the ID
        }
        return null; // Employee not found
    }

    // Delete an employee by ID
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true; // Employee deleted successfully
        }
        return false; // Employee not found
    }
}
