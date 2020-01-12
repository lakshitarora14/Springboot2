package com.training.demoemployee.repository;

import com.training.demoemployee.entity.Department;
import com.training.demoemployee.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

}
