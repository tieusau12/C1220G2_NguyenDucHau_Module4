package com.codegym.demo.service.employee_service.impl;

import com.codegym.demo.model.employee.*;
import com.codegym.demo.repository.employee_repository.*;
import com.codegym.demo.service.employee_service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IDivisionRepository divisionRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Autowired
    private IEducationRepository educationRepository;

    @Autowired
    private IFuramaUserRepository furamaUserRepository;

    @Autowired
    private IFuramaUserRoleRepository furamaUserRoleRepository;

    @Autowired
    private IFuramaRoleRepository furamaRoleRepository;

    @Override
    public void saveEmployee(Employee employee) {
        FuramaUser user = new FuramaUser();
        user.setUserName(employee.getEmployeeEmail());
        user.setPassword("$2a$10$J.LIrjLPOety7nKmSnSABu9AQZuTSgye3LZAJ66tOc0vzt0LM4WuK");
        furamaUserRepository.save(user);

        if (employee.getPosition().getPositionId() == 1 ||employee.getPosition().getPositionId() == 2|| employee.getPosition().getPositionId() == 3){
            FuramaRole role = furamaRoleRepository.findById(1).orElse(null);
            FuramaUserRole userRole = new FuramaUserRole();
            userRole.setFuramaUser(user);
            userRole.setFuramaRole(role);
            furamaUserRoleRepository.save(userRole);
        }else {
            FuramaRole role = furamaRoleRepository.findById(2).orElse(null);
            FuramaUserRole userRole = new FuramaUserRole();
            userRole.setFuramaUser(user);
            userRole.setFuramaRole(role);
            furamaUserRoleRepository.save(userRole);
        }
        employee.setFuramaUser(user);
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        Employee employee1 = employee;
        System.out.println(employee1);
        FuramaUser  user= employee.getFuramaUser();
        FuramaUserRole userRole = furamaUserRoleRepository.findByFuramaUser(user);
        if (employee.getPosition().getPositionId() == 1 ||employee.getPosition().getPositionId() == 2|| employee.getPosition().getPositionId() == 3){
            FuramaRole role = furamaRoleRepository.findById(1).orElse(null);
            userRole.setFuramaRole(role);
            furamaUserRoleRepository.save(userRole);
        }else {
            FuramaRole role = furamaRoleRepository.findById(2).orElse(null);
            userRole.setFuramaRole(role);
            furamaUserRoleRepository.save(userRole);
        }
    employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<Education> findAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public Page<Employee> findEmployeeByName(Pageable pageable, String name) {
        return employeeRepository.findAllByEmployeeNameContaining(pageable, name);
    }

    @Override
    public Employee findByUserName(String name) {
        return employeeRepository.findByFuramaUserUserName(name);
    }

    @Override
    public String checkDuplicate(Employee employee) {
        if (employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail()) != null) {
            return "Email đã tồn tại";
        } else if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            return "Mã khách hàng đã tồn tại";
        }
        return null;
    }
}
