package com.training.demoemployee.controller;

import com.training.demoemployee.dto.OrganizationDTO;
import com.training.demoemployee.entity.Organization;
import com.training.demoemployee.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "add")
    public ResponseEntity<Integer> addOrUpdateDepartment(@RequestBody OrganizationDTO organizationDTO)
    {
        Organization organization = new Organization();
        BeanUtils.copyProperties(organizationDTO,organization);
        Organization organizationCreated = organizationService.save(organization);
        return new ResponseEntity<Integer>(organizationCreated.getId(),HttpStatus.CREATED);
    }
}
