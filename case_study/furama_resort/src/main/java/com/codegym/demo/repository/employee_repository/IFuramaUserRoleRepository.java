package com.codegym.demo.repository.employee_repository;

import com.codegym.demo.model.employee.FuramaUserRole;
import com.codegym.demo.model.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuramaUserRoleRepository extends JpaRepository<FuramaUserRole, Integer> {
    FuramaUserRole findByFuramaUser(FuramaUser furamaUser);
}
