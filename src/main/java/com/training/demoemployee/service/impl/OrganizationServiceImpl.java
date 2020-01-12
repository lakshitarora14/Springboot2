package com.training.demoemployee.service.impl;

import com.training.demoemployee.entity.Employee;
import com.training.demoemployee.entity.Organization;
import com.training.demoemployee.repository.OrganizationRepository;
import com.training.demoemployee.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization save(Organization organization){
        return organizationRepository.save(organization);

    }
}
