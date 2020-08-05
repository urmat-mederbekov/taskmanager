package kg.attractor.demo.controller;

import kg.attractor.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;

}