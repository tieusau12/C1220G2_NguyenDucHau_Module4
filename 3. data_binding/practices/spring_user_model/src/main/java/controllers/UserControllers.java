package controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import dao.UserDao;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserControllers {
    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserDao.checkLogin(login);
        if (user == null) {
            return new ModelAndView("error");
        } else {
            return new ModelAndView("user", "user", user);
        }
    }
}
