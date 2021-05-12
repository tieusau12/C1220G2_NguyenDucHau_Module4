package com.codegym.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Min(value = 18, message = "Not enough 18")
    @Max(value = 100, message = "Over age")
    private Integer age;
    private String email;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Integer age = user.getAge();
        String email = user.getEmail();

        //Validate phoneNumber
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }

        //Validate firstName
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        if (firstName.length() < 5 || phoneNumber.length() > 45) {
            errors.rejectValue("firstName", "firstName.length");
        }

        //Validate lastName
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        if (lastName.length() < 5 || phoneNumber.length() > 45) {
            errors.rejectValue("lastName", "lastName.length");
        }

        //Validate email
        String regex = "^[a-z]+@[a-z]+([.][a-z]{2,})+$";
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!email.matches(regex)) {
            errors.rejectValue("email", "email.matches");
        }

//        //Validate age
//        ValidationUtils.rejectIfEmpty(errors, "age","age.empty");
//        if (user.age<18){
//            errors.rejectValue("age","age.enough");
//        }
    }
}
