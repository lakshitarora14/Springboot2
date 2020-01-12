package com.training.demoemployee.controller;

import com.training.demoemployee.dto.EmployeeDTO;
import com.training.demoemployee.entity.Employee;
import com.training.demoemployee.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<Integer> addOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        Employee departmentCreated = employeeService.save(employee);
        return new ResponseEntity<Integer>(departmentCreated.getId(),HttpStatus.CREATED);
    }
    @GetMapping(value="/read")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    {
        Iterable<Employee> employeeIterable= employeeService.findAll();
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        for (Employee employee:employeeIterable)
        {
            EmployeeDTO employeeDTO=new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }

        return new ResponseEntity<List<EmployeeDTO>>(employeeDTOList,HttpStatus.OK);
    }
}
