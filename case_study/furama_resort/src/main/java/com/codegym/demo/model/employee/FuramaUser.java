package com.codegym.demo.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class FuramaUser {
    @Id
    private String userName;

    private String password;

    @OneToMany(mappedBy = "furamaUser", cascade = CascadeType.ALL)
    private List<FuramaUserRole> furamaUserRoles;


    @OneToOne(mappedBy = "furamaUser")
    private Employee employee;

    public FuramaUser() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FuramaUserRole> getFuramaUserRoles() {
        return furamaUserRoles;
    }

    public void setFuramaUserRoles(List<FuramaUserRole> furamaUserRoles) {
        this.furamaUserRoles = furamaUserRoles;
    }
}
