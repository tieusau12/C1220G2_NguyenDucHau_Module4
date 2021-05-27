package com.codegym.demo.repository.employee_repository;

import com.codegym.demo.model.employee.FuramaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuramaUserRepository extends JpaRepository<FuramaUser, String> {
    FuramaUser findByUserName(String userName);
}
