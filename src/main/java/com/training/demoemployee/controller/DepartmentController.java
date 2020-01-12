package com.training.demoemployee.controller;

import com.training.demoemployee.dto.DepartmentDTO;
import com.training.demoemployee.entity.Department;
import com.training.demoemployee.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/add")
    public ResponseEntity<Integer> addOrUpdateDepartment(@RequestBody DepartmentDTO departmentDTO)
    {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO,department);
        Department departmentCreated = departmentService.save(department);
        return new ResponseEntity<Integer>(departmentCreated.getId(),HttpStatus.CREATED);
    }
    @GetMapping(value="/read")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment()
    {
        Iterable<Department> departmentIterable= departmentService.findAll();
        List<DepartmentDTO> departmentDTOList=new ArrayList<>();
        for (Department department:departmentIterable)
        {
            DepartmentDTO departmentDTO=new DepartmentDTO();
            BeanUtils.copyProperties(department,departmentDTO);
            departmentDTOList.add(departmentDTO);
        }
        return new ResponseEntity<List<DepartmentDTO>>(departmentDTOList,HttpStatus.OK);
    }
    @GetMapping(value="/cd/{parentId}")
    public ResponseEntity<List<DepartmentDTO>> getChild(@PathVariable("parentId") int dep)
    {
        Iterable<Department> departmentIterable= departmentService.findAll();
        List<DepartmentDTO> departmentDTOList=new ArrayList<>();
        for (Department department:departmentIterable)
        {
            if(department.getParentDepartment() == dep) {
                DepartmentDTO departmentDTO = new DepartmentDTO();
                BeanUtils.copyProperties(department, departmentDTO);
                departmentDTOList.add(departmentDTO);
            }
        }
        return new ResponseEntity<List<DepartmentDTO>>(departmentDTOList,HttpStatus.OK);


    }




}
