package com.training.demoemployee.service.impl;

import com.training.demoemployee.entity.Employee;
import com.training.demoemployee.repository.EmployeeRepository;
import com.training.demoemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);

    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
