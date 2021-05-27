package com.codegym.demo.repository.employee_repository;

import com.codegym.demo.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {
}
