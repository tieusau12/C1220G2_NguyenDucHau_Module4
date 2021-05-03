package controllers;

import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailControllers {
    @GetMapping()
    public String referenceData(Model model) {
        model.addAttribute("email" , new Email());
        List<String> listLanguage = new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        model.addAttribute("listLanguage", listLanguage);


        List<String> listPageSize = new ArrayList<>();
        listPageSize.add("5");
        listPageSize.add("10");
        listPageSize.add("15");
        listPageSize.add("25");
        listPageSize.add("50");
        listPageSize.add("100");
        model.addAttribute("listPageSize", listPageSize);
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView save (@ModelAttribute Email email){
        return new ModelAndView("save","email", email)  ;
    }
}
