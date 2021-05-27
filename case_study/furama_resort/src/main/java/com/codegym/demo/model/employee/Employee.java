package com.codegym.demo.model.employee;

import com.codegym.demo.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @Pattern(regexp = "^(NV-)\\d{4}$", message = "Định dạng NV-XXXX")
    private String employeeId;

    @NotEmpty
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$", message = "Không được bỏ trống hoặc chứa số")
    private String employeeName;

    @NotEmpty
    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "Đúng định dạng YYYY-MM-DD")
    private String employeeBirthDay;

    @NotEmpty
    private String employeeGender;

    @NotEmpty
    @Pattern(regexp = "^\\d{9}$", message = "CMND 9 số")
    private String employeeIdCard;

    @NotNull(message = "Please provide a price")
    @Min(value = 1, message = "Không được nhập số âm")
    private Double employeeSalary;

    @NotEmpty
    @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Đúng định dạng 090|091|(84+)")
    private String employeePhone;


    @NotEmpty(message = "Không được để trống")
    @Email(message = "không đúng định dạng abc@abc.abc")
    private String employeeEmail;

    @NotEmpty(message = "Không được để trống")
    private String employeeAddress;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "education_id", referencedColumnName = "educationId")
    private Education education;


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
    private FuramaUser furamaUser;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> contracts;

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public FuramaUser getFuramaUser() {
        return furamaUser;
    }

    public void setFuramaUser(FuramaUser furamaUser) {
        this.furamaUser = furamaUser;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
