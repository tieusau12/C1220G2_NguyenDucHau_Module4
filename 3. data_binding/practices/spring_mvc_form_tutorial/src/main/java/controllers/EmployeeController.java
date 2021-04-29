package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @RequestMapping
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }
    @PostMapping("/addEmployee")
    public String submit (@ModelAttribute("employee") Employee employee, ModelMap modelMap){
        modelMap.addAttribute("name",employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id",employee.getId());
        return"info";
    }


}
