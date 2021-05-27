package com.codegym.demo.model.employee;

import javax.persistence.*;

@Entity
public class FuramaUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserRole;

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
    private FuramaUser furamaUser;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    private FuramaRole furamaRole;

    public FuramaUserRole() {
    }

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public FuramaUser getFuramaUser() {
        return furamaUser;
    }

    public void setFuramaUser(FuramaUser furamaUser) {
        this.furamaUser = furamaUser;
    }

    public FuramaRole getFuramaRole() {
        return furamaRole;
    }

    public void setFuramaRole(FuramaRole furamaRole) {
        this.furamaRole = furamaRole;
    }
}
