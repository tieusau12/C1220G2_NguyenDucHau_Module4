package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class CondimentsController {
    @RequestMapping("/save")
    public String save() {
        return "select";
    }

        @PostMapping("/save")
    public String select(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "index";
    }
    @PostMapping("/save")
    public ModelAndView select(@RequestParam(name = "condiment", required = false, defaultValue = "") String condiment) {
        String result = "Sandwich condiments with " + condiment;
        return new ModelAndView("index", "result", result);

    }
}
