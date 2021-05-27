package com.codegym.demo.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class FuramaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;

    @OneToMany(mappedBy = "furamaRole")
    private List<FuramaUserRole> furamaUserRoles;

    public FuramaRole() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<FuramaUserRole> getFuramaUserRoles() {
        return furamaUserRoles;
    }

    public void setFuramaUserRoles(List<FuramaUserRole> furamaUserRoles) {
        this.furamaUserRoles = furamaUserRoles;
    }
}
