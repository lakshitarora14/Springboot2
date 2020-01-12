package com.training.demoemployee.service;

import com.training.demoemployee.entity.Department;

public interface DepartmentService {
    Department save(Department department);

    Iterable<Department> findAll();
}
