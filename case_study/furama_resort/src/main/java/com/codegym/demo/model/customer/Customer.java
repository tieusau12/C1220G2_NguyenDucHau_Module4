package com.codegym.demo.model.customer;

import com.codegym.demo.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Định dạng KH-XXXX")
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId", nullable = false)
    private CustomerType customerType;

    @NotEmpty
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$", message = "Không được bỏ trống hoặc chứa số")
    private String customerName;


    @NotEmpty
    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])", message = "Đúng định dạng YYYY-MM-DD")
    private String customerBirthDay;

    @NotEmpty
    private String customerGender;

    @NotEmpty
    @Pattern(regexp = "^\\d{9}$", message = "CMND 9 số")
    private String customerIdCard;

    @NotEmpty
    @Pattern(regexp = "^[0-9\\-\\+]{9,15}$", message = "Đúng định dạng 090|091|(84+)")
    private String customerPhone;

    @Email(message = "Email phải đúng định dạng")
    @NotEmpty(message = "Không được để trống")
    private String customerEmail;

    @NotEmpty(message = "Không được để trống")
    private String customerAddress;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Contract> contracts;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Customer customer = (Customer) target;
//        String idCustomer = customer.getCustomerId();
//    }
}
