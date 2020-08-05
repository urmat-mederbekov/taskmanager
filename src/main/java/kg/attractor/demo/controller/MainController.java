package kg.attractor.demo.controller;

import kg.attractor.demo.form.UserForm;
import kg.attractor.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@AllArgsConstructor
@Controller
public class MainController {

    private final UserService userService;

    @GetMapping
    public String indexPage(Model model, Principal principal){

        userService.checkUserPresence(model, principal);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model, Principal principal){

        userService.checkUserPresence(model, principal);
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model, Principal principal){

        userService.checkUserPresence(model, principal);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm,
                          BindingResult validationResult,
                          RedirectAttributes attributes){

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        userService.addUser(userForm);
        return "redirect:/login";
    }

}
