package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @RequestMapping("/calculator")
    public String getCalculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String result(@RequestParam(name = "firstNumber", required = false, defaultValue = "xx") double firstNumber,
                         @RequestParam(name = "secondNumber", required = false, defaultValue = "xx") double secondNumber,
                         @RequestParam(name = "operator", required = false, defaultValue = "xx") String operator, Model model
    ) {
        Double result;
        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
        } else {
            result = firstNumber / secondNumber;
        }
        model.addAttribute("firstNumber",firstNumber);
        model.addAttribute("secondNumber",secondNumber);
        model.addAttribute("operator",operator);
        model.addAttribute("result",result);
        return "index";
    }
}
