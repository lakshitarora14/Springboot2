package com.training.demoemployee.repository;

import com.training.demoemployee.entity.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization,Integer> {
}
