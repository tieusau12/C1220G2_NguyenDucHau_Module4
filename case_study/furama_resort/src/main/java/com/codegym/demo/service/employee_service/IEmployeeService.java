package com.codegym.demo.service.employee_service;

import com.codegym.demo.model.employee.Division;
import com.codegym.demo.model.employee.Education;
import com.codegym.demo.model.employee.Employee;
import com.codegym.demo.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    void saveEmployee(Employee employee);

    void editEmployee(Employee employee);

    Page<Employee> findAllEmployee(Pageable pageable);

    void deleteEmployee(String id);

    Employee findById(String id);

    List<Division> findAllDivision();

    List<Position> findAllPosition();

    List<Education> findAllEducation();

    Page<Employee> findEmployeeByName(Pageable pageable, String name);

    Employee findByUserName(String name);

    String checkDuplicate(Employee employee);
}
