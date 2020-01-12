package com.training.demoemployee.service.impl;

import com.training.demoemployee.entity.Department;
import com.training.demoemployee.entity.Employee;
import com.training.demoemployee.repository.DepartmentRepository;
import com.training.demoemployee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department){
        return departmentRepository.save(department);

    }

    @Override
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }
}
