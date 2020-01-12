package com.training.demoemployee.service;

import com.training.demoemployee.entity.Employee;
import com.training.demoemployee.repository.EmployeeRepository;

public interface EmployeeService {
    Employee save(Employee employee);

    Iterable<Employee> findAll();
}
