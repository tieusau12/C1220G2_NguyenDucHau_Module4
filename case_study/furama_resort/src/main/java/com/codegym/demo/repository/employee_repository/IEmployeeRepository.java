package com.codegym.demo.repository.employee_repository;

import com.codegym.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);

    Employee findByFuramaUserUserName(String userName);

    Employee findByEmployeeEmail(String Email);
}
