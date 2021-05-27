package com.codegym.demo.repository.services_repository;

import com.codegym.demo.model.services.RentTypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenTypeRepository extends JpaRepository<RentTypeService, Integer> {
}
